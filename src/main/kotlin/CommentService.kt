class CommentService : CrudService<Comment>(){

    fun restoreComment(cid : Int) : Int {
        val comment = this.getById(cid)
        if (comment != null) {
            comment.isDeleting = false
            return 1
        } else
            return 180
    }

    fun getComments(nid : Int) : MutableList<Comment>?{
        val results = mutableListOf<Comment>()
        for ((index, node) in elements.withIndex()) if (node.nid == nid) {
            results.add(node)
        }
        return results
    }

    fun deleteAllforNote(nid : Int) : Int{
        var result = 180
        for ((index, node) in elements.withIndex()) if (node.nid == nid) {
            node.isDeleting = true
            result = 1
        }
        return result
    }
}