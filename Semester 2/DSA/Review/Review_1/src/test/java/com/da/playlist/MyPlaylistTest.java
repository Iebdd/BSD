package com.da.playlist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.da.util.TestPlaylistImplemention;

/*
 * Project: music-player
 * Author:  Ulz-Samuel
 *
 * A class to test my MyPlaylist.java class
 * Compares differences between my output and the reference output
 */
class MyPlaylistTest {

    @Test
    void testFilesLineByLine() throws IOException {
        for (int i = 1; i < 21; i++) {
            new TestPlaylistImplemention().test("testdata/input/testcase" + i + ".in");

            Path file1 = Path.of("testdata/output/testcase" + i + ".out");
            Path file2 = Path.of("testdata/reference/testcase" + i + ".out");

            List<String> lines1 = Files.readAllLines(file1);
            List<String> lines2 = Files.readAllLines(file2);

            int maxLines = Math.max(lines1.size(), lines2.size());
            boolean differencesFound = false;
            StringBuilder diffReport = new StringBuilder();

            for (int j = 0; j < maxLines; j++) {
                String line1 = j < lines1.size() ? lines1.get(j) : "<keine Zeile>";
                String line2 = j < lines2.size() ? lines2.get(j) : "<keine Zeile>";

                if (!line1.equals(line2)) {
                    differencesFound = true;
                    diffReport.append(String.format("Unterschied in Zeile %d:%n", j + 1));
                    diffReport.append(String.format("  Datei 1: %s%n", line1));
                    diffReport.append(String.format("  Datei 2: %s%n%n", line2));
                }
            }

            if (differencesFound) {
                System.out.println("Dateien unterscheiden sich:\n" + diffReport);
            }
        }
    }
}