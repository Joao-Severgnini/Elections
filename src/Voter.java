public class Voter {
  private String name;
  private String cpf;
  private boolean hasVoted;

  public Voter(String name, String cpf) {
    this.name = name;
    setCpf(cpf);
    this.hasVoted = false;
  }
}
