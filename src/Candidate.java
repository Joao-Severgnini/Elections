public class Candidate {
  private String name;
  private int number;
  private String party;
  private int votes;

  // Contructor for a candidate
  public Candidate(String name, int number, String party, int votes) {
    this.name = name;
    this.number = number;
    this.party = party;
    this.votes = votes;
  }

  // Getters
  public String getName() {
    return name;
  }

  public int getNumber() {
    return number;
  }

  public int getVotes() {
    return votes;
  }

  public String getParty() {
    return party;
  }

  // Increment vote
  public void addVote() {
    this.votes++;
  }

  // Set votes
  public void setVotes(int votes) {
    if (votes >= 0) {
      this.votes = votes;
    }
  }

  // Format the string
  @Override
  public String toString() {
    return String.format(
        "Candidate {name='%s', number=%d, party='%s', votes=%d}",
        name, number, party, votes);
  }
}
