import java.util.*;

public class TeamCompatibility {

    static String[] names = new String[4];
    static double[][] personality = new double[4][5];

    // Finds average of 3 answers
    static double average(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    // Finds compatibility between two people
    static double getCompatibility(double[] p1, double[] p2) {

        double difference = 0;

        for (int i = 0; i < 5; i++) {
            difference += Math.abs(p1[i] - p2[i]);
        }

        double score = 100 - (difference / 20 * 100);

        return Math.round(score);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("   TEAM COMPATIBILITY SYSTEM");
        System.out.println("================================");

        // Take data from 4 students
        for (int i = 0; i < 4; i++) {

            System.out.print("\nEnter Student " + (i + 1) + " name: ");
            names[i] = sc.nextLine();

            int[] answer = new int[15];

            System.out.println("\nGive answer from 1 to 5");
            System.out.println("1 - Strongly Disagree");
            System.out.println("2 - Disagree");
            System.out.println("3 - Neutral");
            System.out.println("4 - Agree");
            System.out.println("5 - Strongly Agree");

            for (int j = 0; j < 15; j++) {

                while (true) {

                    System.out.print(
                        "Question " + (j + 1) + ": "
                    );

                    int value = sc.nextInt();

                    if (value >= 1 && value <= 5) {
                        answer[j] = value;
                        break;
                    }

                    System.out.println("Enter number between 1 and 5.");
                }
            }

            sc.nextLine();

            // O - Openness
            personality[i][0] =
                average(answer[0], answer[1], answer[2]);

            // C - Conscientiousness
            personality[i][1] =
                average(answer[3], answer[4], answer[5]);

            // E - Extraversion
            personality[i][2] =
                average(answer[6], answer[7], answer[8]);

            // A - Agreeableness
            personality[i][3] =
                average(answer[9], answer[10], answer[11]);

            // Emotional Stability
            personality[i][4] =
                average(answer[12], answer[13], answer[14]);

            System.out.println("\n" + names[i] + " saved!");
        }

        // Show personality scores
        System.out.println("\n================================");
        System.out.println("       PERSONALITY RESULTS");
        System.out.println("================================");

        for (int i = 0; i < 4; i++) {

            System.out.println("\n" + names[i]);

            System.out.println("Openness: "
                    + personality[i][0]);

            System.out.println("Conscientiousness: "
                    + personality[i][1]);

            System.out.println("Extraversion: "
                    + personality[i][2]);

            System.out.println("Agreeableness: "
                    + personality[i][3]);

            System.out.println("Emotional Stability: "
                    + personality[i][4]);
        }

        // Compare all 6 possible pairs
        double bestScore = -1;

        String bestPerson1 = "";
        String bestPerson2 = "";

        System.out.println("\n================================");
        System.out.println("      COMPATIBILITY RESULTS");
        System.out.println("================================");

        for (int i = 0; i < 4; i++) {

            for (int j = i + 1; j < 4; j++) {

                double score =
                    getCompatibility(
                        personality[i],
                        personality[j]
                    );

                System.out.println(
                    names[i] + " + " +
                    names[j] + " = " +
                    score + "%"
                );

                if (score > bestScore) {

                    bestScore = score;

                    bestPerson1 = names[i];
                    bestPerson2 = names[j];
                }
            }
        }

        System.out.println("\n================================");
        System.out.println("          BEST MATCH");
        System.out.println("================================");

        System.out.println(
            bestPerson1 + " + " + bestPerson2
        );

        System.out.println(
            "Compatibility = " + bestScore + "%"
        );

        sc.close();
    }
}
