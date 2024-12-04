import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Countdown implements ActionListener {
    private JFrame frame = new JFrame();
    private JLabel timeLabel = new JLabel();
    private int countdown;
    private int initialCountdown; // Countdown starts from this value
    private Timer timer;

    public void startCountdown(){
        // Configure Time Display
        timeLabel.setText(countdown + ""); // Display initial countdown
        timeLabel.setBounds(100, 100, 200, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        // Kapoy nag label atay
        // Add GUI components
        frame.add(timeLabel);

        // Configure Main Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

        // Initialize and start the timer
        timer = new Timer(1000, this);
        timer.start();
    }

    public void changeTimer(int countdown) {
        initialCountdown = countdown;
        this.countdown = countdown;
    }

    public void reset() {
        countdown = initialCountdown; // Reset countdown to initial value
        timeLabel.setText(countdown + ""); 
        timer.restart(); // Restart the timer
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (countdown > 0) {
            countdown--; // Decrease countdown
            timeLabel.setText(countdown + ""); // Update display
        } else {
            timer.stop(); // Stop the timer when countdown reaches zero
            timeLabel.setText("Time's up!"); // Display message
        }
    }
}