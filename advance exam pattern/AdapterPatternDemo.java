// Client Class
public class AdapterPatternDemo {
    public static void main(String[] args) {

        MediaPlayer player = new AudioPlayer();

        player.play("mp3", "song.mp3");
        player.play("mp4", "video.mp4");
        player.play("vlc", "movie.vlc");
        player.play("avi", "film.avi"); // unsupported
    }
}

// Target Interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Adaptee Interface (Advanced Player)
interface AdvancedMediaPlayer {
    void playVlc(String fileName);

    void playMp4(String fileName);
}

// Concrete Adaptee: VLC Player
class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // Do nothing
    }
}

// Concrete Adaptee: MP4 Player
class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        // Do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}

// Adapter Class
class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer.playMp4(fileName);
        }
    }
}

// Concrete Class (Client uses this)
class AudioPlayer implements MediaPlayer {

    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {

        // Native support
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        }
        // Use adapter for other formats
        else if (audioType.equalsIgnoreCase("vlc") ||
                audioType.equalsIgnoreCase("mp4")) {

            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        // Unsupported
        else {
            System.out.println("Invalid media format: " + audioType);
        }
    }
}