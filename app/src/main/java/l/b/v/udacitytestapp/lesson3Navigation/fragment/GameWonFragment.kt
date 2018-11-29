package l.b.v.udacitytestapp.lesson3Navigation.fragment


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import l.b.v.udacitytestapp.R
import l.b.v.udacitytestapp.databinding.FragmentGameWonBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class GameWonFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var binding = DataBindingUtil.inflate<FragmentGameWonBinding>(inflater, R.layout.fragment_game_won,container,false)
        binding.nextMatchButton.setOnClickListener { view -> view.findNavController().navigate(R.id.action_gameWonFragment_to_titleFragment) }
        return binding.root
    }


}
