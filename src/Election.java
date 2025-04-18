import java.util.Scanner;

public class Election {
  private VoterMachine voterMachine;
  private Scanner scanner = new Scanner(System.in);

  // The election needs a votermachine, as contructor
  public Election(VoterMachine voterMachine) {
    this.voterMachine = voterMachine;
  }

  // Starts the election
  public void start() {
    System.out.println("Election started!");

    while (true) {
      // While tru, only break if option 2
      System.out.println("\n1. Vote\n2. End Election");
      System.out.println("Choose an option:");
      int option = scanner.nextInt();
      scanner.nextLine();
      if (option == 1) {
        System.out.println("Enter cpf:");
        String cpf = scanner.nextLine();

        System.out.println("Enter candidate number (-1 for blank): ");
        int number = scanner.nextInt();
        scanner.nextLine();

        // Update a vote on the voterMachine
        voterMachine.vote(cpf, number);
      } else if (option == 2) {
        // Call the end method
        end();
        break;
      } else {
        System.out.println("Invalid option.");

      }
    }
  }

  public void end() {
    System.out.println("\nElection ended.\n");
    // Calls the getResult.show method
    getResult().show();
  }

  public Result getResult() {
    // Get result returns a new result
    return new Result(voterMachine);
  }
}
