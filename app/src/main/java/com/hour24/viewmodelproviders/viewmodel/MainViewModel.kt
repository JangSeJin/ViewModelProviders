package com.hour24.viewmodelproviders.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.hour24.viewmodelproviders.model.LanguageModel

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var mModel: LanguageModel? = null

    val mList: MutableLiveData<ArrayList<LanguageModel>> by lazy {
        MutableLiveData<ArrayList<LanguageModel>>()
    }

    /**
     * 데이터 가져옴
     */
    fun getLanguageList() {

        val list = arrayListOf(
            LanguageModel(1, "아랍어", "ar-XA"),
            LanguageModel(2, "불가리아어", "bg"),
            LanguageModel(3, "크로아티아어", "hr"),
            LanguageModel(4, "체코어", "cs"),
            LanguageModel(5, "덴마크어", "da"),
            LanguageModel(6, "독일어", "de"),
            LanguageModel(7, "그리스어", "el"),
            LanguageModel(8, "영어", "en"),
            LanguageModel(9, "에스토니아어    ", "et"),
            LanguageModel(10, "스페인어", "es"),
            LanguageModel(11, "핀란드어", "fi"),
            LanguageModel(12, "프랑스어", "fr"),
            LanguageModel(13, "아일랜드어", "ga"),
            LanguageModel(14, "힌디어", "hi"),
            LanguageModel(15, "헝가리어", "hu"),
            LanguageModel(16, "히브리어", "he"),
            LanguageModel(17, "이탈리아어", "it"),
            LanguageModel(18, "일본어", "ja"),
            LanguageModel(19, "한국어", "ko"),
            LanguageModel(20, "라트비아어", "lv"),
            LanguageModel(21, "리투아니아어", "lt"),
            LanguageModel(22, "네덜란드어", "nl"),
            LanguageModel(23, "노르웨이어", "no"),
            LanguageModel(24, "폴란드어", "pl"),
            LanguageModel(25, "포르투갈어", "pt"),
            LanguageModel(26, "스웨덴어", "sv"),
            LanguageModel(27, "루마니아어", "ro"),
            LanguageModel(28, "러시아어", "ru"),
            LanguageModel(29, "세르비아어", "sr-CS"),
            LanguageModel(30, "슬로바키아어", "sk"),
            LanguageModel(31, "슬로베니아어", "sl"),
            LanguageModel(32, "태국어", "th"),
            LanguageModel(33, "터키어", "tr"),
            LanguageModel(34, "우크라이나어", "uk-UA"),
            LanguageModel(35, "중국어(간체)", "zh-chs"),
            LanguageModel(36, "중국어(번체)", "zh-cht")
        )

        mList.value = list
    }

}
