package jp.co.tokubai.docpuree.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import jp.co.tokubai.docpuree.LogHistorySource
import jp.co.tokubai.docpuree.ui.ui.theme.DocPureeTheme

class DocPureeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DocPureeTheme {
                LazyColumn {
                    items(LogHistorySource.successfullyLoggedClassHistory) { classToJson: Pair<String, String> ->
                        Text(text = "Class: ${classToJson.first}, Json: ${classToJson.second}")
                    }
                }
            }
        }
    }
}

