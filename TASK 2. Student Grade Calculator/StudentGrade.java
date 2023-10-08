import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGrade extends JFrame {

    private JTextField hindiField, mathField, physicsField, biologyField, englishField;
    private JLabel  totalLabel, averageLabel;
    private JTextField totalField, averageField, overallGradeField;

    public StudentGrade() {
        Container c = getContentPane();
        c.setLayout(null);

        JLabel titleLabel = new JLabel("Student Grade Calculator");
        titleLabel.setForeground(Color.black);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        titleLabel.setBounds(50, 50, 270, 20);

        JLabel subjectLabel = new JLabel("Enter Grades for Subjects:");
        subjectLabel.setForeground(Color.white);
        subjectLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        subjectLabel.setBounds(50, 100, 270, 20);

        JLabel hindiLabel = new JLabel("Hindi:");
        hindiLabel.setForeground(Color.white);
        hindiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        hindiLabel.setBounds(50, 140, 70, 20);

        JLabel mathLabel = new JLabel("Math:");
        mathLabel.setForeground(Color.white);
        mathLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        mathLabel.setBounds(50, 170, 70, 20);

        JLabel physicsLabel = new JLabel("Physics:");
        physicsLabel.setForeground(Color.white);
        physicsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        physicsLabel.setBounds(50, 200, 70, 20);

        JLabel biologyLabel = new JLabel("Biology:");
        biologyLabel.setForeground(Color.white);
        biologyLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        biologyLabel.setBounds(50, 230, 70, 20);

        JLabel englishLabel = new JLabel("English:");
        englishLabel.setForeground(Color.white);
        englishLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        englishLabel.setBounds(50, 260, 70, 20);

        hindiField = new JTextField();
        mathField = new JTextField();
        physicsField = new JTextField();
        biologyField = new JTextField();
        englishField = new JTextField();

        hindiField.setBounds(130, 140, 100, 20);
        mathField.setBounds(130, 170, 100, 20);
        physicsField.setBounds(130, 200, 100, 20);
        biologyField.setBounds(130, 230, 100, 20);
        englishField.setBounds(130, 260, 100, 20);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBackground(Color.cyan);
        calculateButton.setBounds(50, 290, 150, 40);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });



        totalLabel = new JLabel("Total:");
        totalLabel.setForeground(Color.white);
        totalLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        totalLabel.setBounds(50, 370, 70, 20);

        totalField = new JTextField();
        totalField.setBounds(130, 370, 100, 20);
        totalField.setEditable(false);

        averageLabel = new JLabel("Average (%):");
        averageLabel.setForeground(Color.white);
        averageLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        averageLabel.setBounds(50, 400, 120, 20);

        averageField = new JTextField();
        averageField.setBounds(170, 400, 60, 20);
        averageField.setEditable(false);

        JLabel overallGradeLabel = new JLabel("Overall Grade:");
        overallGradeLabel.setForeground(Color.white);
        overallGradeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        overallGradeLabel.setBounds(50, 430, 120, 20);

        overallGradeField = new JTextField();
        overallGradeField.setBounds(170, 430, 100, 20);
        overallGradeField.setEditable(false);

        c.add(titleLabel);
        c.add(subjectLabel);
        c.add(hindiLabel);
        c.add(mathLabel);
        c.add(physicsLabel);
        c.add(biologyLabel);
        c.add(englishLabel);
        c.add(hindiField);
        c.add(mathField);
        c.add(physicsField);
        c.add(biologyField);
        c.add(englishField);
        c.add(calculateButton);
        c.add(totalLabel);
        c.add(totalField);
        c.add(averageLabel);
        c.add(averageField);
        c.add(overallGradeLabel);
        c.add(overallGradeField);

        getContentPane().setBackground(Color.black);
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Student Grade Calculator");
    }

    private void calculateGrade() {
        try {
            double hindiGrade = Double.parseDouble(hindiField.getText());
            double mathGrade = Double.parseDouble(mathField.getText());
            double physicsGrade = Double.parseDouble(physicsField.getText());
            double biologyGrade = Double.parseDouble(biologyField.getText());
            double englishGrade = Double.parseDouble(englishField.getText());

            double totalMarks = hindiGrade + mathGrade + physicsGrade + biologyGrade + englishGrade;
            double averagePercentage = totalMarks / 5;

            totalField.setText(Double.toString(totalMarks));
            averageField.setText(Double.toString(averagePercentage));

            // Determine the overall grade based on averagePercentage
            String overallGrade;
            if (averagePercentage >= 90) {
                overallGrade = "A";
            } else if (averagePercentage >= 80) {
                overallGrade = "B";
            } else if (averagePercentage >= 70) {
                overallGrade = "C";
            } else if (averagePercentage >= 60) {
                overallGrade = "D";
            } else {
                overallGrade = "F";
            }

            overallGradeField.setText(overallGrade);

//

        } catch (NumberFormatException ex) {
                System.out.println("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentGrade().setVisible(true);
            }
        });
    }
}
