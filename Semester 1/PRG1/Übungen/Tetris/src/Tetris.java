public class Tetris {
    public static void main (String[] args) {
        String[] segments = {
            "- - - -",
            "o - - -",
            "- o - -",
            "- - o -",
            "- - - o",
            "o o - -",
            "- o o -",
            "- - o o",
            "o o o -",
            "- o o o",
            "o o o o"
        };
        int[][][] pieces = {
            {
                {0, 2, 8, 0},
                {2, 6, 2, 0},
                {0, 9, 3, 0},
                {0, 3, 6, 3},
                {0, 2, 8, 0}
            },
            {
                {0, 6, 5, 0},
                {2, 6, 3, 0},
                {0, 7, 6, 0},
                {0, 2, 6, 3},
                {0, 6, 5, 0}
            },
            {
                {0, 2, 2, 6},
                {0, 8, 1, 0},
                {6, 3, 3, 0},
                {0, 4, 9, 0},
                {0, 2, 2, 6}
            },
            {
                {3, 3, 3, 3}, 
                {0, 0, 10, 0},
                {2, 2, 2, 2},
                {0, 10, 0, 0},
                {3, 3, 3, 3}
            }
        };

        for (int outer = 0; outer < pieces[0].length; outer++) {
            for (int inner = 0; inner < pieces[0][outer].length; inner++) {
                System.out.printf(
                    "%s  %s  %s  %s%n", 
                segments[pieces[0][outer][inner]],
                segments[pieces[1][outer][inner]],
                segments[pieces[2][outer][inner]],
                segments[pieces[3][outer][inner]]);
            }
            if (outer + 1 < pieces[0].length) {
                System.out.print("\n");
            }
        }
    }
}