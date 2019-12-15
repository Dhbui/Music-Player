import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public class NotePlayer {
   public Synthesizer synth;
   public MidiChannel[] channels;
   public int channel;

   public NotePlayer() {
      try {
         synth = MidiSystem.getSynthesizer();
         channels = synth.getChannels();
         channel = 0;
         init();
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void init() {
      try {
         synth.open();
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void stop() {
      synth.close();
   }

   public void playNote(int note, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play2Note(int note, int note2, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note2);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play2Note2(int note, int note2, int duration, int duration2, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         Thread.sleep(duration2);
         channels[channel].noteOff(note2);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play3Note(int note, int note2, int note3, int duration, int duration2, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note2);
         channels[channel].noteOn(note3, volume);
         Thread.sleep(duration2);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note3);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play3NoteOnce(int note, int note2, int note3, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note3);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play4NoteRest(int note, int note2, int note3, int note4, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note2);
         channels[channel].noteOn(note3, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note3);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note4);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play4Note(int note, int note2, int note3, int note4, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note2);
         channels[channel].noteOn(note3, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note3);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note4);
         channels[channel].noteOff(note);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play4NoteOnce(int note, int note2, int note3, int note4, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note3);
         channels[channel].noteOff(note4);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play4NoteAlt(int note, int note2, int note3, int note4, int duration, int duration2, int duration3,  int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOn(note3, volume);
         Thread.sleep(duration2);
         channels[channel].noteOff(note2);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration3);
         channels[channel].noteOff(note3);
         channels[channel].noteOff(note4);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play4Note2(int note, int note2, int note3, int note4, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note3);
         Thread.sleep(duration);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note4);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play4Note12(int note, int note2, int note3, int note4, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note2);
         channels[channel].noteOn(note3, volume);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note3);
         channels[channel].noteOff(note4);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play5NoteWChord(int note, int note2, int note3, int note4, int note5, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note3);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note4);
         channels[channel].noteOn(note5, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note5);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play5Note(int note, int note2, int note3, int note4, int note5, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note2);
         channels[channel].noteOn(note3, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note3);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note4);
         channels[channel].noteOn(note5, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note5);
         channels[channel].noteOff(note);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play5Note22(int note, int note2, int note3, int note4, int note5, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note3);
         channels[channel].noteOn(note4, volume);
         channels[channel].noteOn(note5, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note4);
         channels[channel].noteOff(note5);
         channels[channel].noteOff(note);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play5NoteWChord3(int note, int note2, int note3, int note4, int note5, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note4);
         channels[channel].noteOn(note5, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note3);
         channels[channel].noteOff(note5);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play6Note(int note, int note2, int note3, int note4, int note5, int note6, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         channels[channel].noteOn(note4, volume);
         channels[channel].noteOn(note5, volume);
         channels[channel].noteOn(note6, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note3);
         channels[channel].noteOff(note4);
         channels[channel].noteOff(note5);
         channels[channel].noteOff(note6);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play6Note2(int note, int note2, int note3, int note4, int note5, int note6, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note3);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note4);
         channels[channel].noteOn(note5, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note5);
         channels[channel].noteOn(note6, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note6);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play6Note122(int note, int note2, int note3, int note4, int note5, int note6, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note2);
         channels[channel].noteOn(note3, volume);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note3);
         channels[channel].noteOff(note4);
         channels[channel].noteOn(note5, volume);
         channels[channel].noteOn(note6, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note5);
         channels[channel].noteOff(note6);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play6NoteChord2(int note, int note2, int note3, int note4, int note5, int note6, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note3);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note4);
         channels[channel].noteOn(note5, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note5);
         channels[channel].noteOn(note6, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note6);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play6NoteChord22(int note, int note2, int note3, int note4, int note5, int note6, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note3);
         channels[channel].noteOff(note4);
         channels[channel].noteOn(note5, volume);
         channels[channel].noteOn(note6, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note5);
         channels[channel].noteOff(note6);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play6NoteChord3(int note, int note2, int note3, int note4, int note5, int note6, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note4);
         channels[channel].noteOn(note5, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note5);
         channels[channel].noteOn(note6, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note3);
         channels[channel].noteOff(note6);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play7NoteChord3(int note, int note2, int note3, int note4, int note5, int note6, int note7, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note4);
         channels[channel].noteOn(note5, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note5);
         channels[channel].noteOn(note6, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note6);
         channels[channel].noteOn(note7, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note3);
         channels[channel].noteOff(note7);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play7Note123(int note, int note2, int note3, int note4, int note5, int note6, int note7, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note2);
         channels[channel].noteOn(note3, volume);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note3);
         channels[channel].noteOff(note4);
         channels[channel].noteOn(note5, volume);
         channels[channel].noteOn(note6, volume);
         channels[channel].noteOn(note7, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note5);
         channels[channel].noteOff(note6);
         channels[channel].noteOff(note7);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play8Note223(int note, int note2, int note3, int note4, int note5, int note6, int note7, int note8, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note3);
         channels[channel].noteOn(note4, volume);
         channels[channel].noteOn(note5, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note4);
         channels[channel].noteOff(note5);
         channels[channel].noteOn(note6, volume);
         channels[channel].noteOn(note7, volume);
         channels[channel].noteOn(note8, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note6);
         channels[channel].noteOff(note7);
         channels[channel].noteOff(note8);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play8NoteChord2(int note, int note2, int note3, int note4, int note5, int note6, int note7, int note8, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note3);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note4);
         channels[channel].noteOn(note5, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note5);
         channels[channel].noteOn(note6, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note6);
         channels[channel].noteOn(note7, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note7);
         channels[channel].noteOn(note8, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note8);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play9NoteChord3(int note, int note2, int note3, int note4, int note5, int note6, int note7, int note8, int note9, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note4);
         channels[channel].noteOn(note5, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note5);
         channels[channel].noteOn(note6, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note6);
         channels[channel].noteOn(note7, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note7);
         channels[channel].noteOn(note8, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note8);
         channels[channel].noteOn(note9, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note3);
         channels[channel].noteOff(note9);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play9NoteChord21(int note, int note2, int note3, int note4, int note5, int note6, int note7, int note8, int note9, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note3);
         channels[channel].noteOff(note4);
         channels[channel].noteOn(note5, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note5);
         channels[channel].noteOn(note6, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note6);
         channels[channel].noteOn(note7, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note7);
         channels[channel].noteOn(note8, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note8);
         channels[channel].noteOn(note9, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note9);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play10NoteChord2(int note, int note2, int note3, int note4, int note5, int note6, int note7, int note8, int note9, int note10, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         channels[channel].noteOn(note4, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note3);
         channels[channel].noteOff(note4);
         channels[channel].noteOn(note5, volume);
         channels[channel].noteOn(note6, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note5);
         channels[channel].noteOff(note6);
         channels[channel].noteOn(note7, volume);
         channels[channel].noteOn(note8, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note7);
         channels[channel].noteOff(note8);
         channels[channel].noteOn(note9, volume);
         channels[channel].noteOn(note10, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note9);
         channels[channel].noteOff(note10);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void play10NoteChord4(int note, int note2, int note3, int note4, int note5, int note6, int note7, int note8, int note9, int note10, int duration, int volume) {
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         channels[channel].noteOn(note4, volume);
         channels[channel].noteOn(note5, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note5);
         channels[channel].noteOn(note6, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note6);
         channels[channel].noteOn(note7, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note7);
         channels[channel].noteOn(note8, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note8);
         channels[channel].noteOn(note9, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note9);
         channels[channel].noteOn(note10, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note3);
         channels[channel].noteOff(note4);
         channels[channel].noteOff(note10);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }
   public void play11NoteChord3(int note, int note2, int note3, int note4, int note5, int note6, int note7, int note8, int note9, int note10, int note11, int duration, int volume){
      try {
         channels[channel].noteOn(note, volume);
         channels[channel].noteOn(note2, volume);
         channels[channel].noteOn(note3, volume);
         channels[channel].noteOn(note4, volume);
         channels[channel].noteOn(note5, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note4);
         channels[channel].noteOff(note5);
         channels[channel].noteOn(note6, volume);
         channels[channel].noteOn(note7, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note6);
         channels[channel].noteOff(note7);
         channels[channel].noteOn(note8, volume);
         channels[channel].noteOn(note9, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note8);
         channels[channel].noteOff(note9);
         channels[channel].noteOn(note10, volume);
         channels[channel].noteOn(note11, volume);
         Thread.sleep(duration);
         channels[channel].noteOff(note);
         channels[channel].noteOff(note2);
         channels[channel].noteOff(note3);
         channels[channel].noteOff(note10);
         channels[channel].noteOff(note11);   
      }
      catch (Exception e){
         e.printStackTrace();
      }
   }

}
