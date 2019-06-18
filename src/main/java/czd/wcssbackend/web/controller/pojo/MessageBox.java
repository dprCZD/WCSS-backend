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

    //course
    final static public int UPDATE_COURSE_SUCCESS_CODE=9000;
    final static public int UPDATE_COURSE_FAILURE_CODE=9001;
    final static public int DELETE_COURSE_SUCCESS_CODE=9002;
    final static public int DELETE_COURSE_FAILURE_CODE=9003;
    final static public int INSERT_COURSE_SUCCESS_CODE=9004;
    final static public int INSERT_COURSE_FAILURE_CODE=9005;

    //courseinfo
    final static public int UPDATE_CLASS_SUCCESS_CODE=10000;
    final static public int UPDATE_CLASS_FAILURE_CODE=10001;
    final static public int DELETE_CLASS_SUCCESS_CODE=10002;
    final static public int DELETE_CLASS_FAILURE_CODE=10003;
    final static public int INSERT_CLASS_SUCCESS_CODE=10004;
    final static public int INSERT_CLASS_FAILURE_CODE=10005;

    //paidcourse
    final static public int UPDATE_PAID_SUCCESS_CODE=10000;
    final static public int UPDATE_PAID_FAILURE_CODE=10001;
    final static public int DELETE_PAID_SUCCESS_CODE=10002;
    final static public int DELETE_PAID_FAILURE_CODE=10003;
    final static public int INSERT_PAID_SUCCESS_CODE=10004;
    final static public int INSERT_PAID_FAILURE_CODE=10005;

    //trialcourse
    final static public int UPDATE_TRIAL_SUCCESS_CODE=11000;
    final static public int UPDATE_TRIAL_FAILURE_CODE=11001;
    final static public int DELETE_TRIAL_SUCCESS_CODE=11002;
    final static public int DELETE_TRIAL_FAILURE_CODE=11003;
    final static public int INSERT_TRIAL_SUCCESS_CODE=11004;
    final static public int INSERT_TRIAL_FAILURE_CODE=11005;

    //SHOPINGLIST
    final static public int UPDATE_SHOP_SUCCESS_CODE=12000;
    final static public int UPDATE_SHOP_FAILURE_CODE=12001;
    final static public int DELETE_SHOP_SUCCESS_CODE=12002;
    final static public int DELETE_SHOP_FAILURE_CODE=12003;
    final static public int INSERT_SHOP_SUCCESS_CODE=12004;
    final static public int INSERT_SHOP_FAILURE_CODE=12005;

    //TrialReview
    final static public int UPDATE_REVIEW_SUCCESS_CODE=12000;
    final static public int UPDATE_REVIEW_FAILURE_CODE=12001;
    final static public int DELETE_REVIEW_SUCCESS_CODE=12002;
    final static public int DELETE_REVIEW_FAILURE_CODE=12003;
    final static public int INSERT_REVIEW_SUCCESS_CODE=12004;
    final static public int INSERT_REVIEW_FAILURE_CODE=12005;

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
