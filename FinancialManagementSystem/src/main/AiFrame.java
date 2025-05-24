package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AiFrame extends JFrame implements ActionListener{

	/*Ĭ���û���:tom ����:t123 */
	public AiFrame(){
		// ����һ���µ�JFrameʵ��
       this.setTitle("ai�Ի�");

		// ����Ĭ�Ϲرղ���
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// ���ÿ�ܵĴ�С
		this.setSize(500, 400);

		// ���ò��ֹ�����
		this.setLayout(new BorderLayout());

		// ����������壬������������Ͱ�ť
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());

		JTextField questionField = new JTextField();
		JButton submitButton = new JButton("�ύ");

		// ���ı���Ͱ�ť��ӵ��������
		topPanel.add(questionField, BorderLayout.CENTER);
		topPanel.add(submitButton, BorderLayout.EAST);

		// �����������ӵ������
		this.add(topPanel, BorderLayout.NORTH);

		// ����һ����ǩ
		JLabel responseLabel = new JLabel("�ش�");

		// ����ǩ��ӵ������
		this.add(responseLabel, BorderLayout.WEST);

		// ����һ��JTextArea������ʾ�ش�
		JTextArea responseArea = new JTextArea();
		responseArea.setEditable(false); // ����Ϊ���ɱ༭
		responseArea.setLineWrap(true);
		responseArea.setWrapStyleWord(true);
		// ��JTextArea����JScrollPane�У��Ա����ı�������������ʱ���Թ���
		JScrollPane scrollPane = new JScrollPane(responseArea);

		// ��JScrollPane��ӵ������
		this.add(scrollPane, BorderLayout.CENTER);

		// ��Ӱ�ť�ĵ���¼�������
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ��ȡ�û����������
				String question = questionField.getText();
				AiController aiController = new AiController();
				// ������������AI�Ի����߼����������Ϊʾ��
				String aiAnswer = null;
				try {
					aiAnswer = aiController.getAiAnswer(question);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				String response =aiAnswer;
				// ������������AI�Ի����߼����������Ϊʾ��


				// ��JTextArea����ʾ�ش�
				responseArea.setText(response);

				// ��������
				questionField.setText("");
			}
		});

		// ��ȡ��Ļ�ĳߴ�
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// ���㴰������Ļ�����λ��
		int x = (screenSize.width - this.getWidth()) / 2;
		int y = (screenSize.height - this.getHeight()) / 2;

		// ���ô��ڵ�λ��
		this.setLocation(x, y);

		// ���ÿ�ܿɼ�
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){

	}
}
