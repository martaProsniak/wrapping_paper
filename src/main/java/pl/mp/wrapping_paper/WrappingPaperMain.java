package pl.mp.wrapping_paper;

import java.io.*;

public class WrappingPaperMain {

    public static void main(String[] args) throws IOException {
        System.out.println("Paper needed to pack all boxes (dm): " + sumAll());
    }

    public static int sumAll() throws IOException {
        String fileName = "src/boxes";
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        String line;
        int sumPaper = 0;
        while ((line = br.readLine()) != null) {
            int paperForBox = calculatePaperForBox(line);
            sumPaper = sumPaper + paperForBox;
        }
        return sumPaper;
    }

    public static int calculatePaperForBox(String line) {
        String[] sizeStr = line.split("x");
        int first = Integer.parseInt(sizeStr[0]);
        int second = Integer.parseInt(sizeStr[1]);
        int third = Integer.parseInt(sizeStr[2]);

        int min = Math.min(Math.min(first, second), third);
        int max = Math.max(Math.max(first, second), third);
        int mid;

        if ((!(min == first) && !(max == first)) || ((first == second) || (first == third))) {
            mid = first;
        } else if ((!(min == second) && !(max == second)) || ((second == third))) {
            mid = second;
        } else {
            mid = third;
        }

        return (3 * (min * mid)) + (2 * (mid * max)) + (2 * (max * min));
    }
}
