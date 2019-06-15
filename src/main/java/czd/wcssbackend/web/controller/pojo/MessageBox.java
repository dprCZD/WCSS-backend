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
    //FileOperation
    final static public int FILE_UPLOAD_SUCCESS_CODE=3000;
    final static public int FILE_UPLOAD_FAILURE_CODE=3001;
    final static public int FILE_DOWNLOAD_SUCCESS_CODE=3000;
    final static public int FILE_DOWNLOAD_FAILURE_CODE=3001;
    //user
    final static public int UPDATE_USER_SUCCESS_CODE=4000;
    final static public int UPDATE_USER_FAILURE_CODE=4001;
    final static public int DELETE_USER_SUCCESS_CODE=4002;
    final static public int DELETE_USER_FAILURE_CODE=4003;
    //parent
    final static public int UPDATE_PARENT_SUCCESS_CODE=5000;
    final static public int UPDATE_PARENT_FAILURE_CODE=5001;
    final static public int DELETE_PARENT_SUCCESS_CODE=5002;
    final static public int DELETE_PARENT_FAILURE_CODE=5003;
    final static public int INSERT_PARENT_SUCCESS_CODE=5004;
    final static public int INSERT_PARENT_FAILURE_CODE=5005;

    //student
    final static public int UPDATE_STUDENT_SUCCESS_CODE=6000;
    final static public int UPDATE_STUDENT_FAILURE_CODE=6001;
    final static public int DELETE_STUDENT_SUCCESS_CODE=6002;
    final static public int DELETE_STUDENT_FAILURE_CODE=6003;
    final static public int INSERT_STUDENT_SUCCESS_CODE=6004;
    final static public int INSERT_STUDENT_FAILURE_CODE=6005;

    //teacher
    final static public int UPDATE_TEACHER_SUCCESS_CODE=7000;
    final static public int UPDATE_TEACHER_FAILURE_CODE=7001;
    final static public int DELETE_TEACHER_SUCCESS_CODE=7002;
    final static public int DELETE_TEACHER_FAILURE_CODE=7003;
    final static public int INSERT_TEACHER_SUCCESS_CODE=7004;
    final static public int INSERT_TEACHER_FAILURE_CODE=7005;

    //eduins
    final static public int UPDATE_EDUINS_SUCCESS_CODE=8000;
    final static public int UPDATE_EDUINS_FAILURE_CODE=8001;
    final static public int DELETE_EDUINS_SUCCESS_CODE=8002;
    final static public int DELETE_EDUINS_FAILURE_CODE=8003;
    final static public int INSERT_EDUINS_SUCCESS_CODE=8004;
    final static public int INSERT_EDUINS_FAILURE_CODE=8005;


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
