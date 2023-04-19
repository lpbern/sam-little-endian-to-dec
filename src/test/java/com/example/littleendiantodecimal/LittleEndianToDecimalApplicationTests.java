package com.example.littleendiantodecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class LittleEndianToDecimalApplicationTests {

    @Test
    void contextLoads() {
        String convertedUtil = ConvertUtil.convertLittleEndianHexStringToDecimal("76C70000");;
        Assert.isTrue(convertedUtil.equals("51062"));
        String convertLittleEndianHexStringToDecimal = ConvertUtil.inputLengthAdjustment("76C70000");
        Assert.isTrue(convertLittleEndianHexStringToDecimal.equals("00051062"));
    }

}
