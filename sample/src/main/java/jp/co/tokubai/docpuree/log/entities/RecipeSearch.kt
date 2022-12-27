package jp.co.tokubai.docpuree.log.entities

import jp.co.tokubai.docpuree.model.LogDocItem

class RecipeSearch(
    private val keyword: String,
    private val order: Int,
) {

    companion object {
        val docPureeLogDocItem = LogDocItem(
            clazz = RecipeSearch::class.java,
            description = "レシピ検索機能関連のログです",
            category = "Recipe",
            params = listOf(
                LogDocItem.ParamInfo(title = "keyword", description = "検索文字列"),
                LogDocItem.ParamInfo(title = "order", description = "検索時に使用した順番"),
            )
        )
    }
}
