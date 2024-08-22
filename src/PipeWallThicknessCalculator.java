import javax.swing.*;

import java.awt.*;


public class PipeWallThicknessCalculator {
    public PipeWallThicknessCalculator(){

        JFrame frame = new JFrame();
        frame.setTitle("First JFrame");
        frame.setSize(800, 700);
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Menu
        JLabel menu = new JLabel("Menu");
        frame.add(menu, BorderLayout.NORTH);

        // Main panel with all content
        CalculatorMain mainPanel = new CalculatorMain();
        frame.add(mainPanel, BorderLayout.CENTER);

        // Footer
//        JLabel footer = new JLabel("Coded by h4sski  ");
//        footer.setFont(new Font("Consolas", Font.PLAIN, 10));
//        footer.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add(getFooter(), BorderLayout.SOUTH);

//        frame.pack();
        frame.setVisible(true);
    }

    private JPanel getFooter() {
        JPanel footerPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(footerPanel, BoxLayout.X_AXIS);
        footerPanel.setLayout(boxLayout);
        footerPanel.setBackground(Settings.grayColor);

        JLabel footer = new JLabel("Coded by h4sski  ");
        footer.setFont(new Font("Consolas", Font.PLAIN, 10));
        footer.setForeground(Settings.whiteFontColor);
        footerPanel.add(footer);

        return footerPanel;
    }
}
