package com.solid.book;

public class ScreenPrinting {
    public void printToScreen(Book book) {
        do {
            System.out.println(book.getCurrentPage());
        } while (book.turnToNextPage());
    }
}
