import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SalesCommissionCalculator 
{
	private JFrame frame;
    private JTextField salesField;
    private JTextField advanceField;
    private JButton calculateButton;
    private JButton clearButton;
    private JTextArea resultArea;

    public SalesCommissionCalculator() {
        // Create the frame
        frame = new JFrame("Sales Commission Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create and set up components
        salesField = new JTextField(10);
        advanceField = new JTextField(10);
        calculateButton = new JButton("Calculate Commission");
        clearButton = new JButton("Clear");
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        // Layout
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Monthly Sales:"));
        inputPanel.add(salesField);
        inputPanel.add(new JLabel("Advance Payment:"));
        inputPanel.add(advanceField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);

        // Add components to frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        // Action listener for calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateCommission();
            }
        });

        // Action listener for clear button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salesField.setText("");
                advanceField.setText("");
                resultArea.setText("");
            }
        });

        // Finalize the frame
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void calculateCommission() {
        try {
            double sales = Double.parseDouble(salesField.getText());
            double advance = Double.parseDouble(advanceField.getText());
            double rate = determineCommissionRate(sales);
            double commission = sales * rate;
            double pay = commission - advance;

            StringBuilder results = new StringBuilder();
            results.append(String.format("Total Sales: $%.2f\n", sales));
            results.append(String.format("Commission Rate: %.0f%%\n", rate * 100));
            results.append(String.format("Commission: $%.2f\n", commission));
            results.append(String.format("Advance: $%.2f\n", advance));
            if (pay > 0) {
                results.append(String.format("The salesperson's pay is: $%.2f\n", pay));
            } else {
                results.append(String.format("The salesperson must reimburse the company: $%.2f\n", -pay));
            }
            resultArea.setText(results.toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers for sales and advance pay.");
        }
    }

    private double determineCommissionRate(double sales) {
        if (sales < 10000) return 0.05;
        if (sales < 15000) return 0.10;
        if (sales < 18000) return 0.12;
        if (sales < 22000) return 0.15;
        return 0.16;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SalesCommissionCalculator::new);
    }
}
