package com.fr.plugin.PioneerJscssinput;

import com.fr.web.struct.Component;
import com.fr.web.struct.Filter;
import com.fr.web.struct.browser.RequestClient;
import com.fr.web.struct.category.ScriptPath;
import com.fr.web.struct.category.StylePath;

public class PFileDef extends Component {

    public static final PFileDef KEY = new PFileDef();


    public PFileDef() {
    }

    /***
     * 返回要引入的js脚本路径
     * @param requestClient  请求客户端描述
     * @return js脚本路径
     */

    @Override
    public ScriptPath script(RequestClient requestClient) {
        return ScriptPath.build("demo.js");
    }

    /**
     * 返回要引入的css样式路径
     * @param requestClient   请求客户端描述
     * @return   css脚本路径
     */

    @Override
    public StylePath style(RequestClient requestClient) {
        return StylePath.build("demo.css");
    }

    /**
     * 通过给定的资源过滤器控制是否加载该资源
     * @return filter
     */
    @Override
    public Filter filter() {
        //true  任何情况下载平台组件加载时加载该组件
        return new Filter() {
            @Override
            public boolean accept() {
                return true;
            }
        };
    }
}
