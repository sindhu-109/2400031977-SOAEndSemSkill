# Skill Experiment 9: Unit Testing for Payment Service

## Aim
To develop a simple Payment Service and test its methods independently using JUnit 5 and AssertJ.

## Requirements
- JDK 17 or later
- Apache Maven
- An IDE such as IntelliJ IDEA, Eclipse, or VS Code

## Project structure
```text
payment-service-unit-testing/
├── pom.xml
├── README.md
└── src/
    ├── main/java/com/example/payment/
    │   ├── Payment.java
    │   └── PaymentService.java
    └── test/java/com/example/payment/
        └── PaymentServiceTest.java
```

## Implementation
`PaymentService` provides:
- `validatePaymentDetails(Payment)`: checks payer name, payment ID, and a positive amount.
- `processPayment(Payment)`: processes valid details and returns a confirmation message. Invalid details produce an `IllegalArgumentException`.

## Test cases
1. Valid payment — expects successful processing.
2. Invalid amount — expects validation to fail and an exception during processing.
3. Missing details — expects validation to fail and an exception during processing.
4. Null payment — an additional boundary test.

## Run the tests
Open a terminal in the project folder and run:

```bash
mvn test
```

Maven downloads the test dependencies and executes the JUnit tests. A successful run reports **BUILD SUCCESS** and four tests passing.

## Expected result
All four test cases should pass:
- Valid payment is accepted.
- Zero or negative amounts are rejected.
- Missing required fields are rejected.
- A null payment is rejected safely.

## Analysis and inference
JUnit 5 is used to organize and execute test methods. AssertJ provides readable assertions for expected values and exceptions. The tests verify both valid and invalid inputs, helping detect errors in payment validation and processing logic.

## Note
This is an educational unit-testing example. It does not connect to a bank, payment gateway, or real payment system.
