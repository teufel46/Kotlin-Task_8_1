import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun addNote() {
        val service = NoteService()
        val result = service.add(Note(0, false, 123, "title1", "text1", 0, 0, "all", "all"))

        assertTrue(result == 1)
    }

    @Test
    fun getNoteByIdExist() {
        val service = NoteService()
        val note = Note(0, false, 123, "title1", "text1", 0, 0, "all", "all")
        service.add(note)
        val result = note==service.getById(1)
        assertTrue(result)
    }

    @Test
    fun getNoteByIdNotExist() {
        val service = NoteService()
        val note = Note(0, false, 123, "title1", "text1", 0, 0, "all", "all")
        service.add(note)
        val result = note==service.getById(2)
        assertFalse(result)
    }

    @Test
    fun updateNoteExist() {
        val service = NoteService()
        service.add(Note(0, false, 123, "title1", "text1", 0, 0, "all", "all"))
        val result = service.update(Note(1, false, 123, "title1", "text1", 0, 0, "all", "all"))

        assertTrue(result == 1)
    }

    @Test
    fun updateNoteNotExist() {
        val service = NoteService()
        val result = service.update(Note(0, false, 123, "title1", "text1", 0, 0, "all", "all"))

        assertTrue(result == 180)
    }

    @Test
    fun deleteNoteExist() {
        val service = NoteService()
        service.add(Note(0, false, 123, "title1", "text1", 0, 0, "all", "all"))
        val result = service.delete(1)

        assertTrue(result == 1)
    }

    @Test
    fun deleteNoteNotExist() {
        val service = NoteService()
        val result = service.delete(0)

        assertTrue(result == 180)
    }

    @Test
    fun getNotesByUserExist() {
        val service = NoteService()
        service.add(Note(0, false, 123, "title1", "text1", 0, 0, "all", "all"))
        service.add(Note(0, false, 456, "title1", "text1", 0, 0, "all", "all"))
        service.add(Note(0, false, 123, "title1", "text1", 0, 0, "all", "all"))
        val result = service.get(123)?.size

        assertTrue(result == 2)
    }

    @Test
    fun addComment() {
        val service = CommentService()
        val result = service.add(Comment(0, false,123,1, "message1"))

        assertTrue(result == 1)
    }

    @Test
    fun updateCommentExist() {
        val service = CommentService()
        service.add(Comment(0, false,123,1, "message1"))
        val result = service.update(Comment(1, false,123,1, "message2"))

        assertTrue(result == 1)
    }

    @Test
    fun updateCommentNotExist() {
        val service = CommentService()
        val result = service.update(Comment(0, false,123,1, "message2"))

        assertTrue(result == 180)
    }

    @Test
    fun deleteCommentExist() {
        val service = CommentService()
        service.add(Comment(0, false,123,1, "message1"))
        val result = service.delete(1)

        assertTrue(result == 1)
    }

    @Test
    fun deleteCommentNotExist() {
        val service = CommentService()
        val result = service.delete(0)

        assertTrue(result == 180)
    }

    @Test
    fun restoreCommentExist() {
        val service = CommentService()
        service.add(Comment(0, false,123,1, "message1"))
        service.delete(1)
        val result = service.restoreComment(1)

        assertTrue(result == 1)
    }

    @Test
    fun restoreCommentNotExist() {
        val service = CommentService()
        val result = service.restoreComment(2)

        assertTrue(result == 180)
    }

    @Test
    fun getCommentsExist() {
        val service = CommentService()
        service.add(Comment(0, false,123,2, "message1"))
        service.add(Comment(0, false,456,1, "message2"))
        service.add(Comment(0, false,123,1, "message3"))
        val result = service.getComments(1)?.size

        assertTrue(result == 2)
    }

    @Test
    fun getCommentsNotExist() {
        val service = CommentService()
        val result = service.getComments(1)?.size
        assertTrue(result == 0)
    }
}

