import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Patrick White on 2/2/16.
 */
class MainPanel extends JPanel
{
   public NotePlayer myPiano;
   JPanel notepanel, buttonpanel;
   JButton nocturne, hello, birthday, furelise, buttonC, buttonD, buttonE, buttonF, buttonG, buttonA, buttonB, buttonC2, buttonDSharp, buttonD2, buttonE2, volup, voldown, lenup, lendown;
   JTextField volcount, lencount;
   private int volume = 80;
   private int length = 64;
   private final int MAXVOLUME = 127;
   private final int MINVOLUME = 0;
   private final int MAXLENGTH = 1024;
   private final int MINLENGTH = 16;
   public MainPanel()
   {
      notepanel = new JPanel(new FlowLayout());
      buttonpanel = new JPanel(new FlowLayout());
      
      setLayout(new BorderLayout());
      
      add(notepanel, BorderLayout.NORTH);
      add(buttonpanel, BorderLayout.SOUTH);
   
      myPiano = new NotePlayer();
            
      addButton(notepanel, "C", 62);
      addButton(notepanel, "D", 64);
      addButton(notepanel, "E", 66);
      addButton(notepanel, "F", 67);
      addButton(notepanel, "G", 69);
      addButton(notepanel, "G#", 70);
      addButton(notepanel, "A", 71);
      addButton(notepanel, "B", 73);
      addButton(notepanel, "C", 74);
      addButton(notepanel, "D", 76);
      addButton(notepanel, "D#", 77);
      addButton(notepanel, "E", 78);
   
      volup = new JButton("Vol " + "\u2191");
      voldown = new JButton("Vol "+ "\u2193");
      lenup = new JButton("Len "+ "\u2191");
      lendown = new JButton("Len "+ "\u2193");
      volcount = new JTextField("" + volume,4);
      lencount = new JTextField("" + length,4);
      furelise = new JButton("Play Fur Elise");
      nocturne = new JButton("Play Nocturne (WIP)");
      birthday = new JButton("Play Happy Birthday");
      hello = new JButton("Play Hello (WIP)");
            
      volcount.setHorizontalAlignment(SwingConstants.RIGHT);
      lencount.setHorizontalAlignment(SwingConstants.RIGHT);
      
      
      
      buttonpanel.add(volup);
      buttonpanel.add(volcount);
      buttonpanel.add(voldown);
      buttonpanel.add(lenup);
      buttonpanel.add(lencount);
      buttonpanel.add(lendown);
      buttonpanel.add(furelise);
      buttonpanel.add(nocturne);
      buttonpanel.add(birthday);
      buttonpanel.add(hello);
            
      volup.addActionListener(new VolupListener());
      voldown.addActionListener(new VoldownListener());
      lenup.addActionListener(new LenupListener());
      lendown.addActionListener(new LendownListener());
      volcount.addActionListener(new VolumeListener());
      lencount.addActionListener(new LengthListener());
      furelise.addActionListener(new SongListener());
      nocturne.addActionListener(new NocturneListener());
      birthday.addActionListener(new BirthdayListener());
      hello.addActionListener(new HelloListener());
   }

