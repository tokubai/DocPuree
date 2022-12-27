package jp.co.tokubai.docpuree.log.entities

import jp.co.tokubai.docpuree.model.LogDocItem

data class OnClickFourth(
    private val event: String = "onClick",
    private val position: String = "forth",
    private val timestamp: String = System.currentTimeMillis().toString(),
) {

    companion object {
        val docPureeLogDocItem = LogDocItem(
            clazz = OnClickFourth::class.java,
            description = "4thをクリックした時のログ",
            category = "Click Log",
            params = listOf(
                LogDocItem.ParamInfo(title = "event", description = "イベント名"),
                LogDocItem.ParamInfo(title = "position", description = "押されたボタンの位置"),
                LogDocItem.ParamInfo(title = "timestamp", description = "ボタンが押された時刻")
            ),
        )
    }
}
