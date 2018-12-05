package l.b.v.udacitytestapp.lesson3Navigation.fragment


import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import l.b.v.udacitytestapp.R
import l.b.v.udacitytestapp.databinding.FragmentGameOverBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class GameOverFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var binding = DataBindingUtil.inflate<FragmentGameOverBinding>(inflater, R.layout.fragment_game_over, container, false)
        binding.tryAgainButton.setOnClickListener { it.findNavController().navigate(R.id.action_gameOverFragment_to_gameFragment) }

        var args = GameWonFragmentArgs.fromBundle(arguments)
        Toast.makeText(context, "Total questions: ${args.numQuestions}, Questions correct: ${args.numCorrect}", Toast.LENGTH_LONG).show()

        return binding.root

    }


}
