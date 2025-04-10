package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        // Given
        User millennial = new Millenials("Eilif Millenial");
        User yGen = new YGeneration("Gudrun YGen");
        User zGen = new ZGeneration("Kvazir ZGen");

        // When
        String millennialShare = millennial.sharePost();
        String yGenShare = yGen.sharePost();
        String zGenShare = zGen.sharePost();

        // Then
        assertEquals("Sharing on Facebook", millennialShare);
        assertEquals("Sharing on Twitter", yGenShare);
        assertEquals("Sharing on Snapchat", zGenShare);
    }

    @Test
    void testIndividualSharingStrategy() {
        // Given
        User user = new Millenials("Eilif");
        assertEquals("Sharing on Facebook", user.sharePost());

        // When
        user.setSocialPublisher(new TwitterPublisher());
        String newShare = user.sharePost();

        // Then
        assertEquals("Sharing on Twitter", newShare);
    }
}
