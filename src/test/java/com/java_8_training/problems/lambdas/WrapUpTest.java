package com.java_8_training.problems.lambdas;

import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

@Ignore
public class WrapUpTest {

    private final File mainDirectory = new File("src/test/resources/wrap_up");

    @Test
    public void hiddenFiles() {
        // TODO: find hidden files, tip: mainDirectory.listFiles();
        File[] files = mainDirectory.listFiles(a -> a.getName().startsWith("."));
        assertEquals(2, files.length);
    }

    @Test
    public void xmlFiles() {
        // TODO: Find XML files,
        File[] files = mainDirectory.listFiles(a -> a.getName().endsWith(".xml"));;
        assertEquals(1, files.length);
    }
}
