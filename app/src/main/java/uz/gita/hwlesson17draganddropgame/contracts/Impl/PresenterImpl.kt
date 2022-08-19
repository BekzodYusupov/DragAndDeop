package uz.gita.hwlesson17draganddropgame.contracts.Impl

import uz.gita.hwlesson17draganddropgame.contracts.QuizContract

class PresenterImpl(
    private val repository: QuizContract.Repository,
    private val view: QuizContract.View,
) : QuizContract.Presenter {

    private var questionIndex = 0

    init {
        view.init()
        view.loadAdapter(repository.getVariants(questionIndex))
        view.loadImage(repository.getImg(questionIndex))
    }

    override fun onMove(from: Int, to: Int) {
        val tempVariants = repository.getVariants(questionIndex)
        val tempVariant: String = tempVariants[from]
        tempVariants.removeAt(from)
        tempVariants.add(to, tempVariant)
        repository.setVariants(questionIndex, tempVariants)

        view.loadAdapter(repository.getVariants(questionIndex))
    }

    override fun checkClick() {
        if (check()) {
            questionIndex++
            if (questionIndex == 3) questionIndex = 0
            view.loadAdapter(repository.getVariants(questionIndex))
            view.loadImage(repository.getImg(questionIndex))
        }
    }

    private fun check(): Boolean {
        val userAnswer = repository.getVariants(questionIndex)
        val answer = repository.getAnswer(questionIndex)
        var answerFromList = ""

        for (i in 0 until userAnswer.size) {
            answerFromList += repository.getVariants(questionIndex)[i]
        }
        return answerFromList == answer
    }

    override fun getVariants(questionIndex: Int) = view.loadAdapter(repository.getVariants(questionIndex))
    override fun getAnswer(questionIndex: Int): String = repository.getAnswer(questionIndex)
    override fun getImg(questionIndex: Int): Int = repository.getImg(questionIndex)

}