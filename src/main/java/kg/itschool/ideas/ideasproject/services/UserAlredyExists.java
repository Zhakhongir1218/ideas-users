package kg.itschool.ideas.ideasproject.services;

public class UserAlredyExists extends Exception{
    public UserAlredyExists() {
    }

    public UserAlredyExists(String message) {
        super(message);
    }

    public UserAlredyExists(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlredyExists(Throwable cause) {
        super(cause);
    }
}
