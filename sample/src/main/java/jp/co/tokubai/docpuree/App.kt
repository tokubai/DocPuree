package jp.co.tokubai.docpuree

import android.app.Application
import android.content.Context
import com.cookpad.puree.Puree
import com.cookpad.puree.PureeConfiguration
import jp.co.tokubai.docpuree.extensions.register
import jp.co.tokubai.docpuree.log.BufferOutMockServer
import jp.co.tokubai.docpuree.log.entities.*

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Puree.initialize(buildPureeConfig(this))
    }

    private fun buildPureeConfig(context: Context): PureeConfiguration {
        val output = BufferOutMockServer()

        return PureeConfiguration.Builder(context)
            .pureeSerializer(DocPureeMoshiSerializer())
            .register(
                logClass = OnClickFirst::class.java,
                output = output,
                logDocItem = OnClickFirst.docPureeLogDocItem,
            )
            .register(
                logClass = OnClickSecond::class.java,
                output = output,
                logDocItem = OnClickSecond.docPureeLogDocItem,
            )
            .register(
                logClass = OnClickThird::class.java,
                output = output,
                logDocItem = OnClickThird.docPureeLogDocItem,
            )
            .register(
                logClass = OnClickFourth::class.java,
                output = output,
                logDocItem = OnClickFourth.docPureeLogDocItem,
            )
            .register(
                logClass = OnClickFifth::class.java,
                output = output,
                logDocItem = OnClickFifth.docPureeLogDocItem,
            )
            .build()
    }
}
