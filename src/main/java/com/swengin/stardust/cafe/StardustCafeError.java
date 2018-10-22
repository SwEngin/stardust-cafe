package com.swengin.stardust.cafe;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Objects;

public class StardustCafeError {

    private int status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;

    private StardustCafeError() {
        timestamp = LocalDateTime.now();
    }

    StardustCafeError(int status) {
        this();
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
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
        StardustCafeError that = (StardustCafeError) o;
        return status == that.status
                && Objects.equals(timestamp, that.timestamp)
                && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, timestamp, message);
    }

    @Override
    public String toString() {
        return "StardustCafeError{"
                + "status=" + status
                + ", timestamp=" + timestamp
                + ", message='" + message + '\''
                + '}';
    }
}
