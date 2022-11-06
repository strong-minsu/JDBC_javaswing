package insert;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class insert_menu extends JFrame {
    public insert_menu(){
        setTitle("내역 입력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JPanel jPanel = new JPanel();
        JButton btn_income = new JButton("수입 입력");
        JButton btn_expense = new JButton("지출 입력");
        JButton btn_main = new JButton("메인 화면");

        btn_income.addActionListener(new MyActionListener());
        btn_expense.addActionListener(new MyActionListener());
        btn_main.addActionListener(new MyActionListener());

        jPanel.add(btn_income);
        jPanel.add(btn_expense);
        jPanel.add(btn_main);

        c.add(jPanel);
        setSize(300, 350);


        Dimension frameSize = getSize();

        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((windowSize.width - frameSize.width) / 2,
                (windowSize.height - frameSize.height) / 2); //화면 중앙에 띄우기
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
    }

    private class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            if (b.getText().equals("수입 입력")){
                new income();
                setVisible(false);
            }
            else if(b.getText().equals("지출 입력")) {
                new expense();
                setVisible(false);
            }
            else{
                // 메인 화면으로 돌아가기
            }
        }
    }

    public static void main(String[] agrs){
        new insert_menu();
    }
}
