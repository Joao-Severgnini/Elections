import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Create the Lists
    Scanner scanner = new Scanner(System.in);
    List<Candidate> candidates = new ArrayList<>();
    List<Voter> voters = new ArrayList<>();

    // Ask for usage
    System.out.print("How many candidates will we have in the election? ");
    int candidateCount = scanner.nextInt();
    System.out.println("");
    scanner.nextLine();

    // Create the candidates
    for (int i = 0; i < candidateCount; i++) {
      String name;
      int number;
      String party;
      int votes = 0;

      System.out.println("================================================");
      System.out.println("Candidate registration " + (i + 1));
      System.out.print("Candidate Name: ");
      name = scanner.nextLine();

      // Infinite loop to only accept valid numbers
      boolean validNumber = false;
      do {
        System.out.print("Candidate Number: ");
        number = scanner.nextInt();
        scanner.nextLine();

        // Check if alreadyUsed
        boolean alreadyUsed = false;
        for (Candidate c : candidates) {
          if (c.getNumber() == number) {
            alreadyUsed = true;
            break;
          }
        }

        // Shows the error message
        if (alreadyUsed) {
          System.out.println("This number is already in use!");
          System.out.println("Please choose another one.");
        } else {
          validNumber = true;
        }

      } while (!validNumber);

      System.out.print("Candidate Party: ");
      party = scanner.nextLine();
      candidates.add(new Candidate(name, number, party, votes));
      System.out.println("Candidate " + name + " Registered Successfully!!");
    }

    System.out.println("================================================");
    System.out.println("");
    // Ask for usage
    System.out.print("How many voters will we have in the election? ");
    int voterCount = scanner.nextInt();
    scanner.nextLine();
    System.out.println("");

    // Create the voters
    for (int j = 0; j < voterCount; j++) {
      String name;
      String cpf;
      Voter voter = null;

      System.out.println("================================================");
      System.out.println("Voter registration " + (j + 1));
      System.out.print("Voter Name: ");
      name = scanner.nextLine();

      // Loop to only accept valid voters
      do {
        System.out.print("Voter CPF: ");
        cpf = scanner.nextLine();

        // Check if the CPF is already used
        boolean cpfAlreadyUsed = false;
        for (Voter existingVoter : voters) {
          if (existingVoter.getCpf().equals(cpf)) {
            System.out.println("This CPF Is Already Registered!");
            System.out.println("Please Enter A Different One.");
            cpfAlreadyUsed = true;
            break;
          }
        }

        if (!cpfAlreadyUsed) {
          try {
            voter = new Voter(name, cpf); // Try to create, this triggers the cpf validation
          } catch (IllegalArgumentException e) {
            // Show the error to user
            System.out.println("Invalid CPF. Please try again.");
          }

        }
      } while (voter == null);

      voters.add(voter);
      System.out.println("Voter registered: " + name);
    }

    // Create the voter machine
    VoterMachine vm = new VoterMachine(candidates, voters);

    // Starts the elction
    Election election = new Election(vm);
    election.start();
    scanner.close();
  }
}
