package uz.gita.hwlesson17draganddropgame.contracts

class QuizContract {
    interface Repository {
        fun getVariants(questionIndex: Int): ArrayList<String>
        fun setVariants(questionIndex: Int, newVariants: ArrayList<String>)
        fun getAnswer(questionIndex: Int): String
        fun getImg(questionIndex: Int): Int
    }

    interface View {
        fun init()
        fun loadAdapter(dataList: ArrayList<String>)
        fun loadImage(image: Int)
    }

    interface Presenter {
        fun onMove(from: Int, to: Int)
        fun checkClick()
        fun getVariants(questionIndex: Int)
        fun getAnswer(questionIndex: Int): String
        fun getImg(questionIndex: Int): Int
    }
}