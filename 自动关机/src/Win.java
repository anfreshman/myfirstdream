import javax.swing.*;
import java.awt.*;

/**
 * @author: 303014439
 * @date: 2021/2/16 14:14
 * @description:
 */
public class Win {
    JFrame frame = new JFrame();
    JTextField textField = new JTextField("请输入关机时间",20);
    public void getWin(String name){
        EventQueue.invokeLater(() ->{
            frame.setName(name);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(600, 300, 300, 200);//设置显示位置以及长宽高
            frame.setVisible(true);
            frame.add(textField);
            frame.pack();
        });
    }
    public String getNumber(){
        return textField.getText().trim();
    }
}
