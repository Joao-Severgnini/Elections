import java.util.List;

public class VoterMachine {
  private List<Candidate> candidates;
  private List<Voter> voters;
  private int nullVotes = 0;
  private int blankVotes = 0;

  public VoterMachine(List<Candidate> candidates, List<Voter> voters) {
    this.candidates = candidates;
    this.voters = voters;
  }

  // The vote algorith
  public void vote(String cpf, int number) {
    Voter voter = findVoterByCpf(cpf);

    if (voter == null) {
      System.out.println("Voter not found");
      return;
    }

    if (voter.hasVoted()) {
      System.out.println("This voter has already voted");
      return;
    }

    if (number == -1) {
      blankVotes++;
      voter.setHasVoted(true);
      System.out.println("Blank vote registered");
      return;
    }

    Candidate candidate = findCandidateByNumber(number);

    if (candidate == null) {
      nullVotes++;
      voter.setHasVoted(true);
      System.out.println("Invalid candidate number. Null vote registered");
      return;
    }

    candidate.addVote();
    voter.setHasVoted(true);
    System.out.println("Vote registered successfully");
  }

  // Auxiliary method to find voter by cpf
  private Voter findVoterByCpf(String cpf) {
    for (Voter v : voters) {
      if (v.getCpf().equals(cpf)) {
        return v;
      }
    }
    return null;
  }

  // Auxiliary method to find candidate by number
  private Candidate findCandidateByNumber(int number) {
    for (Candidate c : candidates) {
      if (c.getNumber() == number) {
        return c;
      }
    }
    return null;
  }
}
