package uz.gita.hwlesson17draganddropgame.contracts.Impl

import uz.gita.hwlesson17draganddropgame.R
import uz.gita.hwlesson17draganddropgame.contracts.QuizContract
import uz.gita.hwlesson17draganddropgame.model.DataModel
import kotlin.collections.ArrayList

class RepositoryImpl : QuizContract.Repository {
    private var dataList: ArrayList<DataModel> = arrayListOf(
        DataModel(R.drawable.olma, arrayListOf("l", "o", "m", "a"), "olma"),
        DataModel(R.drawable.nok, arrayListOf("k", "o", "n"), "nok"),
        DataModel(R.drawable.uzum, arrayListOf("u", "u", "z", "m"), "uzum"),
    )

    override fun getVariants(questionIndex: Int): ArrayList<String> = dataList[questionIndex].variants


    override fun setVariants(questionIndex: Int, newVariants: ArrayList<String>) {
        dataList[questionIndex].variants = newVariants
    }

    override fun getAnswer(questionIndex: Int): String = dataList[questionIndex].answer

    override fun getImg(questionIndex: Int): Int = dataList[questionIndex].img
}