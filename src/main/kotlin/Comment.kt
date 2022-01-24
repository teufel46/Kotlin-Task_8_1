class Comment(
    cid : Int = 0,
    isDeleting : Boolean,
    userId : Int,
    val nid : Int,
    val message : String
) : Node(cid, isDeleting, userId) {

    override fun toString(): String {
        return "id=$id isDeleting=$isDeleting userId=$userId nid=$nid message=$message"
    }
}
