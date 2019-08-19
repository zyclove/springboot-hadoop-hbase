package com.example.springboothadoophbase;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.RemoteIterator;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.security.UserGroupInformation;

import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.util.LineReader;

/**
 * @author Adam
 * @Description: //TODO
 * @Title: HdfsDemo2
 * @ProjectName springboot-hadoop-hbase
 * @date 2019/8/19 2:03
 */
public class HdfsDemo2 {
    public static void main(String[] args) throws Exception {

        String krb5File = "D:\\javaProject\\springboot-hadoop-hbase\\src\\main\\resources\\kerberos\\krb5.conf";
        String user = "root/hbaseserver@GS.COM";
        String keyPath = "D:\\javaProject\\springboot-hadoop-hbase\\src\\main\\resources\\kerberos\\root.keytab";

        System.setProperty("java.security.krb5.conf", krb5File);
        Configuration conf = new Configuration();
        conf.set("dfs.namenode.kerberos.principal", user);
        conf.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        conf.set("fs.default.name", "hdfs://hbaseserver:9000");
        conf.set("fs.file.impl", LocalFileSystem.class.getName());
        conf.set("hadoop.security.authentication", "kerberos");
        UserGroupInformation.setConfiguration(conf);
        UserGroupInformation.loginUserFromKeytab(user, keyPath);

        String uri = "hdfs://hbaseserver:9000";
        String remotePath = "/";
        System.out.println("test..");
        getHdfsFileList(conf,uri, remotePath);
//        readFile(conf,uri,"/user/asmp/word.csv");
//        downloadFile(conf,uri,"/user/asmp/word.csv","D:/output/20180426.csv");
    }

    /**
     * 获取Hdfs 指定目录下所有文件
     *
     * @param uri hdfs远端连接url
     * @param remotePath hdfs远端目录路径
     * @param conf
     * @throws Exception
     */
    public static void getHdfsFileList( Configuration conf,String uri, String remotePath) throws Exception {

        FileSystem fs = FileSystem.get(new URI(uri), conf);
        RemoteIterator<LocatedFileStatus> iter = fs.listFiles(new Path(remotePath), true);
        while (iter.hasNext()) {
            LocatedFileStatus status = iter.next();
            System.out.println(status.getPath().toUri().getPath());
        }
        fs.close();
    }

    /**
     * 读取文件的内容
     * @param filePath
     */
    public static void readFile(Configuration conf , String uri ,String filePath) throws Exception{

        Path path = new Path(filePath);
        FileSystem fs = FileSystem.get(URI.create(uri), conf);

        FSDataInputStream fdis= fs.open(path);
        Text line = new Text();
        LineReader reader = new LineReader(fdis); //一行一行的读
        while(reader.readLine(line) > 0) {
            System.out.println(line);//输出
        }
    }
    /**
     * 下载 hdfs上的文件
     * @param conf Configuration对象
     * @param uri HDFS地址
     * @param remote 需要下载的文件的HDFS地址
     * @param local 下载到本地目录
     * @throws Exception 异常
     */
    public static void downloadFile(Configuration conf , String uri ,String remote, String local) throws Exception {
        System.out.println("===downloadFile===");
        FileSystem fs = FileSystem.get(new URI(uri), conf);
//        fs.copyToLocalFile(new Path(remote), new Path(local));
        fs.copyToLocalFile(false,new Path(remote), new Path(local),true);
        System.out.println("download: from" + remote + " to " + local);
        fs.close();
    }

}
