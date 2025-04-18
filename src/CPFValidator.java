public class CPFValidator {

  // Clear the string, keeping only numbers
  public static String clean(String cpf) {
    if (cpf == null)
      return "";
    // Regex to make all numbers
    return cpf.replaceAll("\\D+", "");
  }

  // Validade the cpf, includes verified numbers
  public static boolean isValid(String cpf) {
    cpf = clean(cpf);
    // Verify the length
    if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
      return false; // All the same numbers are not valid
    }

    // Verify the 2 digits
    int d1 = calculateVerifierDigit(cpf, 9);
    // The d1 is alredy in the cpf
    int d2 = calculateVerifierDigit(cpf, 10);

    // Check if the calculateVerifierDigit matches the 2 last digits
    // Use char - '0' to convert to number
    return cpf.charAt(9) - '0' == d1 && cpf.charAt(10) - '0' == d2;

  }

  /**
   * @param length to use in calculator (9 for first digit, 10 for second digit)
   * @return selected digit (0-9)
   */

  private static int calculateVerifierDigit(String cpf, int length) {
    // Add sum and weight
    int sum = 0;
    int weight = length + 1;// Starts in 10 for the first, 11 for the second

    for (int i = 0; i < length; i++) {
      // Convert to digit and * weigth--. 10 - 9 - 8 ...
      sum += (cpf.charAt(i) - '0') * (weight--);
    }

    // Calculate the mod and the return digit
    int mod = sum % 11;
    return (mod < 2) ? 0 : 11 - mod;
  }
}
