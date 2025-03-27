package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuit {

    @Test
    void testGetBooks() throws CloneNotSupportedException {

        // Given
        Library library = new Library("Main Library");
        library.getBooks().add(new Book("Wiedzmin", "Andrzej Sapkowski", LocalDate.of(2000, 1, 1)));
        library.getBooks().add(new Book("Assassin", "Ubisoft", LocalDate.of(2005, 5, 15)));
        library.getBooks().add(new Book("Prince of Percia", "Game", LocalDate.of(2008, 10, 20)));

        // When - Shallow Copy
        Library shallowClonedLibrary = library.clone();
        shallowClonedLibrary.setName("Shallow Copy Library");

        // When - Deep Copy
        Library deepClonedLibrary = library.deepCopy();
        deepClonedLibrary.setName("Deep Copy Library");

        // Then
        assertEquals(3, library.getBooks().size());
        assertEquals(3, shallowClonedLibrary.getBooks().size());
        assertEquals(3, deepClonedLibrary.getBooks().size());

        library.getBooks().removeIf(book -> book.getTitle().equals("Wiedzmin"));

        assertEquals(2, library.getBooks().size());
        assertEquals(2, shallowClonedLibrary.getBooks().size());
        assertEquals(3, deepClonedLibrary.getBooks().size());
    }
}
