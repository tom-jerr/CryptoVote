package com.example.toupiao.algorithm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class JsonCompression {
    public static String compress(String json) throws IOException {
        byte[] data = json.getBytes(StandardCharsets.UTF_8);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (GZIPOutputStream gzipOut = new GZIPOutputStream(baos)) {
            gzipOut.write(data);
        }
        byte[] compressedData = baos.toByteArray();
        return Base64.getEncoder().encodeToString(compressedData);
    }

    public static String decompress(String compressedJson) throws IOException {
        byte[] compressedData = Base64.getDecoder().decode(compressedJson);
        ByteArrayInputStream bais = new ByteArrayInputStream(compressedData);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (GZIPInputStream gzipIn = new GZIPInputStream(bais)) {
            byte[] buffer = new byte[256];
            int n;
            while ((n = gzipIn.read(buffer)) >= 0) {
                baos.write(buffer, 0, n);
            }
        }
        byte[] data = baos.toByteArray();
        return new String(data, StandardCharsets.UTF_8);
    }
}

