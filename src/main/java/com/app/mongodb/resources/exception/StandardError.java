package com.app.mongodb.resources.exception;

import java.io.Serializable;

/*Para personalizar a exceção no padrão:
    {
    "timestamp": "2019-02-01T13:16:07.166+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Objeto não encontrado",
    "path": "/users/5c544428150735182c5fca8a"
}
 */
public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError() {

    }

    public StandardError(Long timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
