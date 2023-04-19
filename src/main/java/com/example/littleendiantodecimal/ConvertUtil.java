package com.example.littleendiantodecimal;

public class ConvertUtil {

    public static String inputLengthAdjustment(String data){
        String decimalValue = convertLittleEndianHexStringToDecimal(data);
        String appendedZeros = "0".repeat(data.length() - decimalValue.length());
        String result = decimalValue.length() < data.length() ? String.format("%s%s", appendedZeros, decimalValue) : decimalValue;
        return result;
    }

    public static String convertLittleEndianHexStringToDecimal(String data) {
        byte[] byteHexString = decodeHexString(data);
        long convertedValue = 0;
        for (int i = 0; i < byteHexString.length; i++) {
            convertedValue += ((long) byteHexString[i] & 0xffL) << (8 * i);
        }
        return Long.toString(convertedValue);
    }

    private static byte hexToByte(String hexString) {
        int firstDigit = toDigit(hexString.charAt(0));
        int secondDigit = toDigit(hexString.charAt(1));
        return (byte) ((firstDigit << 4) + secondDigit);
    }

    private static int toDigit(char hexChar) {
        int digit = Character.digit(hexChar, 16);
        if (digit == -1) {
            throw new IllegalArgumentException(
                    "Invalid Hexadecimal Character: " + hexChar);
        }
        return digit;
    }

    private static byte[] decodeHexString(String hexString) {
        if (hexString.length() % 2 == 1) {
            throw new IllegalArgumentException(
                    "Invalid hexadecimal String supplied.");
        }

        byte[] bytes = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length(); i += 2) {
            bytes[i / 2] = hexToByte(hexString.substring(i, i + 2));
        }
        return bytes;
    }
}
