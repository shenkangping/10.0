package com.fr.plugin.pioneerData;

import com.fr.config.Identifier;
import com.fr.config.holder.Conf;
import com.fr.config.holder.factory.Holders;
import com.fr.data.AbstractParameterTableData;
import com.fr.general.data.DataModel;
import com.fr.script.Calculator;
import com.fr.stable.ParameterProvider;
import com.fr.stable.StringUtils;
import com.fr.stable.xml.XMLPrintWriter;
import com.fr.stable.xml.XMLableReader;

public class Pdata extends AbstractParameterTableData {

    public final static String TAG = "others";

    @Override
    public DataModel createDataModel(Calculator calculator) {

        //先获取参数面板上的全部参数
        ParameterProvider[] parameters = this.getParameters(calculator);
        //有些时候参数需要我们自己重新计算一次，否则获取到的就是默认值
        parameters = Calculator.processParameters(calculator,parameters);

        return PdataModel.createPdataModel(parameters,this.getOthers());

    }

    //假设我们除了参数之外，还有一些需要指定的配置项
    @Identifier(TAG)
    private Conf<String> others = Holders.simple(StringUtils.EMPTY);

    //作为服务器数据集需要对数据库进行读写
    public String getOthers(){
        return others.get();
    }

    public void setOthers( String others ){
        this.others.set(others);
    }

    //作为模板数据集需要对XML进行读写
    @Override
    public void readXML(XMLableReader reader) {
        super.readXML(reader);
        if (reader.isChildNode()) {
            if ("Attributes".equals(reader.getTagName())) {
                setOthers(reader.getAttrAsString(TAG,StringUtils.EMPTY));
            }
        }
    }

    @Override
    public void writeXML(XMLPrintWriter writer) {
        super.writeXML(writer);
        writer.startTAG("Attributes").attr(TAG,getOthers()).end();
    }

}


