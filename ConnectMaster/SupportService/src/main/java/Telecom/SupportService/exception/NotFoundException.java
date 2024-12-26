package Telecom.SupportService.exception;

public class NotFoundException extends Exception{
    private String message;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
