# 🗳️ Java Voting Machine (Terminal-based)

A simple terminal-based voting machine project written in Java to practice Object-Oriented Programming (OOP) concepts.

## 📋 Features

- Candidate and voter registration  
- CPF validation for voters (Brazilian personal ID)  
- Prevention of duplicate voter CPF and candidate number  
- Voting process (including null and blank votes)  
- Vote counting and result display  
- Full interaction via command line  

## 🧱 Technologies

- Java (Standard Edition)  
- Terminal I/O (`Scanner`)  
- OOP principles: encapsulation, constructors, getters/setters, helper methods, etc.

## 🚀 How to Run

1. Clone the repository or download the files.  
2. Compile the project:

   ```bash
   javac Main.java
   ```

3. Run the program:

   ```bash
   java Main
   ```

4. Follow the on-screen instructions to:
   - Register candidates and voters  
   - Vote using a valid CPF  
   - View the election results  

## 📁 Project Structure

```
├── Candidate.java       # Candidate data and vote logic
├── Voter.java           # Voter data and CPF validation
├── VoterMachine.java    # Core voting logic
├── Election.java        # Controls the start and end of election
├── Result.java          # Calculates and displays results
└── Main.java            # Entry point and user interaction
```

## ✅ Validations

- Voter CPF must be valid (Brazilian CPF algorithm).  
- CPF must be unique.  
- Candidate numbers must be unique.  
- A voter can only vote once.  

## 🔒 Notes

- All votes are stored in memory only (no database or file saving).  
- This project is for learning purposes only.  

## 🙌 Author

Made with 💻 and ☕ by João Severgnini
