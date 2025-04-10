package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        // Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("with sesame")
                .burgers(2)
                .sauce("barbecue")
                .ingredient("tomato")
                .ingredient("onion")
                .ingredient("bacon")
                .ingredient("cheese")
                .build();

        System.out.println(bigmac);

        // When & Then
        assertEquals("with sesame", bigmac.getBun());
        assertEquals(2, bigmac.getBurgers());
        assertEquals("barbecue", bigmac.getSauce());
        assertTrue(bigmac.getIngredients().contains("bacon"));
        assertEquals(4, bigmac.getIngredients().size());
    }
}
