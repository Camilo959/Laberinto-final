package model;

import javax.sound.sampled.*;
import java.io.*;

public class Music {

    public void AudioIniciar() {
        try {
            // Carga el archivo de audio
            File audioFile = new File("src/audio.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
    
            // Obtiene un Clip para reproducir el audio
            Clip audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
    
            // Reproduce el audio
            audioClip.start();

    
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

}
