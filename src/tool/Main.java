package tool;

import java.io.File;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.thread.ThreadUtil;

public class Main {

    public static void main(String[] args) {
        FileUtil.clean(new File("F:/deploy/apache-tomcat-7.0.85/logs"));
        FileUtil.del("F:/deploy/apache-tomcat-7.0.85/webapps/hutool-wx");
        FileUtil.del("F:/deploy/apache-tomcat-7.0.85/webapps/hutool-wx.war");
        FileUtil.clean(new File("F:/deploy/apache-tomcat-7.0.85/work"));
        if(!FileUtil.exist("F:/deploy/apache-tomcat-7.0.85/webapps/hutool-wx")){
            System.out.println("文件夹已删除");
        }
        if(!FileUtil.exist("F:/deploy/apache-tomcat-7.0.85/webapps/hutool-wx.war")){
            System.out.println("war已删除");
        }
        ThreadUtil.sleep(1000);
        String src="C:/Users/Administrator/workspace/hutool-wx/target/hutool-wx.war";
        String dest="F:/deploy/apache-tomcat-7.0.85/webapps/hutool-wx.war";
        FileUtil.copy(src, dest, true);
    }

}
