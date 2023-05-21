package Vue;

import javax.sound.sampled.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Classe pour jouer des effets sonores dans le jeu.
 */
public class SoundEffect {
    private Clip clip;


    /**
     * Constructeur pour SoundEffect.
     *
     * @param audioFilePath Le chemin d'accès au fichier audio de l'effet sonore.
     */
    public SoundEffect(URL audioFilePath) {
        try {
            File audioFile = new File(audioFilePath.toURI());
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Joue l'effet sonore.
     */
    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }
}
