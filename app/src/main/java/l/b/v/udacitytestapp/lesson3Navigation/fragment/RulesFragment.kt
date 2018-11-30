package l.b.v.udacitytestapp.lesson3Navigation.fragment


import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import l.b.v.udacitytestapp.R
import l.b.v.udacitytestapp.databinding.FragmentRulesBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class RulesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rules, container, false)
    }


}
