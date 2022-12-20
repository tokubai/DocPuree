package jp.co.tokubai.docpuree.log.entities

import com.squareup.moshi.Json

class RecipeSearch constructor(
    private val keyword: String,
    private val order: Int,
    @Json(ignore = true)
    val rawMarkdown: String = "# RecipeSearch\nレシピ検索用のログです\n\n## search\nレシピ検索を行った際に送信されます\n\n- keyword: String\n- order: Int\n    - 検索順\n\n## show_recipe\n検索結果画面からレシピ詳細画面に遷移する際に送信されます\n\n- recipe_id: Int\n    - 表示したレシピのID",
) {

    companion object {
        const val rawMarkdown: String =
            "# RecipeSearch\nレシピ検索用のログです\n\n## search\nレシピ検索を行った際に送信されます\n\n- keyword: String\n- order: Int\n    - 検索順\n\n## show_recipe\n検索結果画面からレシピ詳細画面に遷移する際に送信されます\n\n- recipe_id: Int\n    - 表示したレシピのID"
    }
}
