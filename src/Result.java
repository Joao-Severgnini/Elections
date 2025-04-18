import java.util.List;

public class Result {
  private VoterMachine voterMachine;

  // The result controctor only uses the voterMachine
  public Result(VoterMachine voterMachine) {
    this.voterMachine = voterMachine;
  }

  // The show result method
  public void show() {
    // First show all the results
    voterMachine.showResults();
    // Gets the winner and show him
    Candidate winner = getWinner();
    if (winner != null) {
      System.out.println("");
      System.out
          .println("Winner: " + winner.getName() + " (" + winner.getParty() + ")" + " Votes: " + winner.getVotes());
    } else {
      System.out.println("No winner (tie or no votes)");
    }
  }

  // Method that iterates for each candidate and return the winner
  private Candidate getWinner() {
    // Create a local List<Candidates> with the vm method
    List<Candidate> candidates = voterMachine.getCandidates();
    Candidate winner = null;
    int maxVotes = 0;
    boolean tie = false;

    // Loop to calculate the winner
    for (Candidate c : candidates) {
      if (c.getVotes() > maxVotes) {
        maxVotes = c.getVotes();
        winner = c;
        tie = false;
      } else if (c.getVotes() == maxVotes && maxVotes != 0) {
        tie = true;
      }
    }
    // Return null if tie
    return tie ? null : winner;
  }
}
