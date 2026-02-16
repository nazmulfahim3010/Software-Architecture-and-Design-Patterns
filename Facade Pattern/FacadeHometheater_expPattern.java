interface Status {
    void on();
}

class DVDPlayer implements Status {
    @Override
    public void on() {
        System.out.println("DVD Player ON");
    }
}

class Projector implements Status {
    @Override
    public void on() {
        System.out.println("Projector ON");
    }
}

class SoundSystem implements Status {
    @Override
    public void on() {
        System.out.println("Sound System ON");
    }
}

class HomeTheaterFacade {

    private Status dvd, projector, sound;

    HomeTheaterFacade() {
        dvd = new DVDPlayer();
        projector = new Projector();
        sound = new SoundSystem();
    }

    void watchMovie() {
        dvd.on();
        projector.on();
        sound.on();
        System.out.println("Movie Started");
    }
}

public class FacadeHometheater_expPattern {
    public static void main(String[] args) {
        HomeTheaterFacade home = new HomeTheaterFacade();
        home.watchMovie();
    }
}
