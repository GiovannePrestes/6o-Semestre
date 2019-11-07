package audio;


import java.io.File; 
import java.io.IOException; 
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.DataLine; 
import javax.sound.sampled.FloatControl; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.SourceDataLine; 
import javax.sound.sampled.UnsupportedAudioFileException; 
 



public class PlayWave extends Thread { 

    
    private static final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb 
    private static byte audiosBytes[][] = new byte[10][];
    private static AudioFormat format[] = new AudioFormat[10];
    private static int index=0;
    public int tocar=0;
    
    
    public PlayWave(int tocar)
    {
      this.tocar = tocar;
    }
    
    
    public static void novoAudio(String name)
    {
       URL url = PlayWave.class.getResource(name);
        
       AudioInputStream audioInputStream = null;
         try { 
            audioInputStream = AudioSystem.getAudioInputStream(url);
        } catch (UnsupportedAudioFileException e1) { 
            e1.printStackTrace();
            return;
        } catch (IOException e1) { 
            e1.printStackTrace();
            return;
        } 
 
        format[index] = audioInputStream.getFormat();
        
        int nBytesRead=0;
        audiosBytes[index] = new byte[EXTERNAL_BUFFER_SIZE];
        
        while (nBytesRead != -1) { 
            
            try {            
                nBytesRead = audioInputStream.read(audiosBytes[index],nBytesRead , audiosBytes[index].length);
            } catch (IOException ex) {
                Logger.getLogger(PlayWave.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        index++;
    }
    
    public PlayWave() { 
        
         
    } 
 
    
    public void run() { 
        
        SourceDataLine audioSource;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format[tocar]);
        
        try { 
            audioSource = (SourceDataLine) AudioSystem.getLine(info);
            audioSource.open(format[tocar]);
        } catch (LineUnavailableException e) { 
            e.printStackTrace();
            return;
        } catch (Exception e) { 
            e.printStackTrace();
            return;
        }
 
        audioSource.start();
        audioSource.write(audiosBytes[tocar], 0,audiosBytes[tocar].length);
        audioSource.drain();
        audioSource.close();
        System.out.println("Tocar");
 
    } 
} 