import java.util.Scanner;

public class GradingSystem {
    public static void main(String[] args) {
        System.out.println("A program to display the final marks and grades of students in a tabular form.");

        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = s.nextInt();
        System.out.println();

        String[] indexNumber = new String[n];
        double[] examsScore = new double[n];
        double[] midsemScore = new double[n];
        int[] finalScore = new int[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the Index Number of Student " + (i + 1) + " : ");
            indexNumber[i] = s.next();

            System.out.print("Enter Mid-Sem score: ");
            midsemScore[i] = s.nextDouble();

            System.out.print("Enter End of Semester score: ");
            examsScore[i] = s.nextDouble();

            finalScore[i] = getFinalScore(midsemScore[i], examsScore[i]);
            grade[i] = getGrade(finalScore[i]);

            System.out.println();
        }

        s.close();

        displayResults(n, indexNumber, finalScore, grade);
    }

    public static int getFinalScore(double midsem, double exams) {
        double convertedMidsemScore = (midsem / 100) * 30;
        double convertedExamsScore = (exams / 100) * 70;

        int finalScore = (int) Math.round(convertedMidsemScore + convertedExamsScore);

        return finalScore;
    }

    public static String getGrade(int n) {
        String grade;
        if (n >= 70) {
            grade = "A";
        } else if (n >= 60) {
            grade = "B";
        } else if (n >= 50) {
            grade = "C";
        } else if (n >= 40) {
            grade = "D";
        } else {
            grade = "F";
        }

        return grade;
    }

    public static void displayResults(int n, String[] indexNo, int[] score, String[] grade) {
        System.out.println("+" + "------------" + "+" + "------------" + "+" + "----------" + "+");
        System.out.println("|Index Number |Final Score  |Grade       |");
        System.out.println("+" + "------------" + "+" + "------------" + "+" + "----------" + "+");

        for (int i = 0; i < n; i++) {
            System.out.println(String.format("|%-13s|%-13d|%-12s|", indexNo[i], score[i], grade[i]));
        }

        System.out.println("+" + "------------" + "+" + "------------" + "+" + "----------" + "+");
    }
}
