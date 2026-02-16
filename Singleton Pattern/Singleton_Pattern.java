public class Singleton_Pattern {

    public static void main(String[] args) {
        singleObject Object = singleObject.getInstance();
        Object.userCountView();

        User1 u1 = new User1();
        u1.msg();
        Object.userCountView();

        User2 u2 = new User2();
        u2.msg();
        Object.userCountView();

    }

}

class singleObject {
    private static singleObject Object = new singleObject();
    private int count = 0;

    private singleObject() {
    }

    public static singleObject getInstance() {
        return Object;
    }

    public void userCount() {
        count++;
    }

    public void userCountView() {
        System.out.println("user count :" + count);
    }

}

interface UserMessage {
    void msg();
}

class User1 implements UserMessage {
    singleObject Object = singleObject.getInstance();

    public User1() {
        Object.userCount();
    }

    @Override
    public void msg() {
        System.out.println("this is user 1");
    }

}

class User2 implements UserMessage {
    singleObject Object = singleObject.getInstance();

    public User2() {
        Object.userCount();
    }

    @Override
    public void msg() {
        System.out.println("this is user 2");
    }

}
