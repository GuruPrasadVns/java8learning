package com.interfaces;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderInterface {
    String processFileDynamically(BufferedReader bufferedReader) throws IOException;
}
