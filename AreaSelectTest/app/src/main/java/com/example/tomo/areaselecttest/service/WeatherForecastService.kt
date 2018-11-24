package com.example.tomo.areaselecttest.service

object WeatherForecastService {

    fun getSettingAreaData() = listOf(
            Area("北海道・東北", listOf(
                    Prefecture(1, "北海道"),
                    Prefecture(2, "青森県"),
                    Prefecture(3, " 岩手県"),
                    Prefecture(4, " 宮城県"),
                    Prefecture(5, " 秋田県"),
                    Prefecture(6, " 山形県"),
                    Prefecture(7, " 福島県")
            )),
            Area("関東", listOf(
                    Prefecture(8, "東京都"),
                    Prefecture(9, "神奈川県"),
                    Prefecture(10, "埼玉県"),
                    Prefecture(11, "千葉県"),
                    Prefecture(12, "茨城県"),
                    Prefecture(13, "栃木県"),
                    Prefecture(14, "群馬県"),
                    Prefecture(15, "山梨県")
            )),
            Area("信越・北陸", listOf(
                    Prefecture(16, "新潟県"),
                    Prefecture(17, "長野県"),
                    Prefecture(18, "富山県"),
                    Prefecture(19, "石川県"),
                    Prefecture(20, "福井県")
            )),
            Area("東海", listOf(
                    Prefecture(21, "愛知県"),
                    Prefecture(22, "岐阜県"),
                    Prefecture(23, "静岡県"),
                    Prefecture(24, "三重県")
            )),
            Area("近畿", listOf(
                    Prefecture(25, "大阪府"),
                    Prefecture(26, "兵庫県"),
                    Prefecture(27, "京都府"),
                    Prefecture(28, "滋賀県"),
                    Prefecture(29, "奈良県"),
                    Prefecture(30, "和歌山県")
            )),
            Area("中国", listOf(
                    Prefecture(31, "鳥取県"),
                    Prefecture(32, "島根県"),
                    Prefecture(33, "岡山県"),
                    Prefecture(34, "広島県"),
                    Prefecture(35, "山口県")
            )),
            Area("四国", listOf(
                    Prefecture(36, "徳島県"),
                    Prefecture(37, "香川県"),
                    Prefecture(38, "愛媛県"),
                    Prefecture(39, "高知県")
            )),
            Area("九州・沖縄", listOf(
                    Prefecture(40, "福岡県"),
                    Prefecture(41, "佐賀県"),
                    Prefecture(42, "長崎県"),
                    Prefecture(43, "熊本県"),
                    Prefecture(44, "大分県"),
                    Prefecture(45, "宮崎県"),
                    Prefecture(46, "鹿児島県"),
                    Prefecture(47, "沖縄県")
            ))
    )

    data class Area(val name: String, val prefectures: List<Prefecture>)
    data class Prefecture(val id: Int, val name: String)
}

