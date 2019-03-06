package net.wanho.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    @RequestMapping("/testFileUpload")
    public String testFileUpload(HttpServletRequest request, @RequestParam("desc") String desc,
                                 @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("desc: " + desc);
        System.out.println("OriginalFilename: " + file.getOriginalFilename());
        System.out.println("InputStream: " + file.getInputStream());
        String filePath = request.getSession().getServletContext()
                .getRealPath("/") + file.getOriginalFilename();
        file.transferTo(new File(filePath));
        return "success";
    }

    @RequestMapping(value = "/DownloadFile")
    public ResponseEntity<byte[]> DownloadFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //  接受的是UTF-8
        req.setCharacterEncoding("utf-8");
        //获取项目根目录
        String path = "C:\\Users\\Administrator\\Desktop\\118.24.163.254.txt";
        //获取文件名
        String filename = "1.txt";
        File file = null;
        HttpHeaders headers = null;

        try {

            System.out.println(filename);//myfiles

            file = new File(path);

            //请求头

            headers = new HttpHeaders();

            String fileName1 = new String(filename.getBytes("UTF-8"), "iso-8859-1");//解决文件名乱码

            //通知浏览器以attachment（下载方式）打开图片
            headers.setContentDispositionFormData("attachment", fileName1);

            //application/octet-stream二进制流数据（最常见的文件下载）。
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }
}
