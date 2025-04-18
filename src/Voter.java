public class Voter {
  private String name;
  private String cpf;
  private boolean hasVoted;

  // Constructor
  public Voter(String name, String cpf) {
    this.name = name;
    setCpf(cpf);
    this.hasVoted = false;
  }

  // Method to set the voter cpf
  public void setCpf(String cpf) {
    if (!CPFValidator.isValid(cpf)) {
      throw new IllegalArgumentException("CPF inválido: " + cpf);
    }
    this.cpf = CPFValidator.clean(cpf);
  }

  // Methods to get the cpf and format
  public String getCpf() {
    // To return the formated cpf
    return cpf;
  }

  public String formatCpf(String digits) {
    return digits.replaceFirst(
        "(\\d{3})(\\d{3})(\\d{3})(\\d{2})",
        "$1.$2.$3-$4");
  }

  public void setHasVoted(boolean condition) {
    this.hasVoted = condition;
  }

  // Some more get methods
  public boolean hasVoted() {
    return hasVoted;
  }

  public String getName() {
    return name;
  }
}
