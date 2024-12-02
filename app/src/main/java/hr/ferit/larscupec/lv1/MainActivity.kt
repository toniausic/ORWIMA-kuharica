package hr.ferit.larscupec.lv1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import hr.ferit.larscupec.lv1.ui.RecipesScreen
import hr.ferit.larscupec.lv1.ui.theme.LV1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            LV1Theme {
                RecipesScreen()
            }
        }
    }
}