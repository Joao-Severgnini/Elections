import java.util.Scanner;

public class Election {
  private VoterMachine voterMachine;
  private Scanner scanner = new Scanner(System.in);

  public Election(VoterMachine voterMachine) {
    this.voterMachine = voterMachine;
  }

  public void start() {
    System.out.println("Election started!");

    while (true) {
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

        voterMachine.vote(cpf, number);
      } else if (option == 2) {
        end();
        break;
      } else {
        System.out.println("Invalid option.");

      }
    }
  }

  public void end() {
    System.out.println("\nElection ended.\n");
    getResult().show();
  }

  public Result getResult() {
    return new Result(voterMachine);
  }
}
