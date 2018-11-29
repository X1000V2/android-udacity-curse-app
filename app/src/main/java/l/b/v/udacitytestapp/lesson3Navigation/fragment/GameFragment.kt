package l.b.v.udacitytestapp.lesson3Navigation.fragment


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import l.b.v.udacitytestapp.R
import l.b.v.udacitytestapp.databinding.FragmentGameBinding
import l.b.v.udacitytestapp.lesson3Navigation.data.Game
import l.b.v.udacitytestapp.lesson3Navigation.data.Question

/**
 * A simple [Fragment] subclass.
 *
 */
class GameFragment : Fragment() {

    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "What is Android Jetpack?",
            answers = listOf("all of these", "tools", "documentation", "libraries"),
            correct = 0
        ),
        Question(text = "Base class for Layout?", answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot"),correct = 3)/*,
        Question(text = "Layout for complex Screens?", answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout"), correct = 0),
        Question(text = "Pushing structured data into a Layout?", answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick"),correct = 0),
        Question(text = "Inflate layout in fragments?", answers = listOf("onCreateView", "onActivityCreated", "onCreateLayout", "onInflateLayout"),correct = 0),
        Question(text = "Build system for Android?", answers = listOf("Gradle", "Graddle", "Grodle", "Groyle"),correct = 0),
        Question(text = "Android vector format?", answers = listOf("VectorDrawable", "AndroidVectorDrawable", "DrawableVector", "AndroidVector"),correct = 0),
        Question(text = "Android Navigation Component?", answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher"), correct = 0),
        Question(text = "Registers app with launcher?", answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher"),correct = 0),
        Question(text = "Mark a layout for Data Binding?", answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>"), correct = 0)*/
    )

    private var mGame: Game? = null
    private var questionIndex: Int = 0
    private var answersUser = mutableListOf<Int>()
    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //data binding
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        //set the first question
        setData(0)
        binding.submitButton.setOnClickListener { view: View ->
            submitButtonClick(
                view,
                binding.questionRadioGroup.checkedRadioButtonId
            )
        }
        binding.invalidateAll()
        return binding.root
    }

    private fun setData(index: Int) {
        questionIndex = index
        mGame = Game(questions[index], questions[index].answers)
        binding.game = mGame
    }

    private fun submitButtonClick(view: View, checkedRadioButtonId: Int) {

        //save user anwser and go to the next question
        when (checkedRadioButtonId) {
            R.id.firstAnswerRadioButton -> answersUser.add(0)
            R.id.secondAnswerRadioButton -> answersUser.add(1)
            R.id.thirdAnswerRadioButton -> answersUser.add(2)
            R.id.fourthAnswerRadioButton -> answersUser.add(3)
        }

        if (questionIndex < questions.size - 1) {
            questionIndex++
            setData(questionIndex)
        } else {
            //evaluate if the user wins
            if (chekAnswers()) {
                view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameWonFragment(questions.size, answersCorrect()))
            } else {
                view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToGameOverFragment(questions.size, answersCorrect()))
            }
        }
    }

    private fun chekAnswers(): Boolean {

        return getCorrectList().equals(answersUser)
    }

    private fun answersCorrect(): Int {
        var countCorrect = 0

        getCorrectList().forEachIndexed { index, i ->
            if (i == answersUser[index]) {
                countCorrect++
            }
        }
        return countCorrect
    }

    private fun getCorrectList(): List<Int> {
        return questions.map { question ->
            question.correct
        }
    }

}
