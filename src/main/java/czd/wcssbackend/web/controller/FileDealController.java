package czd.wcssbackend.web.controller;

import czd.wcssbackend.web.controller.pojo.MessageBox;
import czd.wcssbackend.web.controller.pojo.UpLoadConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.*;

/**
 * @ClassName FileDealController
 * @Description Upload and Download Controller
 * 格式规范:例如:1/czd.jpg
 *          filePath:1/
 *          fileName:czd
 *          fileType:jpg
 * @Author dprCZD
 * @Date 2019/6/10 19:23
 */

@Api(value = "FileDealController", description = "文件上传下载服务")
@RestController
@RequestMapping("/api/v1")
public class FileDealController {

    @Value("${resources.baseDir}")
    String baseFilePath;

    private static final Logger logger = LoggerFactory.getLogger(FileDealController.class);


    @ApiOperation(value = "上传文件", notes = "上传文件", produces = "application/json")
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST,produces = "application/json")
    public MessageBox uploadFile(@RequestParam("file") MultipartFile file, String filePath,String fileName,String fileType) {

        String localFilePath=baseFilePath+filePath+"/";
        String localFileName=fileName+"."+fileType;

        File dir=new File(localFilePath);
        if(!dir.exists())
            dir.mkdirs();
        File targetFile=new File(localFilePath+localFileName);
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            logger.error("create targetfile error:"+e.getMessage());
        }
        MessageBox message=new MessageBox();
        if(targetFile.exists())
        {
            logger.info("upload file ["+localFileName+"] success");
            message.setStatus(MessageBox.FILE_UPLOAD_SUCCESS_CODE);
            message.setMessage(localFileName);
            return message;

        }
        logger.error("upload file failure:"+localFileName);
        message.setStatus(MessageBox.FILE_UPLOAD_FAILURE_CODE);
        message.setMessage("upload file failure:"+localFileName);
        return message;
    }

    @ApiOperation(value = "下载文件", notes = "下载文件", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @RequestMapping(value = "/downloadFile", method = RequestMethod.GET,produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> downloadFile(String filePath, String fileName,String fileType) {
        File file = new File(baseFilePath + filePath + fileName+"."+fileType);
        if (file.exists()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", fileName+"."+fileType);
            try {
                byte fileData[] = FileUtils.readFileToByteArray(file);
                logger.info("download file ["+fileName+"."+fileType+"] success");
                return new ResponseEntity<>(fileData,
                        headers, HttpStatus.CREATED);
            } catch (IOException e) {
                logger.error(e.getMessage());
                return  new ResponseEntity<>(null,null,HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
        logger.error("download file failure:"+fileName+"."+fileType);
        return  new ResponseEntity<>(null,null,HttpStatus.BAD_REQUEST);

    }

}
