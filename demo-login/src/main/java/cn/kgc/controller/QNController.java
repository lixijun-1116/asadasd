package cn.kgc.controller;

import cn.kgc.service.QNService;
import com.google.gson.Gson;
import com.qiniu.http.Response;
import com.qiniu.storage.model.DefaultPutRet;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class QNController {

    @Autowired
    private QNService qnService;
    @Value("http://q3rwly7cr.bkt.clouddn.com")
    private String path;

    @RequestMapping("/")
    public String init(){
        return "house";
    }

    @PostMapping("/shangchuan")
    public String shangchuan(@RequestParam("file")MultipartFile file, Model model)throws Exception{

        Response response = qnService.uploadFile(file.getInputStream());
        DefaultPutRet putRet=new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
        String url =path+"/"+putRet.key;
        System.out.println(url);
        model.addAttribute("url",url);
        return "aaa";
    }
}
