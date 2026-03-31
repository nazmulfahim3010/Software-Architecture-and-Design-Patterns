
import java.util.ArrayList;
import java.util.List;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        facebookUser alice = new facebookUser("alice");
        facebookUser bob = new facebookUser("bob");

        facebookFollower follower1 = new facebookFollower("follower 1");
        facebookFollower follower2 = new facebookFollower("follower 2");

        alice.registerObserver(follower1);
        bob.registerObserver(follower2);
        alice.registerObserver(follower2);

        alice.PostUpdate("hello , everyone this is my first post.");
        bob.PostUpdate("Feeling excited about the weekend!");

        alice.removeObserver(follower1);
        alice.PostUpdate("A beautiful sunset today!");
    }

}

interface subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver(String post);
}

class facebookUser implements subject {
    private String username;
    private List<Observer> followers;
    private String latestPost;

    public facebookUser(String username) {
        this.username = username;
        this.followers = new ArrayList<>();
    }

    public void PostUpdate(String post) {
        this.latestPost = post;
        notifyObserver(post);
    }

    @Override
    public void registerObserver(Observer observer) {
        followers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        followers.remove(observer);
    }

    @Override
    public void notifyObserver(String post) {
        for (Observer follower : followers) {
            follower.update(username, post);
        }

    }

}

interface Observer {
    void update(String username, String post);
}

class facebookFollower implements Observer {
    private String followerName;

    public facebookFollower(String follower) {
        this.followerName = follower;
    }

    @Override
    public void update(String username, String post) {
        System.out.println(followerName + " recieved an update from " + username + ":");
        System.out.println(post);
        System.out.println();

    }
}
