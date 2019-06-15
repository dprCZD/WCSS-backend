package czd.wcssbackend.web.controller.pojo;

/**
 * @ClassName UpLoadConfig
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/10 22:38
 */
public class UpLoadConfig {

    private String fileName;

    private Integer userId;

    private String fileType;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
