package Program.Tools;

import javax.sound.sampled.*;

import java.io.IOException;
import java.net.URL;

public class Music {
    public Clip StartMusic(String url) {
        Clip clip = null;
        try {
            URL urlMusic = this.getClass().getResource(url);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(urlMusic);
            // Get a sound clip resource.
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        return clip;
    }
}
