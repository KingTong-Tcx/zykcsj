package com.position.reptile;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HttpClientHdfsUtils {
    public static void createFileBySysTime(String url,String fileName,String data) {
        //指定操作hdfs的用户
        System.setProperty("HADOOP_USER_NAME","root");
        Path path = null;
        //读取系统时间
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        //格式化系统时间为年月日的形式
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        //获取系统当前时间并将其转换为string类型,fileName即存储数据的文件夹名称
        String filePath = format.format(time);
        //构造Configuration对象，配置Hadoop参数
        Configuration conf = new Configuration();
        //实例化URI引入uri
        URI uri = URI.create(url);
        //实例化FileSystem对象，处理文件和目录相关的事务
        FileSystem fileSystem;
        try {
            //获取文件系统对象
            fileSystem = FileSystem.get(uri, conf);
            //定义文件路径
            path = new Path("/data/JobData/"+filePath);
            //判断路径是否为空
            if (!fileSystem.exists(path)) {
                //创建目录
                fileSystem.mkdirs(path);
            }
            //在指定目录下创建文件
            FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path(path +"/"+fileName));
            //向文件中写入数据
            IOUtils.copyBytes(new ByteArrayInputStream(data.getBytes()),
                    fsDataOutputStream, conf, true);
            //关闭连接释放资源
            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
