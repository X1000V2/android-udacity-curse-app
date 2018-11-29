package l.b.v.udacitytestapp.lesson3Navigation.fragment


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import l.b.v.udacitytestapp.R
import l.b.v.udacitytestapp.databinding.FragmentGameOverBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class GameOverFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var binding = DataBindingUtil.inflate<FragmentGameOverBinding>(inflater, R.layout.fragment_game_over, container, false)
        return binding.root

    }


}
