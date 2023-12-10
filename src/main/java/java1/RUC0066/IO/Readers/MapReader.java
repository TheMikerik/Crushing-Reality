package java1.RUC0066.IO.Readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MapReader {
    private String folder_path;
    private int rows, cols;
    private char[][] map;

    public MapReader(int rows, int cols) {
        this.folder_path = "/java1/RUC0066/maps/";
        this.rows = rows;
        this.cols = cols;
        this.map = new char[rows][cols];
    }

    public char[][] LoadNextMap(int map_ID) {
        try {
            InputStream in = getClass().getResourceAsStream(folder_path + "map" + map_ID + ".txt");
            if (in == null) {
                throw new RuntimeException("Next level of this game does not exist");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            for (int i = 0; i < this.rows; i++) {
                String line = reader.readLine();
                for (int j = 0; j < this.cols; j++) {
                    char current = line.charAt(j);
                    map[i][j] = current;
                }
            }
            reader.close();
            return map;
        } catch (IOException e) {
            System.out.println("Next level of this game does not exist");
            return null;
        }
    }
}
