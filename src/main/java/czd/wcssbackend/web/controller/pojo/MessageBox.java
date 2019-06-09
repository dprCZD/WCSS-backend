package czd.wcssbackend.web.controller.pojo;

public class MessageBox {
    //LOGIN
    final static public int LOGIN_SUCCESS_CODE=1000;
    final static public int LOGIN_FAILURE_CODE=1001;
    final static public int LOGOUT_SUCCESS_CODE=1002;
    final static public int LOGOUT_ERROR_CODE=1003;
    final static public int NOT_LOGIN_CODE=1005;
    //REGISTER
    final static public int REGISTER_SUCCESS_CODE=2000;
    final static public int REGISTER_FAILURE_CODE=2001;


    private int status;

    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
