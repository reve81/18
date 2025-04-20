package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AiFrame extends JFrame implements ActionListener{

	/*默认用户名:tom 密码:t123 */
	public AiFrame(){
		// 创建一个新的JFrame实例
       this.setTitle("ai对话");

		// 设置默认关闭操作
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// 设置框架的大小
		this.setSize(500, 400);

		// 设置布局管理器
		this.setLayout(new BorderLayout());

		// 创建顶部面板，用于输入问题和按钮
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());

		JTextField questionField = new JTextField();
		JButton submitButton = new JButton("提交");

		// 将文本框和按钮添加到顶部面板
		topPanel.add(questionField, BorderLayout.CENTER);
		topPanel.add(submitButton, BorderLayout.EAST);

		// 将顶部面板添加到框架中
		this.add(topPanel, BorderLayout.NORTH);

		// 创建一个标签
		JLabel responseLabel = new JLabel("回答：");

		// 将标签添加到框架中
		this.add(responseLabel, BorderLayout.WEST);

		// 创建一个JTextArea用于显示回答
		JTextArea responseArea = new JTextArea();
		responseArea.setEditable(false); // 设置为不可编辑
		responseArea.setLineWrap(true);
		responseArea.setWrapStyleWord(true);
		// 将JTextArea放入JScrollPane中，以便在文本超出可视区域时可以滚动
		JScrollPane scrollPane = new JScrollPane(responseArea);

		// 将JScrollPane添加到框架中
		this.add(scrollPane, BorderLayout.CENTER);

		// 添加按钮的点击事件监听器
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 获取用户输入的问题
				String question = questionField.getText();
				AiController aiController = new AiController();
				// 这里可以添加与AI对话的逻辑，这里仅作为示例
				String aiAnswer = null;
				try {
					aiAnswer = aiController.getAiAnswer(question);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				String response =aiAnswer;
				// 这里可以添加与AI对话的逻辑，这里仅作为示例


				// 在JTextArea中显示回答
				responseArea.setText(response);

				// 清空输入框
				questionField.setText("");
			}
		});

		// 获取屏幕的尺寸
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// 计算窗口在屏幕中央的位置
		int x = (screenSize.width - this.getWidth()) / 2;
		int y = (screenSize.height - this.getHeight()) / 2;

		// 设置窗口的位置
		this.setLocation(x, y);

		// 设置框架可见
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){

	}
}
