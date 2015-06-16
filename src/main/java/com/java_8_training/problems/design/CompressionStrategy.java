package com.java_8_training.problems.design;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public interface CompressionStrategy {

    public OutputStream compress(OutputStream data) throws IOException;

    static void compressFile(Path inFile, File outFile, CompressionStrategy strategy) throws IOException {
        try (OutputStream outStream = new FileOutputStream(outFile)) {
            Files.copy(inFile, strategy.compress(outStream));
        }
    }
}
