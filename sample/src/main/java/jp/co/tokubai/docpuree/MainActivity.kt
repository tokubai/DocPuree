package jp.co.tokubai.docpuree

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cookpad.puree.Puree
import jp.co.tokubai.docpuree.log.entities.RecipeSearch
import jp.co.tokubai.docpuree.ui.DocPureeActivity
import jp.co.tokubai.docpuree.ui.theme.DocPureeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DocPureeTheme {
                // A surface container using the 'background' color from the theme
                repeat(10) {
                    Puree.send(RecipeSearch("hello", 1))
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                    Button(onClick = {
                        val intent = Intent(this@MainActivity, DocPureeActivity::class.java)
                        startActivity(intent)
                    }) {
                        Text(text = "DocPureeActivity")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DocPureeTheme {
        Greeting("Android")
    }
}
