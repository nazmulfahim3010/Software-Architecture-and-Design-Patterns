
public class Dependency_Inversion_Principle {
    interface INotification {
        void notifyUser();
    }

    public class NotificationManager {
        private INotification notification;

        NotificationManager(INotification notification) {
            this.notification = notification;
        }

        public void notifyUser() {
            notification.notifyUser();
        }
    }

    class EmailService implements INotification {
        @Override
        public void notifyUser() {
            System.out.println("User email sent");
        }
    }

    public static void main(String[] args) {
        Dependency_Inversion_Principle t = new Dependency_Inversion_Principle();

        EmailService email = t.new EmailService();

        email.notifyUser();
    }

}
