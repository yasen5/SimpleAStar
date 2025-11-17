import java.awt.*;
import javax.swing.*;

public class Screen extends JPanel {
    
    public static Point goal = new Point(6, 8, null);

    public Screen() {
        setLayout(null);
        setFocusable(true);
        
    }

    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    
}