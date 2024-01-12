package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecoderTest {

    @Test
    void decodeMessageMethodTest() {
        String encodedMessage = "t2st3ng vetviph neev m22t hsif gr3d";
        String expectedDecodedMessage = "testing testing meet meet grid grid";

        String actualDecodedMessage = Decoder.decodeMessage(encodedMessage);

        assertEquals(expectedDecodedMessage, actualDecodedMessage);
    }

    @Test
    void decodeVowelsMethodTest() {
        String encodedVowelsFirst = "t2st3ng";
        String encodedVowelsSecond = "gr3d";
        String expectedDecodedVowelsFirst = "testing";
        String expectedDecodedVowelsSecond = "grid";

        String actualDecodedVowelsFirst = Decoder.decodeVowels(encodedVowelsFirst);
        String actualDecodedVowelsSecond = Decoder.decodeVowels(encodedVowelsSecond);

        assertEquals(expectedDecodedVowelsFirst, actualDecodedVowelsFirst);
        assertEquals(expectedDecodedVowelsSecond, actualDecodedVowelsSecond);
    }

    @Test
    void decodeConsonantsMethodTest() {
        String encodedConsonantsFirst = "vetviph";
        String encodedConsonantsSecond = "hsif";
        String expectedDecodedConsonantsFirst = "testing";
        String expectedDecodedConsonantsSecond = "grid";

        String actualDecodedConsonantsFirst = Decoder.decodeConsonants(encodedConsonantsFirst);
        String actualDecodedConsonantsSecond = Decoder.decodeConsonants(encodedConsonantsSecond);

        assertEquals(expectedDecodedConsonantsFirst, actualDecodedConsonantsFirst);
        assertEquals(expectedDecodedConsonantsSecond, actualDecodedConsonantsSecond);
    }
}
