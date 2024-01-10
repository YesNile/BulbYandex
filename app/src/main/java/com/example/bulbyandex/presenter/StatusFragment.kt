package com.example.bulbyandex.presenter

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.bulbyandex.R
import com.example.bulbyandex.UiState
import com.example.bulbyandex.di.ViewModelInd
import com.example.bulbyandex.di.appComponent
import com.google.android.material.slider.Slider
import com.example.bulbyandex.data.DataColor
import com.example.bulbyandex.databinding.FragmentMainBinding
import javax.inject.Inject

class StatusFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding()


    @Inject
    lateinit var viewModelFactory: ViewModelInd

    private val viewModel: StatusViewModel by viewModels() { viewModelFactory }


    private fun setCurrentColor(
        currentColor: UiState<DataColor?>?,
        colors: UiState<List<String>?>?
    ) {
        when {
            currentColor is UiState.Success && colors is UiState.Success -> {
                val position = currentColor.value?.let { colors.value?.indexOf(it.color) } ?: -1
                if (position != -1) {
                    binding.colorSpinner.setSelection(position)
                }
                binding.colorSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        val selectedColor = parent?.getItemAtPosition(position) as String
                        viewModel.setColor(selectedColor)
                    }
                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        setCurrentColor(viewModel.currentColor.value, viewModel.colors.value)
                    }
                }
            }
            else -> {}
        }
    }

    private fun setColors(colors: UiState<List<String>?>) {
        when(colors){
            is UiState.Success -> {
                val spinnerAdapter = StatusAdapter(requireContext(), colors.value)
                binding.colorSpinner.adapter = spinnerAdapter
                colors.value?.let {
                    spinnerAdapter.submitList(it)
                }
            }
            else -> {}
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner) {
            setSwitch(it)
        }
        viewModel.getState()

        viewModel.colors.observe(viewLifecycleOwner) {
            setColors(it)
        }
        viewModel.loadColors()

        viewModel.currentColor.observe(viewLifecycleOwner) {
            setCurrentColor(it, viewModel.colors.value)
        }
        viewModel.getCurrentColor()

        viewModel.currentBrightness.observe(viewLifecycleOwner) {
            setBrightness(it)
        }
        viewModel.getBrightness()
    }

    private fun setBrightness(brightness: UiState<Int?>?) {
        when(brightness){
            is UiState.Success -> {
                binding.brightnessSlider.value = brightness.value!!.toFloat()
                binding.brightnessSlider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
                    override fun onStartTrackingTouch(slider: Slider) {

                    }

                    override fun onStopTrackingTouch(slider: Slider) {
                        viewModel.setBrightness(slider.value.toInt())
                    }
                })
            }
            else -> {}
        }
    }

    private fun setSwitch(state: UiState<Boolean?>?) {
        when(state) {
            is UiState.Success -> {
                binding.switchLamp.visibility = View.VISIBLE
                binding.brightnessSlider.visibility = View.VISIBLE
                binding.colorSpinner.visibility = View.VISIBLE
                binding.sampleProgress.visibility = View.GONE
                binding.errorImage.visibility = View.GONE
                binding.errorTitle.visibility = View.GONE
                binding.errorSubtitle.visibility = View.GONE
                binding.switchLamp.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        binding.switchLamp.text = "Включено"
                        viewModel.turnOn()
                        viewModel.loadColors()

                        viewModel.getCurrentColor()
                        binding.colorSpinner.adapter?.let { adapter ->
                            if (adapter is StatusAdapter) {
                                adapter.submitUiList(viewModel.colors.value)
                            }
                        }
                        viewModel.getBrightness()
                        setBrightness(viewModel.currentBrightness.value)
                        setCurrentColor(viewModel.currentColor.value, viewModel.colors.value)
                    } else {
                        viewModel.turnOff()
                        binding.switchLamp.text = "Выключено"
                        binding.colorSpinner.adapter?.let { adapter ->
                            if (adapter is StatusAdapter) {
                                adapter.clearList()
                            }
                        }
                    }
                }
                binding.switchLamp.isChecked = state.value!!
            }
            is UiState.Failure -> {
                binding.switchLamp.visibility = View.GONE
                binding.brightnessSlider.visibility = View.GONE
                binding.colorSpinner.visibility = View.GONE
                binding.sampleProgress.visibility = View.GONE
                binding.errorImage.visibility = View.VISIBLE
                binding.errorTitle.visibility = View.VISIBLE
                binding.errorSubtitle.visibility = View.VISIBLE
                binding.errorSubtitle.text = state.message
            }
            is UiState.Loading -> {
                binding.switchLamp.visibility = View.GONE
                binding.brightnessSlider.visibility = View.GONE
                binding.colorSpinner.visibility = View.GONE
                binding.sampleProgress.visibility = View.VISIBLE
                binding.errorImage.visibility = View.GONE
                binding.errorTitle.visibility = View.GONE
                binding.errorSubtitle.visibility = View.GONE
            }

            else -> {}
        }
    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }
}