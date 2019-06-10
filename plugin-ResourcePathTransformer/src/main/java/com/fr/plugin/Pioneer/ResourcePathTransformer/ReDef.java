package com.fr.plugin.Pioneer.ResourcePathTransformer;

import com.fr.plugin.transform.FunctionRecorder;
import com.fr.stable.fun.impl.AbstractResourcePathTransformer;

@FunctionRecorder
public class ReDef extends AbstractResourcePathTransformer {

//    private final static String OldLoginPage = "/com/fr/web/controller/decision/entrance/resources/login.html";
    private final static String OldLoginPage ="/com/fr/web/controller/decision/entrance/resources/index.html";
    ///com/fr/web/controller/decision/entrance/resources/index.html
//    public String myPath = "login.html";
    public String myPath = "index.html";
    /**
     *
     * @param oldPath   需要被替换的资源路径
     * @return
     */
    @Override
    public boolean accept(String oldPath) {

//        boolean flag1 = StringUtils.equals(oldPath, OldLoginPage);
        boolean flag = OldLoginPage.equals(oldPath);
//        System.out.println("==========flag is ========:"+flag);
        return flag;
    }

    @Override
    public String transform(String oldPath) {
//        System.out.println(">>:oldPath is : "+oldPath);
        return myPath;
    }
}
