package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    JSONObject book;
    JSONArray books;

    public JSONBookMetadataFormatter() throws IOException {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        book = new JSONObject();
        books = new JSONArray();
        book.put("Books",books);
        return null;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        var tempBook = new JSONObject();
        tempBook.put("ISBN",b.getISBN());
        tempBook.put("Title",b.getTitle());
        tempBook.put("Publisher",b.getPublisher());

        var bookAuthors = new JSONArray();
        for(var auth : b.getAuthors()){
            bookAuthors.add(auth);
        }

        tempBook.put("Authors",bookAuthors);
        books.add(tempBook);
        return this;
    }

    @Override
    public String getMetadataString() {
        return book.toString();
    }
}
