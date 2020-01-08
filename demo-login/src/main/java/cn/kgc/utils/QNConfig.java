package cn.kgc.utils;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QNConfig {

    @Bean
    public com.qiniu.storage.Configuration qiniuConfig(){
        //配置所在区域
        return new com.qiniu.storage.Configuration(Zone.zone0());
    }

    @Bean
    public UploadManager uploadManager(){
        return new UploadManager(qiniuConfig());
    }
    //密钥
    @Value("uNCk51IA6j2niGNv2YqEwYBgayJR7bGo_8BMRBHG")
    private String accessKey;

    @Value("an60z6uoCNBDDc6dz_BPQBjCY8acrPJfPsHYfv8m")
    private String secretKey;

    //返回认证对象（获取授权）
    @Bean
    public Auth auth(){
        return Auth.create(accessKey,secretKey);
    }

    @Bean
    public BucketManager bucketManager(){
        return new BucketManager(auth(),qiniuConfig());
    }

    @Bean
    public Gson gson(){
        return new Gson();
    }

}
