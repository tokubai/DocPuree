package jp.co.tokubai.docpuree

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cookpad.puree.Puree
import jp.co.tokubai.docpuree.log.entities.*
import jp.co.tokubai.docpuree.ui.DocPureeActivity
import jp.co.tokubai.docpuree.ui.theme.DocPureeTheme

class MainActivity : ComponentActivity() {

    private fun showNotifyLoggedToast(loggedClass: Class<*>) {
        Toast.makeText(this, loggedClass.simpleName + " is on Logging queue", Toast.LENGTH_SHORT)
            .show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DocPureeTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        Button(
                            onClick = {
                                val intent = Intent(this@MainActivity, DocPureeActivity::class.java)
                                startActivity(intent)
                            },
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(text = "Open Docpuree Activity")
                        }

                        Button(
                            onClick = {
                                Puree.send(OnClickFirst())
                                showNotifyLoggedToast(OnClickFirst::class.java)
                            },
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(text = "1st")
                        }

                        Button(
                            onClick = {
                                Puree.send(OnClickSecond())
                                showNotifyLoggedToast(OnClickSecond::class.java)
                            },
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(text = "2nd")
                        }

                        Button(
                            onClick = {
                                Puree.send(OnClickThird())
                                showNotifyLoggedToast(OnClickThird::class.java)
                            },
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(text = "3rd")
                        }

                        Button(
                            onClick = {
                                Puree.send(OnClickFourth())
                                showNotifyLoggedToast(OnClickFourth::class.java)
                            },
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(text = "4th")
                        }

                        Button(
                            onClick = {
                                Puree.send(OnClickFifth())
                                showNotifyLoggedToast(OnClickFirst::class.java)
                            },
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(text = "5th")
                        }
                    }
                }
            }
        }
    }
}
