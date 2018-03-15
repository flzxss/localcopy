package tool;

import java.io.File;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;

public class Main {

    public static void main(String[] args) {
        String tomcatPath = "F:/deploy/apache-tomcat-7.0.85";
        String projectName = "hutool-wx";
        String workSpace = "C:/Users/Administrator/workspace";
        tomcatPath = StrUtil.removeSuffix(tomcatPath, "/");
        workSpace = StrUtil.removeSuffix(workSpace, "/");
        FileUtil.clean(new File(tomcatPath + "/logs"));
        FileUtil.del(tomcatPath + "/webapps/hutool-wx");
        FileUtil.del(tomcatPath + "/webapps/hutool-wx.war");
        FileUtil.clean(new File(tomcatPath + "/work"));
        if (!FileUtil.exist(tomcatPath + "/webapps/hutool-wx")) {
            System.out.println("文件夹已删除");
        }
        if (!FileUtil.exist(tomcatPath + "/webapps/hutool-wx.war")) {
            System.out.println("war已删除");
        }
        ThreadUtil.sleep(1000);
        String src = workSpace + "/" + projectName + "/target/" + projectName + ".war";
        String dest = tomcatPath + "/webapps/hutool-wx.war";
        FileUtil.copy(src, dest, true);
    }

}
