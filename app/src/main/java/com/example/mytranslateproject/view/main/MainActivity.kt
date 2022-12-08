package com.example.mytranslateproject.view.main

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AnticipateInterpolator
import androidx.annotation.RequiresApi
import androidx.core.animation.doOnEnd
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.mytranslateproject.R
import com.example.mytranslateproject.databinding.ActivityMainBinding
import com.example.model.data.AppState
import com.example.model.data.userdata.DataModel
import com.example.mytranslateproject.utils.convertMeaningsToSingleString
import com.example.mytranslateproject.utils.ui.viewById
import com.example.mytranslateproject.view.base.BaseActivity
import com.example.mytranslateproject.view.descriptionscreen.DescriptionActivity
import com.example.mytranslateproject.view.history.HistoryActivity
import com.example.mytranslateproject.view.main.adapter.MainAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.currentScope
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val SLIDE_LEFT_DURATION = 1000L
private const val COUNTDOWN_DURATION = 2000L
private const val COUNTDOWN_INTERVAL = 1000L
private const val BOTTOM_SHEET_FRAGMENT_DIALOG_TAG = "74a54328-5d62-46bf-ab6b-cbf5fgt0-092395"

class MainActivity : BaseActivity<AppState, MainInteractor>() {

    private lateinit var binding: ActivityMainBinding
    override lateinit var model: MainViewModel
    private val adapter: MainAdapter by lazy { MainAdapter(onListItemClickListener) }

    //Объявляем переменные на уровне класса
    private val mainActivityRecyclerview by
    viewById<RecyclerView>(R.id.main_activity_recyclerview)
    private val searchFAB by viewById<FloatingActionButton>(R.id.search_fab)

    private val fabClickListener: View.OnClickListener =
        View.OnClickListener {
            val searchDialogFragment = SearchDialogFragment.newInstance()
            searchDialogFragment.setOnSearchClickListener(onSearchClickListener)
            searchDialogFragment.show(supportFragmentManager, BOTTOM_SHEET_FRAGMENT_DIALOG_TAG)
        }
    private val onListItemClickListener: MainAdapter.OnListItemClickListener =
        object : MainAdapter.OnListItemClickListener {
            override fun onItemClick(data: DataModel) {
                startActivity(
                    DescriptionActivity.getIntent(
                        this@MainActivity,
                        data.text,
                        convertMeaningsToSingleString(data.meanings),
                        data.meanings[0].imageUrl
                    )
                )
            }
        }
    private val onSearchClickListener: SearchDialogFragment.OnSearchClickListener =
        object : SearchDialogFragment.OnSearchClickListener {
            override fun onClick(searchWord: String) {
                //isNetworkAvailable = isOnline(applicationContext)
                if (isNetworkAvailable) {
                    model.getData(searchWord, isNetworkAvailable)
                } else {
                    showNoInternetConnectionDialog()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDefaultSplashScreen()

        iniViewModel()
        initViews()
    }

    private fun setDefaultSplashScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            setSplashScreenHideAnimation()
        }

        setSplashScreenDuration()

    }

    @RequiresApi(31)
    private fun setSplashScreenHideAnimation() {
        splashScreen.setOnExitAnimationListener { splashScreenView ->
            val slideLeft = ObjectAnimator.ofFloat(
                splashScreenView,
                View.TRANSLATION_X,
                0f,
                -splashScreenView.height.toFloat()
            )
            slideLeft.interpolator = AnticipateInterpolator()
            slideLeft.duration = SLIDE_LEFT_DURATION

            slideLeft.doOnEnd { splashScreenView.remove() }
            slideLeft.start()
        }
    }

    private fun setSplashScreenDuration() {
        var isHideSplashScreen = false

        object : CountDownTimer(COUNTDOWN_DURATION, COUNTDOWN_INTERVAL) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                isHideSplashScreen = true
            }
        }.start()

        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (isHideSplashScreen) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else {
                        false
                    }
                }
            }
        )
    }

    override fun setDataToAdapter(data: List<DataModel>) {
        adapter.setData(data)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.history_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_history -> {
                startActivity(Intent(this, HistoryActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun iniViewModel() {
        if (binding.mainActivityRecyclerview.adapter != null) {
            throw IllegalStateException("The ViewModel should be initialised first")
        }
        // Заменим предыдущий код...
        val viewModel: MainViewModel by viewModel()
        // ...на новый: теперь модель мы получаем через currentScope, остальное
        // остаётся без изменений
        //val viewModel: MainViewModel by inject()
        model = viewModel
        model.subscribe().observe(this@MainActivity, Observer<AppState> { renderData(it) })
    }

    private fun initViews() {
        searchFAB.setOnClickListener(fabClickListener)
        mainActivityRecyclerview.adapter = adapter
    }
}
