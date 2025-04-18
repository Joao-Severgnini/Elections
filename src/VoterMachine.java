import java.util.List;

public class VoterMachine {
  private List<Candidate> candidates;
  private List<Voter> voters;
  private int nullVotes = 0;
  private int blankVotes = 0;

  // Constructor
  public VoterMachine(List<Candidate> candidates, List<Voter> voters) {
    this.candidates = candidates;
    this.voters = voters;
  }

  // The vote algorithm
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

  public void showCandidates() {
    System.out.println("============== List of Candidates ==============");
    for (Candidate c : candidates) {
      System.out.println("Name: " + c.getName() + " | Number: " + c.getNumber());
    }
    System.out.println("================================================");
  }

  public void showResults() {
    System.out.println("================================================");
    System.out.println("=============== Election Results ===============");
    for (Candidate c : candidates) {
      System.out.println(c);
    }
    System.out.println("Blank votes: " + blankVotes);
    System.out.println("Null votes:  " + nullVotes);
  }

  public List<Candidate> getCandidates() {
    return candidates;
  }

  public List<Voter> getVoters() {
    return voters;
  }
}
