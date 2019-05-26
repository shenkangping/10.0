package com.fr.plugin.pioneerData;

import com.fr.base.BaseUtils;
import com.fr.base.Parameter;
import com.fr.design.data.datapane.preview.PreviewTablePane;
import com.fr.design.data.tabledata.tabledatapane.AbstractTableDataPane;
import com.fr.design.gui.ibutton.UIButton;
import com.fr.design.gui.itableeditorpane.ParameterTableModel;
import com.fr.design.gui.itableeditorpane.UITableEditorPane;
import com.fr.design.gui.itableeditorpane.UITableModelAdapter;
import com.fr.design.gui.itextfield.UITextField;
import com.fr.design.layout.TableLayout;
import com.fr.design.layout.TableLayoutHelper;
import com.fr.script.Calculator;
import com.fr.stable.ParameterProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PdataPane extends AbstractTableDataPane<Pdata> {


    private final static double P = TableLayout.PREFERRED;
    private final static double F = TableLayout.FILL;

    private UITableEditorPane<ParameterProvider> parameterTableEditorPane;
    private UITextField tEditor;

    public PdataPane() {
        init();
    }




    private void init(){
        //创建参数面板
        UITableModelAdapter<ParameterProvider> model = new ParameterTableModel();
        parameterTableEditorPane = new UITableEditorPane<ParameterProvider>(model);
        //创建Others的配置控件
        tEditor = new UITextField();
        //创建预览按钮
        UIButton preview = new UIButton(BaseUtils.readIcon("/com/fr/design/images/m_file/preview.png"));
        preview.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        PreviewTablePane.previewTableData(PdataPane.this.updateBean());
                    }
                });
            }
        });
        JPanel one = TableLayoutHelper.createTableLayoutPane(
                new Component[][] {{
                        tEditor,preview
                }},
                new double[] { P },
                new double[] { F,P  }
        );
        //创建2行1列
        TableLayoutHelper.createTableLayoutPane(
                new Component[][] {{
                        one
                },{
                        parameterTableEditorPane
                }},
                new double[] { P,F },
                new double[] { F }
        );
    }


    @Override
    //数据集的配置展现到界面上
    public void populateBean(Pdata pdata) {

        if( null == pdata ){
            return;
        }
        String others = pdata.getOthers();
        ParameterProvider[] parameters = pdata.getParameters( Calculator.createCalculator() );
        tEditor.setText( others );
        parameterTableEditorPane.populate( parameters );
    }

    //将界面的配置保存到数据集中
    @Override
    public Pdata updateBean() {
        Pdata ob = new Pdata();
        ob.setOthers(tEditor.getText());
        java.util.List<ParameterProvider> parameterProviderList = parameterTableEditorPane.update();
        Parameter[] parameters = parameterProviderList.toArray(new Parameter[parameterProviderList.size()]);
        ob.setParameters(parameters);
        return ob;
    }

    //对此面板命名
    @Override
    protected String title4PopupWindow() {
        return "PdataDemo";
    }
}
