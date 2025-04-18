import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Candidate> candidates = new ArrayList<>();
    List<Voter> voters = new ArrayList<>();

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

      boolean validNumber = false;
      do {
        System.out.print("Candidate Number: ");
        number = scanner.nextInt();
        scanner.nextLine();

        boolean alreadyUsed = false;
        for (Candidate c : candidates) {
          if (c.getNumber() == number) {
            alreadyUsed = true;
            break;
          }
        }

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

      do {
        System.out.print("Voter CPF: ");
        cpf = scanner.nextLine();

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
            voter = new Voter(name, cpf); // Try to create
          } catch (IllegalArgumentException e) {
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
