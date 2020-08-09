package io.github.nomorecheckshirts.checkloset

class Clothes {
    var id: String = "01"
    var imageFile: String = "image.jpeg" // 이건 파일 id를 저장할지, 이미지 정보를 저장할지 헷갈
    var clothesColor = arrayOf(0.0f, 0.0f, 0.0f)
    var clothesThick : Int=0
    var clothesKind : String = "Outer"
    var clothesTag = arrayOf("hello", "world", "it", "is", "for", "tag")
    var clothesnote : String = "notes"

    fun getClothesDB(imageId : String){

    }

    fun setClothesDB(){

    }
}