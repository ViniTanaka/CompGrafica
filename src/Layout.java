import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Layout extends JFrame{
	private JTextField tx1, ty1,tx2,ty2, raio;
	private JButton bReta, bCirculo;
	private JLabel lx1,ly1, lx2, ly2, lraio;
	private FlowLayout layout;
	private Container container;
	private JFrame f;
	private JPanel panel;
	
	public Layout() {
		layout = new FlowLayout();
		container = getContentPane();
		f = new JFrame();
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(500,200));
		panel.setBackground(Color.white);
		
		f.setLayout(layout);
		
		lx1 = new JLabel("Valor de x1 ");
		ly1 = new JLabel("Valor de y1 ");
		lx2 = new JLabel("Valor de x2 ");
		ly2 = new JLabel("Valor de y2 ");
		lraio = new JLabel("Valor do raio ");
		tx1 = new JTextField(5);
		ty1 = new JTextField(5);
		tx2 = new JTextField(5);
		ty2 = new JTextField(5);
		raio = new JTextField(5);
		
		f.add(lx1);
		f.add(tx1);
		
		f.add(ly1);
		f.add(ty1);
		
		f.add(lx2);
		f.add(tx2);
		
		f.add(ly2);
		f.add(ty2);
		
		f.add(lraio);
		f.add(raio);
		
		bReta = new JButton("Reta");
		bCirculo = new JButton("Circulo");
		bReta.setVisible(true);
		bCirculo.setVisible(true);
		
		ActionListener act = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ok");
				declive();
			}
		};
		bReta.addActionListener(act);
		
		ActionListener act2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ok2");
				circulo();
				
			}
			
		};
		bCirculo.addActionListener(act2);
		
		f.add(bReta);
		f.add(bCirculo);
		
		f.add(panel);
			
		f.setSize(310,200);
		f.setVisible(true);
		
	}//fim do layout
	public void declive () {
		Graphics g = panel.getGraphics();
		int dx, dy, m, b, y;
			
			dx = Integer.parseInt( tx2.getText() ) - Integer.parseInt( tx1.getText() );
			dy = Integer.parseInt( ty2.getText() ) - Integer.parseInt( ty1.getText() );
			
			m = dy/dx;
			b = Integer.parseInt( ty1.getText() ) - m*Integer.parseInt( tx1.getText() );
			if(Integer.parseInt(tx1.getText())<Integer.parseInt(tx2.getText())){
			 for(int i = Integer.parseInt(tx1.getText()); i<Integer.parseInt(tx2.getText()); i++) {
				 y=m*i+b;
				 g.drawOval(i,y, 1, 1);
	
			 }//fim do for
			} else {
				for(int i = Integer.parseInt(tx2.getText()); i<Integer.parseInt(tx1.getText()); i++) {
					 y=m*i+b;
					 g.drawOval(i,y , 1, 1);
				 }//fim do for
			}//fim do else

	}// fim do metodo declive
	
	public void circulo() {
		Graphics g = panel.getGraphics();
		int x,y;
		double seno, cosseno;
		
		for(int i = 0; i<360;i++) {
			seno = Math.sin((Math.PI/180)*i);
			int sen = (int)seno;
			cosseno = Math.cos((Math.PI/180)*i);
			int coss = (int)cosseno;
			int ray = Integer.parseInt(raio.getText());
			x = ray* sen ;
			y = ray * coss;
			
			g.drawOval(x, y, 1, 1);
		}//fim do for
	}

}