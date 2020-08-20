package io.github.nomorecheckshirts.checkloset.dto

class ClothesDto {
    var id: String = "01"
    var imageFile: String = "image.jpeg" // 이건 파일 id를 저장할지, 이미지 정보를 저장할지 헷갈
    var color = arrayOf(0.0f, 0.0f, 0.0f) // R G B
    var thick : Int=0
    var kind : String = "Outer"
    var tag = arrayOf("hello", "world", "it", "is", "for", "tag")
    var note : String = "notes"

    constructor(){}

    constructor(id:String, imageFile:String, color:Array<Float>,
                thick:Int, kind:String, tag:Array<String>, note:String){
        this.id=id;
        this.imageFile=imageFile;
        this.color=color;
        this.thick=thick;
        this.kind=kind;
        this.tag=tag;
        this.note=note;
    }
}