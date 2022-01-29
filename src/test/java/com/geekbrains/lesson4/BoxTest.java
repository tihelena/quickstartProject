package com.geekbrains.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BoxTest {
    Box box;

    @Nested
    class WhenEmpty {
        @BeforeEach
        void initializeBox() {
            box = new Box();
        }

        @Test
        void exceptionWhenTryShuffleEmptyBox() {
            Assertions.assertThrows(EmptyBoxException.class, () -> box.shuffleBalls());
        }

        @Nested
        class BoxWithBall {
            @BeforeEach
            void addBall() {
                box.addBall();
            }

            @Test
            void deleteBallTest() {
                box.removeBall();
                Assertions.assertEquals(0, box.getBallsCounter());
            }
        }
    }

}



