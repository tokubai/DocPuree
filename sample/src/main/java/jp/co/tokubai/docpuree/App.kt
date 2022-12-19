package jp.co.tokubai.docpuree

import android.app.Application
import android.content.Context
import com.cookpad.puree.Puree
import com.cookpad.puree.PureeConfiguration

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Puree.initialize(buildPureeConfig(this))
    }

    private fun buildPureeConfig(context: Context): PureeConfiguration {
        return PureeConfiguration.Builder(context)
            .pureeSerializer(DocPureeMoshiSerializer())
//            .register(RecipeSearch::class.java, OutLogcat())
            .build()
    }
}
