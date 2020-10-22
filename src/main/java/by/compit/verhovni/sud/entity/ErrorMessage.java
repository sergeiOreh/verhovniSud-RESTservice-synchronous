package by.compit.verhovni.sud.entity;

import java.util.Objects;

/**
 * Класс ErrorMessage предназначен для удобного отоброжения возможных ошибок.
 */
public class ErrorMessage {

    private int errorcode;
    private String message;

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorMessage that = (ErrorMessage) o;
        return errorcode == that.errorcode &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorcode, message);
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "errorcode=" + errorcode +
                ", message='" + message + '\'' +
                '}';
    }
}
