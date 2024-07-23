package exp1;

import java.util.Scanner;

public class FCFS {
    public static void main(String[] args) {
        int[] bt = new int[20], wt = new int[20], tat = new int[20];
        int n, i;
        float wtavg, tatavg;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        n = scanner.nextInt();

        for (i = 0; i < n; i++) {
            System.out.print("Enter Burst Time for Process " + i + ": ");
            bt[i] = scanner.nextInt();
        }

        wt[0] = (int) (wtavg = 0);
        tat[0] = (int) (tatavg = bt[0]);
        for (i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
            tat[i] = tat[i - 1] + bt[i];
            wtavg += wt[i];
            tatavg += tat[i];
        }

        System.out.println("\t PROCESS \t BURST TIME \t WAITING TIME \t TURNAROUND TIME");
        for (i = 0; i < n; i++) {
            System.out.println("\n\t P" + i + "\t\t " + bt[i] + "\t\t " + wt[i] + "\t\t " + tat[i]);
        }
        System.out.println("\nAverage Waiting Time: " + wtavg / n);
        System.out.println("Average Turnaround Time: " + tatavg / n);

        scanner.close();
    }
}