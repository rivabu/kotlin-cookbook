package collections.kotlincoach.exercise03

import java.sql.Connection
import java.sql.DriverManager

fun main() {
    val dbManager = DatabaseManager("jdbc:sqlite:books.db")
    dbManager.createTable()
    dbManager.insertBook("The Hobbit", "J.R.R. Tolkien")
    println("After insertion:")
    val id = dbManager.readBooks()

    dbManager.updateBook(id, "The Hobbit: An Unexpected Journey", "J.R.R. Tolkien")
    println("After update:")
    dbManager.readBooks()

    dbManager.deleteBook(id)
    println("After deletion:")
    dbManager.readBooks()
}

class DatabaseManager(private val url: String) {

    private fun connect(): Connection? {
        return DriverManager.getConnection(url).apply {
            // Disable auto-commit to manually control transactions
            autoCommit = false
        }
    }


    fun createTable() {
        connect().use { conn ->
            conn?.createStatement()?.execute("CREATE TABLE IF NOT EXISTS books (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, author TEXT NOT NULL)")
            conn?.commit()
        }
    }

    fun insertBook(title: String, author: String) {
        connect().use { conn ->
            val sql = "INSERT INTO books(title, author) VALUES(?, ?)"
            val pstmt = conn?.prepareStatement(sql)
            pstmt?.setString(1, title)
            pstmt?.setString(2, author)
            pstmt?.executeUpdate()
            conn?.commit()
        }
    }

    fun readBooks(): Int {
        var returnValue = 0
        connect().use { conn ->
            val rs = conn?.createStatement()?.executeQuery("SELECT id, title, author FROM books")
            while (rs?.next() == true) {
                println("${rs.getInt("id")}: ${rs.getString("title")} by ${rs.getString("author")}")
                returnValue = rs.getInt("id")
            }
        }
        return returnValue
    }

    fun updateBook(id: Int, title: String, author: String) {
        connect().use { conn ->
            val sql = "UPDATE books SET title = ?, author = ? WHERE id = ?"
            val pstmt = conn?.prepareStatement(sql)
            pstmt?.setString(1, title)
            pstmt?.setString(2, author)
            pstmt?.setInt(3, id)
            pstmt?.executeUpdate()
            conn?.commit()
        }
    }

    fun deleteBook(id: Int) {
        connect().use { conn ->
            val sql = "DELETE FROM books WHERE id = ?"
            val pstmt = conn?.prepareStatement(sql)
            pstmt?.setInt(1, id)
            pstmt?.executeUpdate()
            conn?.commit()
        }
    }
}
