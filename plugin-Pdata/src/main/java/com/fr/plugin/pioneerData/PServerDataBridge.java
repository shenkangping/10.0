package com.fr.plugin.pioneerData;


import com.fr.base.TableData;
import com.fr.design.data.tabledata.tabledatapane.AbstractTableDataPane;
import com.fr.design.fun.impl.AbstractServerTableDataDefineProvider;
import com.fr.plugin.transform.FunctionRecorder;

@FunctionRecorder
public class PServerDataBridge extends AbstractServerTableDataDefineProvider{
    @Override
    public Class<? extends TableData> classForTableData() {
        return  Pdata.class;
    }

    @Override
    public Class<? extends TableData> classForInitTableData() {
        return  Pdata.class;
    }

    @Override
    public Class<? extends AbstractTableDataPane> appearanceForTableData() {
        return PdataPane.class;
    }

    @Override
    public String nameForTableData() {
        return "PdataDemo";
    }

    @Override
    public String prefixForTableData() {
        return "PD";
    }

    @Override
    public String iconPathForTableData() {

        return "/com/fr/design/images/m_file/preview.png";
    }
}
