package com.fr.plugin.pioneerData;

import com.fr.data.AbstractDataModel;
import com.fr.general.data.TableDataException;
import com.fr.stable.ParameterProvider;
import com.fr.stable.StringUtils;

public class PdataModel extends AbstractDataModel {


    public final static PdataModel EMPTY = new PdataModel();

    private ParameterProvider[] parameters = new ParameterProvider[0];

    private final static String[] COL_NAME = new String[]{"col1","col2","others"};

    private String others = StringUtils.EMPTY;


    public PdataModel() {

    }

    public static PdataModel createPdataModel(ParameterProvider[] parameters , String others) {
        PdataModel result = new PdataModel();
        result.parameters=null==parameters?new ParameterProvider[0]:parameters;
        result.others=null==others?StringUtils.EMPTY:others;
        return result;
    };

    @Override
    public int getColumnCount() throws TableDataException {
        return COL_NAME.length;
    }

    @Override
    public String getColumnName(int colIndex) throws TableDataException {
        return COL_NAME[colIndex];
    }

    @Override
    public int getRowCount() throws TableDataException {
        return parameters.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) throws TableDataException {

        if( 2 == colIndex ){
            return others;
        }
        ParameterProvider p = parameters[rowIndex];
        return 0==colIndex ? p.getName() : p.getValue() ;
    }
}
