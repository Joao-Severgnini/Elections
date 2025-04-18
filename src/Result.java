import java.util.List;

public class Result {
  private VoterMachine voterMachine;

  public Result(VoterMachine voterMachine) {
    this.voterMachine = voterMachine;
  }

  public void show() {
    voterMachine.showResults();
    Candidate winner = getWinner();
    if (winner != null) {
      System.out.println("Winner: " + winner.getName() + " (" + winner.getParty() + ")");
    } else {
      System.out.println("No winner (tie or no votes)");
    }
  }

  private Candidate getWinner() {
    List<Candidate> candidates = voterMachine.getCandidates();
    Candidate winner = null;
    int maxVotes = 0;
    boolean tie = false;

    for (Candidate c : candidates) {
      if (c.getVotes() > maxVotes) {
        maxVotes = c.getVotes();
        winner = c;
        tie = false;
      } else if (c.getVotes() == maxVotes && maxVotes != 0) {
        tie = true;
      }
    }
    return tie ? null : winner;
  }
}
