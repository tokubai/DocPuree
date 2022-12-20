package jp.co.tokubai.docpuree.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DocPureeScreen() {
    Scaffold {
        DocPureeContent(modifier = Modifier.padding(it))
    }
}

@Composable
private fun DocPureeContent(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {

    }

}
