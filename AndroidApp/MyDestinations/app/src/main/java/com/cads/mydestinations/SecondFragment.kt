package com.cads.mydestinations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.cads.mydestinations.databinding.FragmentSecondBinding
import com.cads.mydestinations.model.DestViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: DestViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        binding.apply{
            viewModel = viewModel
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val city: String = binding.etCity.text.toString()
            val country :String = binding.etCountry.text.toString()
            if(city.isEmpty() || country.isEmpty()){
                Toast.makeText(requireContext(), "City or Country cant be empty! ", Toast.LENGTH_SHORT).show()
            }
            else{
                viewModel.postDestination(city, country)
                Toast.makeText(requireContext(), "Destination Added!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}