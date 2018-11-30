package l.b.v.udacitytestapp.lesson3Navigation.fragment


import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.Toast
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

        var args = GameWonFragmentArgs.fromBundle(arguments)
        Toast.makeText(context, "Total questions: ${args.numQuestions}, Questions correct: ${args.numCorrect}",Toast.LENGTH_LONG).show()

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.winner_menu, menu)

        //Check if there is an app to respond to action share
        if(getShareIntent().resolveActivity(activity!!.packageManager) == null){
            menu?.findItem(R.id.option_share)?.setVisible(false)
        }else{
            menu?.findItem(R.id.option_share)?.setVisible(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.option_share -> startActivity(getShareIntent())
        }
        return false
    }

    fun getShareIntent():Intent{
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        var args = GameWonFragmentArgs.fromBundle(arguments)
        intent.putExtra(Intent.EXTRA_TEXT,getString(R.string.share_success_text,args.numCorrect,args.numQuestions))
        return intent
    }


}
