package uz.gita.hwlesson17draganddropgame.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import uz.gita.hwlesson17draganddropgame.R
import uz.gita.hwlesson17draganddropgame.adapters.QuizAdapter
import uz.gita.hwlesson17draganddropgame.contracts.Impl.PresenterImpl
import uz.gita.hwlesson17draganddropgame.contracts.Impl.RepositoryImpl
import uz.gita.hwlesson17draganddropgame.contracts.QuizContract

class MainActivity : AppCompatActivity(), QuizContract.View {
    private lateinit var image:ImageView
    private lateinit var container:RecyclerView
    private lateinit var myAdapter: QuizAdapter
    private lateinit var presenter: QuizContract.Presenter
    private lateinit var btnCheck:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = PresenterImpl(RepositoryImpl(),this)
        removeHelper()
        btnCheck.setOnClickListener{
            presenter.checkClick()
        }
    }

    override fun init() {
        image = findViewById(R.id.imageView)
        container = findViewById(R.id.container)
        btnCheck = findViewById(R.id.btnCheck)
        myAdapter = QuizAdapter()
        container.adapter = myAdapter
    }

    override fun loadAdapter(dataList:ArrayList<String>) {
        myAdapter.submitList(dataList)
    }

    override fun loadImage(image: Int) {
        this.image.setImageResource(image)
    }


    private fun removeHelper() {
        val touchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                presenter.onMove(viewHolder.adapterPosition, target.adapterPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                //presenter.remove(viewHolder.adapterPosition)
            }
        })

        touchHelper.attachToRecyclerView(container)
    }
}