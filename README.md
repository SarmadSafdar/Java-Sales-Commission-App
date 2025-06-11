Sales Commission Calculator
Description

This Java Swing application calculates a salesperson’s commission based on their monthly sales and any advance payments received. It features a simple graphical user interface for input and result display.
Features:

    Input monthly sales and advance payment.

    Calculates commission using tiered rates.

    Displays the final pay or amount owed to the company.

    Clear button to reset fields.

    Handles invalid inputs gracefully.

How to Run
Prerequisites

    Java Development Kit (JDK) installed (version 8 or later recommended).

Steps to run:

    Download the SalesCommissionCalculator.java file.

    Open a terminal or command prompt and navigate to the folder containing the .java file.

    Compile the Java source code:

javac SalesCommissionCalculator.java

Run the compiled program:

    java SalesCommissionCalculator

This will launch the graphical user interface for the Sales Commission Calculator.
Usage

    Enter the monthly sales amount.

    Enter the advance payment amount.

    Click Calculate Commission to see the commission details and final pay.

    Click Clear to reset all fields.

Notes

    The commission rate is based on monthly sales:

        Less than $10,000: 5%

        $10,000 to $14,999: 10%

        $15,000 to $17,999: 12%

        $18,000 to $21,999: 15%

        $22,000 and above: 16%

    If the salesperson’s pay is negative, they must reimburse the company.
