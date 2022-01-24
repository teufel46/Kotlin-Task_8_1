open class CrudService<T : Node>{
    private var nextId = 1
    val elements = mutableListOf<T>()

    open fun add(elem: T) : Int {
        elem.id = nextId++
        elements.add(elem)
        return elements.last().id
    }

    fun update(elem: T) : Int {
       for ((index, node) in elements.withIndex()){
            if (node.id == elem.id){
                elements[index] = elem
                return 1
            }
        }
        return 180
    }

    fun getById(id : Int) : T? {
        for ((index, node) in elements.withIndex()) if (node.id == id) {
            return node
        }
        return null
    }

    open fun delete(id : Int) : Int {
        for ((index, node) in elements.withIndex()) if (node.id == id) {
            elements[index].isDeleting = true
            return 1
        }
        return 180
    }

    fun get(userId : Int) : MutableList<T>? {
        val results = mutableListOf<T>()
        for ((index, node) in elements.withIndex()) if (node.userId == userId) {
            results.add(node)
        }
        return results
    }

}
