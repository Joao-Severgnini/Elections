public class CPFValidator {

  // Clear the string, keeping only numbers
  public static String clean(String cpf) {
    if (cpf == null)
      return "";
    return cpf.replaceAll("\\D+", "");
  }

  // Validade the cpf, includes verified numbers
  public static boolean isValid(String cpf) {
    cpf = clean(cpf);
    if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
      return false; // All the same numbers are not valid
    }

    // Verify the 2 digits
    int d1 = calculateVerifierDigit(cpf, 9);
    int d2 = calculateVerifierDigit(cpf, 10);
  }
}
