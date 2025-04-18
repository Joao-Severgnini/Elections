import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    // Create the candidates
    List<Candidate> candidates = new ArrayList<>();
    candidates.add(new Candidate("João", 10, "Party A", 0));
    candidates.add(new Candidate("Giovanna", 11, "Party B", 0));
    candidates.add(new Candidate("Maria", 12, "Party C", 0));
    candidates.add(new Candidate("Enzo", 13, "Party D", 0));

    // Create the voters
    List<Voter> voters = new ArrayList<>();
    voters.add(new Voter("Alair", "00079554059"));
    voters.add(new Voter("Elenara", "04588259059"));

    // Create the voter machine
    VoterMachine vm = new VoterMachine(candidates, voters);

    // Starts the elction
    Election election = new Election(vm);
    election.start();
  }
}
