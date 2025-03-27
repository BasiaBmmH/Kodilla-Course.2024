package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {

    @Test
    void testGetBooks() throws CloneNotSupportedException {

        // Given
        Library library = new Library("Main Library");
        library.getBooks().add(new Book("Book 1", "Author A", LocalDate.of(2000, 1, 1)));
        library.getBooks().add(new Book("Book 2", "Author B", LocalDate.of(2005, 5, 15)));
        library.getBooks().add(new Book("Book 3", "Author C", LocalDate.of(2010, 10, 20)));

        // When
        Library shallowClonedLibrary = library.clone();
        shallowClonedLibrary.setName("Shallow Copy Library");

        Library deepClonedLibrary = library.deepCopy();
        deepClonedLibrary.setName("Deep Copy Library");

        // Then
        assertEquals(3, library.getBooks().size());
        assertEquals(3, shallowClonedLibrary.getBooks().size());
        assertEquals(3, deepClonedLibrary.getBooks().size());

        library.getBooks().removeIf(book -> book.getTitle().equals("Book 1"));

        assertEquals(2, library.getBooks().size());
        assertEquals(2, shallowClonedLibrary.getBooks().size());
        assertEquals(3, deepClonedLibrary.getBooks().size());
    }
}