   private void addButton(JPanel panel, String s, int x)
   {
      JButton button = new JButton(s);
      panel.add(button);
      button.setPreferredSize(new Dimension(50,100));
      button.addActionListener(new ButtonListener(x));
   }
   private class ButtonListener implements ActionListener
   {
      private int myX;
      public ButtonListener(int x)
      {
         myX = x;
      }
      public void actionPerformed(ActionEvent e)
      {
         myPiano.playNote(myX, length, volume);
      }
   }
   class VolupListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         setVolume(getVolume()+20);
      }
   }
   class VoldownListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         setVolume(getVolume()-20);
      }
   }
   class LenupListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         int l =(int)(getLength()*1.5);
         setLength(l);
      }
   }
   class LendownListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {;
         int l = (int)(getLength()/1.5);
         setLength(l);
      }
   }
   class VolumeListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         int v = Integer.parseInt(volcount.getText());
         setVolume(v);
      }
   }
   class LengthListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         int l = Integer.parseInt(lencount.getText());
         setLength(l);
      }
   }
   class SongListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         playFurElise();
      }
   }
   class NocturneListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         playNocturne();
      }
   }
   class BirthdayListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         happyBirthday();
      }
   }
   class HelloListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         playHello();
      }
   }
   public void setVolume(int v)
   {
      if(v>MAXVOLUME)
      {
         v = MAXVOLUME;
      }
      if(v<MINVOLUME)
      {
         v = MINVOLUME;
      }
      volume = v;
      volcount.setText(""+v);
   }
   public int getVolume()
   {
      return volume;
   }
   public void setLength(int l)
   {
      if(l>MAXLENGTH)
      {
         l = MAXLENGTH;
      }
      if(l<MINLENGTH)
      {
         l = MINLENGTH;
      }
      length = l;
      lencount.setText(""+l);
   }
   public int getLength()
   {
      return length;
   }
   public void playHello()
   {
      myPiano.playNote(48, 300, volume);
      myPiano.playNote(50, 450, volume);
      myPiano.playNote(38, 1500, 0);
      myPiano.playNote(48, 300, volume);
      myPiano.playNote(48, 900, volume);
      myPiano.playNote(38, 900, 0);
      myPiano.playNote(46, 300, volume);
      myPiano.playNote(50, 300, volume);
      myPiano.playNote(50, 300, volume);
      myPiano.playNote(50, 150, volume);
      myPiano.playNote(50, 450, volume);
      myPiano.playNote(50, 150, volume);
      myPiano.playNote(50, 450, volume);//
      myPiano.playNote(48, 150, volume);
      myPiano.playNote(48, 450, volume);
      myPiano.playNote(46, 300, volume);
      myPiano.playNote(48, 450, volume);
      myPiano.playNote(50, 150, volume);
      myPiano.playNote(48, 300, volume);
      myPiano.playNote(44, 150, volume);
      myPiano.playNote(46, 750, volume);
      myPiano.playNote(38, 150, 0);
      myPiano.playNote(48, 150, volume);
      myPiano.playNote(50, 300, volume);
      myPiano.playNote(50, 450, volume);
      myPiano.playNote(48, 150, volume);
      myPiano.playNote(46, 300, volume);
      myPiano.playNote(38, 450, 0);
      myPiano.playNote(48, 275, volume);
      myPiano.playNote(48, 175, volume);
      myPiano.playNote(48, 450, volume);
      myPiano.playNote(50, 300, volume);
      myPiano.playNote(38, 300, 0);
   }
   public void happyBirthday()
   {
      myPiano.playNote(38, 450, volume);
      myPiano.playNote(38, 150, volume);
      myPiano.playNote(40, 600, volume);
      myPiano.playNote(38, 600, volume);
      myPiano.playNote(43, 600, volume);
      myPiano.playNote(42, 1200, volume);
      myPiano.playNote(38, 450, volume);
      myPiano.playNote(38, 150, volume);
      myPiano.playNote(40, 600, volume);
      myPiano.playNote(38, 600, volume);
      myPiano.playNote(45, 600, volume);
      myPiano.playNote(43, 1200, volume);
      myPiano.playNote(38, 450, volume);
      myPiano.playNote(38, 150, volume);
      myPiano.playNote(50, 600, volume);
      myPiano.playNote(47, 600, volume);
      myPiano.playNote(43, 600, volume);
      myPiano.playNote(42, 600, volume);
      myPiano.playNote(40, 600, volume);
      myPiano.playNote(48, 450, volume);
      myPiano.playNote(48, 150, volume);
      myPiano.playNote(47, 600, volume);
      myPiano.playNote(43, 600, volume);
      myPiano.playNote(45, 600, volume);
      myPiano.playNote(43, 1800, volume);
   }
   public void playFurElise()
   { 
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);//1
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//2
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(62, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(71, 250, volume);//3
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(58, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(70, 250, volume);
      myPiano.playNote(73, 250, volume);//4
      myPiano.play3Note(74, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(66, 250, volume);//5
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//6
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(62, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(71, 250, volume);//7
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(58, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(74, 250, volume);
      myPiano.playNote(73, 250, volume);//8
      myPiano.play4NoteRest(71, 47, 50, 59, 250, volume);//ending 1 (9)
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);//1
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//2
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(71, 250, volume);//3
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(58, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(70, 250, volume);
      myPiano.playNote(73, 250, volume);//4
      myPiano.play3Note(74, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(66, 250, volume);//5
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//6
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(62, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(71, 250, volume);//7
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(58, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(74, 250, volume);
      myPiano.playNote(73, 250, volume);//8
      myPiano.play3Note(71, 47, 50, 250, 250, volume);//ending 2
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(74, 250, volume);
      myPiano.playNote(76, 250, volume);//10
      myPiano.play4Note(78, 50, 54, 62, 250, volume);
      myPiano.playNote(69, 250, volume);
      myPiano.playNote(79, 250, volume);
      myPiano.playNote(78, 250, volume);//11
      myPiano.play4Note(76, 45, 54, 61, 250, volume);
      myPiano.playNote(67, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(76, 250, volume);//12
      myPiano.play4Note(74, 47, 50, 59, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//13
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(66, 250, volume);//14
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(90, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);//15
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);//16
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//17
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(62, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(71, 250, volume);//18
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(58, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(70, 250, volume);
      myPiano.playNote(73, 250, volume);//19
      myPiano.play3Note(74, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);//20
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//21
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(62, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(71, 250, volume);//22
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(58, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(74, 250, volume);
      myPiano.playNote(73, 250, volume);//23
      myPiano.play3Note(71, 47, 50, 250, 250, volume);//ending 1
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(74, 250, volume);
      myPiano.playNote(76, 250, volume);//24
      myPiano.play4Note(78, 50, 54, 62, 250, volume);
      myPiano.playNote(69, 250, volume);
      myPiano.playNote(79, 250, volume);
      myPiano.playNote(78, 250, volume);//11
      myPiano.play4Note(76, 45, 54, 61, 250, volume);
      myPiano.playNote(67, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(76, 250, volume);//12
      myPiano.play4Note(74, 47, 50, 59, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//13
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(66, 250, volume);//14
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(90, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);//15
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);//16
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//17
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(62, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(71, 250, volume);//18
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(58, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(70, 250, volume);
      myPiano.playNote(73, 250, volume);//19
      myPiano.play3Note(74, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);//20
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//21
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(62, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(71, 250, volume);//22
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(58, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(74, 250, volume);
      myPiano.playNote(73, 250, volume);//23
      myPiano.play3Note(71, 47, 50, 250, 250, volume);//ending 2
      myPiano.playNote(59, 250, volume);
      myPiano.play4NoteOnce(60, 62, 66, 74, 250, volume);
      myPiano.play4NoteOnce(59, 62, 67, 74, 250, volume);
      myPiano.play6Note(58, 60, 62, 66, 69, 74, 250, volume);
      myPiano.playNote(67, 125, volume);
      myPiano.playNote(71, 125, volume);
      myPiano.play5Note(74, 55, 59, 62, 59, 250, volume);
      myPiano.play4NoteAlt(62, 79, 59, 78, 250, 125, 125, volume);
      myPiano.play3Note(78, 58, 60, 250, 250, volume);
      myPiano.play3Note(76, 64, 60, 250, 250, volume);
      myPiano.play4NoteAlt(62, 84, 60, 83, 250, 125, 125, volume);
      myPiano.play2Note(55, 83, 250, volume);
      myPiano.play2Note(66, 81, 250, volume);
      myPiano.play4NoteOnce(55, 57, 60, 79, 250, volume);
      myPiano.play2Note(66, 78, 250, volume);
      myPiano.play4NoteOnce(55, 57, 60, 76, 250, volume);
      myPiano.play2Note(66, 74, 250, volume);
      myPiano.play3Note(72, 55, 59, 250, 250, volume);
      myPiano.play4NoteAlt(62, 71, 59, 72, 250, 175, 75, volume);
      myPiano.play3Note(62, 71, 69, 125, 125, volume);
      myPiano.play3Note(59, 71, 72, 125, 125, volume);
      myPiano.play5Note(74, 55, 59, 62, 59, 250, volume);
      myPiano.play2Note(62, 76, 250, volume);
      myPiano.play2Note(59, 77, 250, volume);
      myPiano.play4Note(78, 54, 59, 62, 250, volume);
      myPiano.play2Note(59, 78, 250, volume);
      myPiano.play3NoteOnce(52, 64, 79, 250, volume);
      myPiano.play2Note(55, 71, 250, volume);
      myPiano.play5Note(71, 57, 66, 57, 66, 250, volume);
      myPiano.play4NoteAlt(57, 76, 67, 73, 250, 125, 125, volume);
      myPiano.play6Note2(62, 66, 74, 81, 69, 81, 125, volume);
      myPiano.playNote(71, 125, volume);
      myPiano.playNote(81, 125, volume);
      myPiano.play4Note2(67, 69, 73, 81, 125, volume);
      myPiano.play4Note2(66, 69, 74, 81, 125, volume);
      myPiano.play5NoteWChord3(64, 67, 69, 76, 81, 125, volume);
      myPiano.play7NoteChord3(62, 64, 66, 78, 81, 86, 85, 125, volume);
      myPiano.play6NoteChord2(55, 59, 83, 81, 79, 78, 125, volume);
      myPiano.play6NoteChord2(57, 61, 76, 81, 79, 76, 125, volume);
      myPiano.play5Note(62, 74, 81, 69, 81, 125, volume);
      myPiano.playNote(71, 125, volume);
      myPiano.playNote(81, 125, volume);
      myPiano.play4Note2(67, 69, 73, 81, 125, volume);
      myPiano.play4Note2(66, 69, 74, 81, 125, volume);
      myPiano.play5NoteWChord3(64, 67, 69, 76, 81, 125, volume);//end of page 1
      myPiano.play7NoteChord3(62, 64, 66, 78, 81, 86, 85, 125, volume);
      myPiano.play6NoteChord2(55, 59, 83, 81, 79, 78, 125, volume);
      myPiano.play6NoteChord2(57, 61, 76, 81, 79, 76, 125, volume);//36
      myPiano.play6NoteChord2(58, 61, 78, 79, 78, 77, 125, volume);
      myPiano.playNote(78, 125, volume);
      myPiano.playNote(73, 125, volume);
      myPiano.playNote(78, 125, volume);
      myPiano.playNote(77, 125, volume);
      myPiano.playNote(78, 125, volume);
      myPiano.playNote(73, 125, volume);
      myPiano.playNote(78, 125, volume);
      myPiano.playNote(77, 125, volume);//37
      myPiano.playNote(78, 750, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);//38
      myPiano.playNote(78, 750, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);//39
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);//40
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//41
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(71, 250, volume);//42
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(58, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(70, 250, volume);
      myPiano.playNote(73, 250, volume);//43
      myPiano.play3Note(74, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(66, 250, volume);//44
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//45
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(62, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(71, 250, volume);//46
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(58, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(74, 250, volume);
      myPiano.playNote(73, 250, volume);//47
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(74, 250, volume);
      myPiano.playNote(76, 250, volume);//48
      myPiano.play4Note(78, 50, 54, 62, 250, volume);
      myPiano.playNote(69, 250, volume);
      myPiano.playNote(79, 250, volume);
      myPiano.playNote(78, 250, volume);//49
      myPiano.play4Note(76, 45, 54, 61, 250, volume);
      myPiano.playNote(67, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(76, 250, volume);//50
      myPiano.play4Note(74, 47, 50, 59, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//51
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(66, 250, volume);//52
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(90, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);//53
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);//54
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//55
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(62, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(71, 250, volume);//56
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(58, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(70, 250, volume);
      myPiano.playNote(73, 250, volume);//57
      myPiano.play3Note(74, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);//58
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//59
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(62, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(71, 250, volume);//60
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(58, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(74, 250, volume);
      myPiano.playNote(73, 250, volume);//61
      myPiano.play3Note(71, 47, 47, 250, 250, volume);
      myPiano.playNote(47, 250, volume);
      myPiano.playNote(47, 250, volume);
      myPiano.playNote(47, 250, volume);
      myPiano.playNote(47, 250, volume);//62
      myPiano.play10NoteChord4(66, 69, 72, 75, 47, 47, 47, 47, 47, 47, 250, volume);//63
      myPiano.play7NoteChord3(62, 68, 71, 47, 47, 47, 47, 250, volume);
      myPiano.play3NoteOnce(47, 75, 78, 250, volume);
      myPiano.play3NoteOnce(47, 76, 79, 250, volume);//64
      myPiano.play7NoteChord3(70, 76, 79, 47, 47, 47, 47, 250, volume);
      myPiano.play5NoteWChord3(70, 76, 79, 47, 47, 250, volume);//65
      myPiano.play9NoteChord3(71, 74, 78, 47, 47, 47, 47, 47, 47, 250, volume);//66
      myPiano.play10NoteChord2(67, 76, 40, 47, 40, 47, 40, 47, 40, 47, 250, volume);
      myPiano.play4NoteOnce(40, 47, 66, 74, 250, volume);
      myPiano.play4NoteOnce(40, 47, 64, 73, 250, volume);//67
      myPiano.play11NoteChord3(62, 68, 71, 41, 47, 41, 47, 41, 47, 41, 47, 250, volume);
      myPiano.play6NoteChord22(62, 71, 41, 47, 41, 47, 250, volume);//68
      myPiano.play6NoteChord22(62, 71, 42, 47, 42, 47, 250, volume);
      myPiano.play6NoteChord22(66, 74, 42, 47, 42, 47, 250, volume);
      myPiano.play6NoteChord22(64, 73, 42, 46, 42, 46, 250, volume);//69
      myPiano.play9NoteChord21(62, 71, 35, 47, 47, 47, 47, 47, 47, 250, volume);//70
      myPiano.play10NoteChord4(66, 69, 72, 74, 47, 47, 47, 47, 47, 47, 250, volume);//71
      myPiano.play7NoteChord3(67, 71, 76, 47, 47, 47, 47, 250, volume);
      myPiano.play3NoteOnce(47, 75, 78, 250, volume);
      myPiano.play3NoteOnce(47, 76, 79, 250, volume);//72
      myPiano.play6NoteChord2(76, 79, 47, 47, 47, 47, 250, volume);
      myPiano.play4Note2(76, 79, 47, 47, 250, volume);
      myPiano.play8NoteChord2(76, 79, 48, 48, 48, 48, 48, 48, 250, volume);//74 end of page 2
      myPiano.play6NoteChord2(69, 77, 48, 48, 48, 48, 250, volume);
      myPiano.play3NoteOnce(48, 67, 76, 250, volume);
      myPiano.play3NoteOnce(48, 65, 74, 250, volume);//75
      myPiano.play6NoteChord2(64, 72, 48, 48, 48, 48, 250, volume);
      myPiano.play5NoteWChord3(66, 67, 71, 48, 48, 250, volume);//76
      myPiano.play7NoteChord3(64, 67, 70, 49, 49, 49, 49, 250, volume);
      myPiano.play5NoteWChord3(64, 67, 70, 49, 49, 250, volume);//77
      myPiano.play4NoteOnce(49, 62, 66, 71, 1000, volume);
      myPiano.playNote(0, 500, 0);//78
      myPiano.play4NoteOnce(50, 58, 66, 73, 500, volume);
      myPiano.playNote(0, 1000, 0);//79
      myPiano.play4Note(35, 59, 62, 66, 166, volume);
      myPiano.playNote(71, 166, volume);
      myPiano.playNote(74, 166, volume);
      myPiano.playNote(78, 166, volume);
      myPiano.play6NoteChord3(58, 62, 66, 76, 74, 73, 166, volume);//80
      myPiano.play6NoteChord3(58, 62, 66, 71, 74, 78, 166, volume);
      myPiano.playNote(83, 166, volume);
      myPiano.playNote(86, 166, volume);
      myPiano.playNote(90, 166, volume);
      myPiano.play6NoteChord3(58, 62, 66, 88, 86, 85, 166, volume);//81
      myPiano.play6NoteChord3(58, 62, 66, 83, 86, 90, 166, volume);
      myPiano.playNote(95, 166, volume);
      myPiano.playNote(98, 166, volume);
      myPiano.playNote(102, 166, volume);
      myPiano.play6NoteChord3(58, 62, 66, 100, 98, 97, 166, volume);//82
      myPiano.play6NoteChord3(58, 62, 66, 96, 95, 94, 166, volume);
      myPiano.playNote(93, 166, volume);
      myPiano.playNote(92, 166, volume);
      myPiano.playNote(91, 166, volume);
      myPiano.playNote(90, 166, volume);
      myPiano.playNote(89, 166, volume);
      myPiano.playNote(88, 166, volume);//83
      myPiano.playNote(87, 166, volume);
      myPiano.playNote(86, 166, volume);
      myPiano.playNote(85, 166, volume);
      myPiano.playNote(84, 166, volume);
      myPiano.playNote(83, 166, volume);
      myPiano.playNote(82, 166, volume);
      myPiano.playNote(81, 166, volume);
      myPiano.playNote(80, 166, volume);
      myPiano.playNote(79, 166, volume);//84
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//85
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(71, 250, volume);//86
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(58, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(70, 250, volume);
      myPiano.playNote(73, 250, volume);//87
      myPiano.play3Note(74, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(66, 250, volume);//88
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//89
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(62, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(71, 250, volume);//90
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(58, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(74, 250, volume);
      myPiano.playNote(73, 250, volume);//91
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(74, 250, volume);
      myPiano.playNote(76, 250, volume);//92
      myPiano.play4Note(78, 50, 54, 62, 250, volume);
      myPiano.playNote(69, 250, volume);
      myPiano.playNote(79, 250, volume);
      myPiano.playNote(78, 250, volume);//93
      myPiano.play4Note(76, 45, 54, 61, 250, volume);
      myPiano.playNote(67, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(76, 250, volume);//94
      myPiano.play4Note(74, 47, 50, 59, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//95
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(66, 250, volume);//96
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(90, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);//97
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);//98
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//99
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(62, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(71, 250, volume);//100
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(58, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(70, 250, volume);
      myPiano.playNote(73, 250, volume);//101
      myPiano.play3Note(74, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);//102
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(77, 250, volume);
      myPiano.playNote(78, 250, volume);
      myPiano.playNote(73, 250, volume);
      myPiano.playNote(76, 250, volume);
      myPiano.playNote(74, 250, volume);//103
      myPiano.play3Note(71, 47, 50, 250, 250, volume);
      myPiano.playNote(59, 250, volume);
      myPiano.playNote(62, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(71, 250, volume);//104
      myPiano.play3Note(73, 42, 50, 250, 250, volume);
      myPiano.playNote(58, 250, volume);
      myPiano.playNote(66, 250, volume);
      myPiano.playNote(74, 250, volume);
      myPiano.playNote(73, 250, volume);//105
      myPiano.play4NoteOnce(35, 47, 62, 71, 1000, volume);//106
   }
   public void playNocturne()
   {
      myPiano.playNote(72, 400, volume);//1
      myPiano.play8Note223(81, 41, 53, 57, 65, 61, 65, 69, 400, volume);
      myPiano.play3NoteOnce(41, 53, 81, 400, volume);
      myPiano.play3NoteOnce(57, 64, 79, 400, volume);
      myPiano.play4NoteOnce(61, 64, 70, 81, 400, volume);
      myPiano.play8Note223(79, 41, 53, 57, 65, 61, 65, 69, 400, volume);
      myPiano.play5Note22(77, 40, 52, 57, 65, 400, volume);
      myPiano.play4NoteOnce(61, 65, 69, 72, 400, volume);//2
      myPiano.play5Note22(81, 38, 50, 57, 66, 400, volume);
      myPiano.play4NoteOnce(60, 66, 69, 74, 400, volume);
      myPiano.play5Note22(86, 38, 50, 57, 66, 400, volume);
      myPiano.play4NoteOnce(62, 66, 72, 81, 400, volume);
      myPiano.play7Note123(84, 43, 55, 63, 60, 64, 66, 400, volume);
      myPiano.play4Note12(82, 43, 55, 62, 400, volume);
      myPiano.play4NoteOnce(59, 62, 67, 81, 400, volume);//3
      myPiano.play6Note122(79, 48, 55, 64, 64, 70, 400, volume);
      myPiano.play4Note12(49, 81, 57, 67, 400, volume);
      myPiano.play4NoteOnce(64, 67, 69, 76, 400, volume);
      myPiano.play7Note123(77, 50, 57, 65, 63, 65, 68, 400, volume);
      myPiano.play7Note123(74, 47, 56, 65, 62, 65, 68, 400, volume);//4
      myPiano.play2Note(48, 72, 400, volume);
      myPiano.play3NoteOnce(55, 65, 88, 400, volume);
      myPiano.play4NoteOnce(60, 65, 70, 86, 400, volume);
      /*A 35
      B 37
      C 38
      D 40
      E 42
      F 43
      G 45
      A 47
      B 49
      C 50
      D 52
      E 54
      F 55
      G 57
      A 59
      "B" 61
      addButton(notepanel, "C", 62);
      addButton(notepanel, "D", 64);
      addButton(notepanel, "E", 66);
      addButton(notepanel, "F", 67);
      addButton(notepanel, "G", 69);
      addButton(notepanel, "G#", 70);
      addButton(notepanel, "A", 71);
      addButton(notepanel, "B", 73);
      addButton(notepanel, "C", 74);
      addButton(notepanel, "D", 76);
      addButton(notepanel, "D#", 77);
      addButton(notepanel, "E", 78);
      F 79
      G 81
      A 83
      B 85
      C 86
      D 88
      E 90*/
      
   }

}