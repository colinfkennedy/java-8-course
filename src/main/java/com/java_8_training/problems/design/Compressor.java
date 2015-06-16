package com.java_8_training.problems.design;

import static com.java_8_training.problems.design.CompressionStrategy.compressFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

public class Compressor {

    private final CompressionStrategy strategy;

    public Compressor(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void compress(Path inFile, File outFile) throws IOException {
        compressFile(inFile, outFile, strategy);
    }

    public static void compressGzip(Path inFile, File outFile) throws IOException {
        compressFile(inFile, outFile, GZIPOutputStream::new);
    }

    public static void compressZip(Path inFile, File outFile) throws IOException {
        compressFile(inFile, outFile, ZipOutputStream::new);
    }
}
