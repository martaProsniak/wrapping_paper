package pl.mp.wrapping_paper;

import java.io.*;

public class WrappingPaperMain {

    public static void main(String[] args) throws IOException {
        System.out.println(calculate());
    }

    public static int calculate() throws IOException {
        String fileName = "src/boxes";
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        String line;
        int sumOfPaper = 0;
        while ((line = br.readLine()) != null) {
            int paperForBox = calculatePaperForBox(line);
            sumOfPaper = sumOfPaper + paperForBox;
        }
        return sumOfPaper;
    }

    public static int calculatePaperForBox(String line) {
        String[] sizeStr = line.split("x");
        int first = Integer.parseInt(sizeStr[0]);
        int second = Integer.parseInt(sizeStr[1]);
        int third = Integer.parseInt(sizeStr[2]);

        int min = 0;
        int mid = 0;
        int max = 0;

        if ((first <= second) && (first <= third)) {
            min = first;
            if (second <= third) {
                mid = second;
                max = third;
            } else {
                mid = third;
                max = second;
            }
        } else if ((second <= first) && (second <= third)) {
            min = second;
            if (first <= third) {
                mid = first;
                max = third;
            } else {
                mid = third;
                max = first;
            }
        } else if ((third <= first) && (third <= second)) {
            min = third;
            if (first <= second) {
                mid = first;
                max = second;
            } else {
                mid = second;
                max = first;
            }
        }

        int paperForBox = (2 * min * mid) + (2 * mid * max) + (2 * max * min) + min;
        return paperForBox;
    }
}
