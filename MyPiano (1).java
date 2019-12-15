import javax.swing.JFrame;
public class MyPiano
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("My Piano");
      frame.setSize(1000, 250);
      frame.setLocation(200, 100);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new MainPanel());
      frame.setVisible(true);
   }
}