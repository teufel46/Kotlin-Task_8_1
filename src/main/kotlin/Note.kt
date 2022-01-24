class Note(
    nid : Int = 0,
    isDeleting : Boolean,
    userId : Int,
    val title : String,
    val text : String,
    val privacy : Int,
    val commentPrivacy : Int,
    val privacyView : String,
    val privacyComment : String
    ) : Node(nid, isDeleting, userId) {

    override fun toString(): String {
        return "id=$id isDeleting=$isDeleting userId=$userId title=$title text=$text"
    }
}
