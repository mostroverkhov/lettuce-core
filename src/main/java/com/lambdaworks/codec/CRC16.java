package com.lambdaworks.codec;

/**
 * @author <a href="mailto:mpaluch@paluch.biz">Mark Paluch</a>
 * @since 27.05.14 08:36
 */
public class CRC16 {

    public final static int polynomial = 0x1021;

    public static int crc16(byte[] bytes) {
        int crc = 0;
        for (byte b : bytes) {
            for (int i = 0; i < 8; i++) {
                boolean bit = ((b >> (7 - i) & 1) == 1);
                boolean c15 = ((crc >> 15 & 1) == 1);
                crc <<= 1;

                if (c15 ^ bit)
                    crc ^= polynomial;
            }
        }

        return crc &= 0xffff;
    }
}
