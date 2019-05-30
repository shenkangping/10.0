package com.fr.plugin.PioneerJscssinput;

import com.fr.decision.fun.impl.AbstractWebResourceProvider;
import com.fr.decision.web.MainComponent;
import com.fr.plugin.transform.FunctionRecorder;
import com.fr.web.struct.Atom;

@FunctionRecorder
public class PJscssBridger  extends AbstractWebResourceProvider{
    @Override
    public Atom attach() {
        // 加载平台组件加载时加载自定义的组件
        return MainComponent.KEY;
    }

    @Override
    public Atom client() {
//        返回我要引入的组件
        return PFileDef.KEY;
    }
}
