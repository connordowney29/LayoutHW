import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingControlDemo implements ActionListener {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JTextArea ta;
    private JTextArea inputArea;//typing area
    private int WIDTH=800;
    private int HEIGHT=700;


    public SwingControlDemo() {
        prepareGUI();
    }

    public static void main(String[] args) {
        SwingControlDemo swingControlDemo = new SwingControlDemo();
        swingControlDemo.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new BorderLayout());


        statusLabel = new JLabel("Input: ");
        inputArea = new JTextArea(1,50);
        ta = new JTextArea();
        ta.setEditable(false);
        JPanel inputPanel = new JPanel();
        inputPanel.add(statusLabel);
        inputPanel.add(inputArea);

        JScrollPane scrollPane = new JScrollPane(ta);




        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2,1));
        topPanel.add(inputPanel);
        topPanel.add(controlPanel);

        mainFrame.add(topPanel, BorderLayout.NORTH);
        mainFrame.add(scrollPane, BorderLayout.CENTER);


        mainFrame.setVisible(true);
    }

    private void showEventDemo() {

        JButton submitButton = new JButton("Submit");
        JButton resetButton = new JButton("Reset");
        JButton capsButton = new JButton("All Caps");


        submitButton.setActionCommand("Submit");
        resetButton.setActionCommand("Reset");
        capsButton.setActionCommand("All Caps");

        submitButton.addActionListener(new ButtonClickListener());
        resetButton.addActionListener(new ButtonClickListener());
        capsButton.addActionListener(new ButtonClickListener());


        controlPanel.add(submitButton);
        controlPanel.add(resetButton);
        controlPanel.add(capsButton);


        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Submit")) {
                ta.setText(inputArea.getText());
            } else if (command.equals("Reset")) {
                inputArea.setText("");
                ta.setText("");
            }
            else if (command.equals("All Caps")) {
                ta.setText(inputArea.getText().toUpperCase());
            }
        }
    }
}