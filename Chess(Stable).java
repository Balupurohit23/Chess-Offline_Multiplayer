import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;  
class c extends JFrame implements  ActionListener
{
	JFrame revoke=new JFrame("Revoke");
	boolean rev=false;
	int input=1,player=0,b11,b12,b21,b22,un=0,token=1;
	int ub11[]=new int[100],ub12[]=new int[100],ub21[]=new int[100],ub22[]=new int[100];
	String flag="";
	JButton board[][]={	{new JButton(bro), new JButton(bkn), new JButton(bbi), new JButton(bqu), new JButton(bki), new JButton(bbi), new JButton(bkn), new JButton(bro)},
						{new JButton(bpa), new JButton(bpa), new JButton(bpa), new JButton(bpa), new JButton(bpa), new JButton(bpa), new JButton(bpa), new JButton(bpa)},
						{new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn)},
						{new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn)},
						{new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn)},
						{new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn), new JButton(nnn)},
						{new JButton(wpa), new JButton(wpa), new JButton(wpa), new JButton(wpa), new JButton(wpa), new JButton(wpa), new JButton(wpa), new JButton(wpa)},
						{new JButton(wro), new JButton(wkn), new JButton(wbi), new JButton(wqu), new JButton(wki), new JButton(wbi), new JButton(wkn), new JButton(wro)}
					  };	
	JButton reset=new JButton("Reset"),undo=new JButton("Undo");	
	JButton revokeButtonW[]={ new JButton(wqu), new JButton(wbi), new JButton(wkn), new JButton(wro) };
	JButton revokeButtonB[]={ new JButton(bqu), new JButton(bbi), new JButton(bkn), new JButton(bro) };	  

	static Icon nnn=new ImageIcon("./icons/null.png","null"),								bled=new ImageIcon("./icons/B_LED.png"),
				wpa=new ImageIcon("./icons/White_P.png","Wpa"),							pled=new ImageIcon("./icons/P_LED.png"),
				bpa=new ImageIcon("./icons/Black_P.png","Bpa"),					
				wro=new ImageIcon("./icons/White_R.png","Wro"),
				bro=new ImageIcon("./icons/Black_R.png","Bro"),
				wkn=new ImageIcon("./icons/White_N.png","Wkn"),
				bkn=new ImageIcon("./icons/Black_N.png","Bkn"),
				wbi=new ImageIcon("./icons/White_B.png","Wbi"),
				bbi=new ImageIcon("./icons/Black_B.png","Bbi"),
				wqu=new ImageIcon("./icons/White_Q.png","Wqu"),
				bqu=new ImageIcon("./icons/Black_Q.png","Bqu"),
				wki=new ImageIcon("./icons/White_K.png","Wki"),
				bki=new ImageIcon("./icons/Black_K.png","Bki"),
				input1,input2;

	Icon undo_input1[]=new Icon[100];
	Icon undo_input2[]=new Icon[100];

	Icon revokeIcon[]={ new ImageIcon("./icons/White_Q.png"), new ImageIcon("./icons/White_B.png"), new ImageIcon("./icons/White_N.png"), new ImageIcon("./icons/White_R.png"),
						new ImageIcon("./icons/Black_Q.png"), new ImageIcon("./icons/Black_B.png"), new ImageIcon("./icons/Black_N.png"), new ImageIcon("./icons/Black_R.png")};

	JLabel p1 = new JLabel("Player 1");
	JLabel p1i1 = new JLabel("Input 1:");
	JLabel p1i2 = new JLabel("Input 2:");
	JLabel p2 = new JLabel("Player 2");
	JLabel p2i1 = new JLabel("Input 1:");
	JLabel p2i2 = new JLabel("Input 2:");
	JLabel p1LED = new JLabel(pled);
	JLabel p1i1LED = new JLabel(bled);
	JLabel p1i2LED = new JLabel(bled);
	JLabel p2LED = new JLabel(pled);
	JLabel p2i1LED = new JLabel(bled);
	JLabel p2i2LED = new JLabel(bled);
	JLabel rp1 = new JLabel("Player 1:");
	JLabel rp2 = new JLabel("Player 2:");
		

	void Board()
	{
		int x=100,y=25;				   
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				board[i][j].setBounds(x,y,100, 80);
				add(board[i][j]);
				board[i][j].addActionListener(this);
				x+=100;

				if(i%2!=0 && j%2==0)
				{		board[i][j].setBackground(new Color(139,69,19));			}

				else if(i%2==0 && j%2!=0)
				{		board[i][j].setBackground(new Color(139,69,19));			}
				else
				{		board[i][j].setBackground(new Color(205,133,63));			}

			}
			x=100;
			y+=80;
		}

		revoke.setLayout(null);      
		revoke.setSize(500,500);
		revoke.setVisible(false);
								revoke.add(rp1);						revoke.add(rp2);
								rp1.setBounds(100,20,70,40);			rp2.setBounds(100,150,70,40);
		int rx=50;
		for(int i=0;i<4;i++)
		{
			revokeButtonW[i].setBounds(rx,60,100, 80);
			revoke.add(revokeButtonW[i]);
			revokeButtonW[i].addActionListener(this);
			rx+=100;
			rev=true;
		}
		rx=50;
		for(int i=0;i<4;i++)
		{
			revokeButtonB[i].setBounds(rx,190,100, 80);
			revoke.add(revokeButtonB[i]);
			revokeButtonB[i].addActionListener(this);
			rx+=100;
			rev=true;
		}

		reset.setBounds( 1000, 50, 100, 50);
		add(reset);
		reset.addActionListener(this);

		undo.setBounds( 1110, 50, 100, 50);
		add(undo);
		undo.addActionListener(this);

		add(p1);		add(p1LED);		add(p1i1);		add(p1i1LED);		add(p1i2);		add(p1i2LED);
		add(p2);		add(p2LED);		add(p2i1);		add(p2i1LED);		add(p2i2);		add(p2i2LED);

		p1.setBounds(1000,100,70,40);				p2.setBounds(1000,400,70,40);
		p1LED.setBounds(1080,100,40,40);			p2LED.setBounds(1080,400,40,40);
		p1i1.setBounds(1100,150,70,40);				p2i1.setBounds(1100,450,70,40);
		p1i1LED.setBounds(1280,150,40,40);			p2i1LED.setBounds(1180,450,40,40);
		p1i2.setBounds(1100,200,70,40);				p2i2.setBounds(1100,600,70,40);
		p1i2LED.setBounds(1280,200,40,40);			p2i2LED.setBounds(1180,600,40,40);

		p1i2LED.setVisible(false);
		p2LED.setVisible(false);	p2i1LED.setVisible(false);	p2i2LED.setVisible(false);
		//JOptionPane.showMessageDialog(this,"!!!AWK (COMPUTER) won!!! click reset");
	}

	public void actionPerformed( ActionEvent evt)
	{
		if(un<0)
		{
			Reset();
		}

		if(evt.getSource()==reset)
		{
			token=1;
			Reset();
		}

		else if(evt.getSource()==undo)
		{
			System.out.println(un);
			if(un>0)
			{
				board[ub11[un]][ub12[un]].setIcon(undo_input1[un]);
				board[ub21[un]][ub22[un]].setIcon(undo_input2[un]);
				if(un==1){System.out.println("un="+un);	Led(1,1); Reset();	}
				un--;	
			}

			if(token==1){	token=2;	Led(2,1);	}
			else if(token==2){	token=1;	Led(1,1);	}
		}
		
		else if( rev==true && b11==1 && b21==0 )
		{
			for(int i=0;i<4;i++)
			{
				if(evt.getSource()==revokeButtonW[i])
				{
					Icon revoked=wki;
					revoked=revokeButtonW[i].getIcon();
					board[b21][b22].setIcon(revoked);
					revoke.setVisible(false);
					rev=false;
				}
			}
		}

		else if( rev==true && b11==6 && b21==7 )
		{
			for(int i=0;i<4;i++)
			{
				if(evt.getSource()==revokeButtonB[i])
				{
					Icon revoked=wki;
					revoked=revokeButtonB[i].getIcon();
					board[b21][b22].setIcon(revoked);
					revoke.setVisible(false);
					rev=false;
				}
			}
		}

		else if(input==1)
		{
			for(int i=0;i<8;i++)
			{
				for(int j=0;j<8;j++)
				{
					if(evt.getSource()==board[i][j])
					{
						player++;
						System.out.println("token="+token+"\tinput="+input);
						Led(0,input);
						input1=board[i][j].getIcon();
						b11=i;		b12=j;
						input++;		
					}
				}
			}
		}

		else if(input==2)
		{
			for(int i=0;i<8;i++)
			{
				for(int j=0;j<8;j++)
				{
					if(evt.getSource()==board[i][j])
					{
						player++;
						System.out.println("token="+token+"\tinput="+input+"\n");
						input2=board[i][j].getIcon();
						b21=i;		b22=j;
						boolean checked=Check();
						if(checked==true)
						{
							Change();
							if(token==1){	Led(1,1);	input--;	}
							else if(token==2){	Led(2,2);	input--;	}
						}
						else if(checked==false && token==1){	Led(1,1);	input--;	}
						else if(checked==false && token==2){	Led(2,2);	input--;	}
					}
				}
			}
		}
	}

	void Reset()
	{
		board[0][0].setIcon(bro);	board[0][1].setIcon(bkn); board[0][2].setIcon(bbi); board[0][3].setIcon(bqu); board[0][4].setIcon(bki); board[0][5].setIcon(bbi); board[0][6].setIcon(bkn); board[0][7].setIcon(bro);
		board[1][0].setIcon(bpa);	board[1][1].setIcon(bpa); board[1][2].setIcon(bpa); board[1][3].setIcon(bpa); board[1][4].setIcon(bpa); board[1][5].setIcon(bpa); board[1][6].setIcon(bpa); board[1][7].setIcon(bpa);
		board[6][0].setIcon(wpa);	board[6][1].setIcon(wpa); board[6][2].setIcon(wpa); board[6][3].setIcon(wpa); board[6][4].setIcon(wpa); board[6][5].setIcon(wpa); board[6][6].setIcon(wpa); board[6][7].setIcon(wpa);
		board[7][0].setIcon(wro);	board[7][1].setIcon(wkn); board[7][2].setIcon(wbi); board[7][3].setIcon(wqu); board[7][4].setIcon(wki); board[7][5].setIcon(wbi); board[7][6].setIcon(wkn); board[7][7].setIcon(wro);
		for(int i=2;i<6;i++)
		{
			for(int j=0;j<8;j++)
			{
				board[i][j].setIcon(nnn);
			}
		}
		token=1;
		input=1;
		un=0;
		Led(1,1);					 
	}

	void Revoke()
	{
		revoke.setVisible(true);
		rev=true;
	}

	void Undo()
	{
		if(un>=0)
		{
			un++;
			undo_input1[un]=input1;
			undo_input2[un]=input2;
			ub11[un]=b11;		ub12[un]=b12;		ub21[un]=b21;		ub22[un]=b22;		
		}
	}

	boolean Check()
	{
		boolean ret=false;
		if(token == 1)
		{
			if( input2 != wpa && input2 != wro && input2 != wkn && input2 != wbi && input2 != wqu && input2 != wki )
			{
				if( input1 == wpa )
				{		ret=true;		flag="wpa";		}
				else if( input1 == wro )
				{		ret=true;		flag="wro";		}
				else if( input1 == wkn )
				{		ret=true;		flag="wkn";		}
				else if( input1 == wbi )
				{		ret=true;		flag="wbi";		}
				else if( input1 == wqu )
				{		ret=true;		flag="wqu";		}
				else if( input1 == wki )
				{		ret=true;		flag="wki";		}			
			}
		}
		if(token == 2)
		{
			if( input2 != bpa && input2 != bro && input2 != bkn && input2 != bbi && input2 != bqu && input2 != bki )
			{
				if( input1 == bpa )
				{		ret=true;		flag="bpa";		}
				else if( input1 == bro )
				{		ret=true;		flag="bro";		}
				else if( input1 == bkn )
				{		ret=true;		flag="bkn";		}
				else if( input1 == bbi )
				{		ret=true;		flag="bbi";		}
				else if( input1 == bqu )
				{		ret=true;		flag="bqu";		}
				else if( input1 == bki )
				{		ret=true;		flag="bki";		}			
			}
		}
		return ret;
	} 

	boolean PathCheck(String direction)
	{
		boolean ret=true;
		if(b12==b22 && direction=="agad")
		{
			for(int i=b11+1,j=b12;i<b21;i++)
			{
				if( board[i][j].getIcon()!=nnn )
				{	ret=false;	}
			}
		}
		else if(b12==b22 && direction=="pa6ad")
		{
			for(int i=b11-1,j=b12;i>b21;i--)
			{
				if( board[i][j].getIcon()!=nnn )
				{	ret=false;	}
			}
		}
		else if(b11==b21 && direction=="right")
		{
			for(int j=b12+1,i=b11;j<b22;j++)
			{
				if( board[i][j].getIcon()!=nnn )
				{	ret=false;	}
			}
		}
		else if(b11==b21 && direction=="left")
		{
			for(int j=b12-1,i=b11;j>b22;j--)
			{
				if( board[i][j].getIcon()!=nnn )
				{	ret=false;	}
			}
		}
		else if( direction=="right Diagonal++" )
		{
			for(int i=b11+1,j=b12+1;i<b21 && j<b22;i++,j++)
			{
				if( board[i][j].getIcon()!=nnn )
				{	ret=false;	}
			}
		}
		else if( direction=="left Diagonal++" )
		{
			for(int i=b11+1,j=b12-1;i<b21 && j>b22;i++,j--)
			{
				if( board[i][j].getIcon()!=nnn )
				{	ret=false;	}
			}
		}
		else if( direction=="right Diagonal--" )
		{
			for(int i=b11-1,j=b12+1;i>b21 && j<b22;i--,j++)
			{
				if( board[i][j].getIcon()!=nnn )
				{	ret=false;	}
			}
		}
		else if( direction=="left Diagonal--" )
		{
			for(int i=b11-1,j=b12-1;i>b21 && j>b22;i--,j--)
			{
				if( board[i][j].getIcon()!=nnn )
				{	ret=false;	}
			}
		}
		return ret;
	}

	void Change()
	{
		//Checkmate();
		if(flag=="wpa" )
		{
			if( b21==(b11-1) )
			{
				if( b22==b12 && input2==nnn )
				{
					if(b21==0)
					{
						board[b11][b12].setIcon(nnn);
						board[b21][b22].setIcon(input1);
						Undo();
						Revoke();
						token=2;
					}
					else
					{
						board[b11][b12].setIcon(nnn);
						board[b21][b22].setIcon(input1);
						Undo();
						token=2;
					}
				}
				else if( b22==(b12+1) || b22==(b12-1) )
				{
					if( input2!=nnn )
					{
						if(input2==bki){	JOptionPane.showMessageDialog(this,"!!!Wooh (PLAYER 1) won!!!");	Reset();	}
						else if(b21==0)
						{
							board[b11][b12].setIcon(nnn);
							board[b21][b22].setIcon(input1);
							Undo();
							Revoke();
							token=2;
						}
						else
						{
							board[b11][b12].setIcon(nnn);
							board[b21][b22].setIcon(input1);
							Undo();
							token=2;	
						}
					}
				}
			}
			else if( b21==(b11-2) && b11==6 && b22==b12 && input2==nnn && board[b11-1][b12].getIcon()==nnn )
			{
				board[b11][b12].setIcon(nnn);
				board[b21][b22].setIcon(input1);
				Undo();
				token=2;
			}
		}
		else if(flag=="wro" )
		{
			boolean go=false;
			if( b11>b21 ){	go=PathCheck("pa6ad");	}
			else if( b11<b21 ){	go=PathCheck("agad");	}
			else if( b12>b22 ){	go=PathCheck("left");	}
			else if( b12<b22 ){	go=PathCheck("right");	}
			if( go==true )
			{
				if(input2==bki){	JOptionPane.showMessageDialog(this,"!!!Wooh (PLAYER 1) won!!!");	Reset();	}
				else
				{
					board[b11][b12].setIcon(nnn);
					board[b21][b22].setIcon(input1);
					Undo();
					token=2;	
				}
			}
		}
		else if(flag=="wkn")
		{
			if( b21==(b11-2) || b21==(b11+2) )
			{
				if( b22==(b12+1) || b22==(b12-1) )
				{
					if(input2==bki){	JOptionPane.showMessageDialog(this,"!!!Wooh (PLAYER 1) won!!!");	Reset();	}
					else
					{
						board[b11][b12].setIcon(nnn);
						board[b21][b22].setIcon(input1);
						Undo();
						token=2;	
					}
				}
			}
			else if( b21==(b11-1) || b21==(b11+1) )
			{
				if( b22==(b12+2) || b22==(b12-2) )
				{
					if(input2==bki){	JOptionPane.showMessageDialog(this,"!!!Wooh (PLAYER 1) won!!!");	Reset();	}
					else
					{
						board[b11][b12].setIcon(nnn);
						board[b21][b22].setIcon(input1);
						Undo();
						token=2;	
					}
				}
			}
		}
		else if(flag=="wbi" )
		{
			boolean go=false;
			if( b11<b21 && b12<b22 ){	go=PathCheck("right Diagonal++");	}
			else if( b11<b21 && b12>b22 ){	go=PathCheck("left Diagonal++");	}
			else if( b11>b21 && b12<b22 ){	go=PathCheck("right Diagonal--");	}
			else if( b11>b21 && b12>b22 ){	go=PathCheck("left Diagonal--");	}
			if( go==true )
			{
				if(input2==bki){	JOptionPane.showMessageDialog(this,"!!!Wooh (PLAYER 1) won!!!");	Reset();	}
				else
				{
					board[b11][b12].setIcon(nnn);
					board[b21][b22].setIcon(input1);
					Undo();
					token=2;	
				}
			}
		}
		else if(flag=="wqu" )
		{
			boolean go=false;
			if( b11>b21 && b12==b22){	go=PathCheck("pa6ad");	}
			else if( b11<b21 && b12==b22 ){	go=PathCheck("agad");	}
			else if( b12>b22 && b11==b21 ){	go=PathCheck("left");	}
			else if( b12<b22 && b11==b21 ){	go=PathCheck("right");	}
			else if( b11<b21 && b12<b22 ){	go=PathCheck("right Diagonal++");	}
			else if( b11<b21 && b12>b22 ){	go=PathCheck("left Diagonal++");	}
			else if( b11>b21 && b12<b22 ){	go=PathCheck("right Diagonal--");	}
			else if( b11>b21 && b12>b22 ){	go=PathCheck("left Diagonal--");	}
			if( go==true )
			{
				if(input2==bki){	JOptionPane.showMessageDialog(this,"!!!Wooh (PLAYER 1) won!!!");	Reset();	}
				else
				{
					board[b11][b12].setIcon(nnn);
					board[b21][b22].setIcon(input1);
					Undo();
					token=2;	
				}
			}
		}
		else if(flag=="wki" )
		{
			if( b21==(b11-1) || b21==(b11+1) || b21==b11 && input2==nnn)
			{
				if( b22==b12 || b22==(b12+1) || b22==(b12-1) )
				{
					board[b11][b12].setIcon(nnn);
					board[b21][b22].setIcon(input1);
					Undo();
					token=2;
				}
			}
			else if( b21==(b11+1) || b21==(b11-1) || b21==b11 && input2!=nnn )
			{
				if( b22==b12 || b22==(b12+1) || b22==(b12-1) )
				{
					if(input2==bki){	JOptionPane.showMessageDialog(this,"!!!Wooh (PLAYER 1) won!!!");	Reset();	}
					else
					{
						board[b11][b12].setIcon(nnn);
						board[b21][b22].setIcon(input1);
						Undo();
						token=2;	
					}
				}
			}
		}

		else if(flag=="bpa" )
		{
			if( b21==(b11+1) )
			{
				if( b22==b12 && input2==nnn )
				{
					if(b21==7)
					{
						board[b11][b12].setIcon(nnn);
						board[b21][b22].setIcon(input1);
						Undo();
						Revoke();
						token=1;
					}
					else
					{
						board[b11][b12].setIcon(nnn);
						board[b21][b22].setIcon(input1);
						Undo();
						token=1;
					}
				}
				else if( b22==(b12+1) || b22==(b12-1) )
				{
					if( input2!=nnn )
					{
						if(input2==wki){	JOptionPane.showMessageDialog(this,"!!!Wooh (PLAYER 2) won!!!");	Reset();	}
						else if(b21==7)
						{
							board[b11][b12].setIcon(nnn);
							board[b21][b22].setIcon(input1);
							Undo();
							Revoke();
							token=1;
						}
						else
						{
							board[b11][b12].setIcon(nnn);
							board[b21][b22].setIcon(input1);
							Undo();
							token=1;
						}
					}
				}
			}
			else if( b21==(b11+2) && b11==1 && b22==b12 && input2==nnn && board[b11+1][b12].getIcon()==nnn )
			{
				board[b11][b12].setIcon(nnn);
				board[b21][b22].setIcon(input1);
				Undo();
				token=1;
			}
		}
		else if(flag=="bro" )
		{
			boolean go=false;
			if( b11>b21 ){	go=PathCheck("pa6ad");	}
			else if( b11<b21 ){	go=PathCheck("agad");	}
			else if( b12>b22 ){	go=PathCheck("left");	}
			else if( b12<b22 ){	go=PathCheck("right");	}
			if( go==true )
			{
				if(input2==wki){	JOptionPane.showMessageDialog(this,"!!!Wooh (PLAYER 2) won!!!");	Reset();	}
				else
				{
					board[b11][b12].setIcon(nnn);
					board[b21][b22].setIcon(input1);
					Undo();
					token=1;	
				}
			}
		}
		else if(flag=="bkn" )
		{
			if( b21==(b11-2) || b21==(b11+2) )
			{
				if( b22==(b12+1) || b22==(b12-1) )
				{
					if(input2==wki){	JOptionPane.showMessageDialog(this,"!!!Wooh (PLAYER 2) won!!!");	Reset();	}
					else
					{
						board[b11][b12].setIcon(nnn);
						board[b21][b22].setIcon(input1);
						Undo();
						token=1;	
					}
				}
			}
			else if( b21==(b11-1) || b21==(b11+1) )
			{
				if( b22==(b12+2) || b22==(b12-2) )
				{
					if(input2==wki){	JOptionPane.showMessageDialog(this,"!!!Wooh (PLAYER 2) won!!!");	Reset();	}
					else
					{
						board[b11][b12].setIcon(nnn);
						board[b21][b22].setIcon(input1);
						Undo();
						token=1;	
					}
				}
			}
		}
		else if(flag=="bbi" )
		{
			boolean go=false;
			if( b11<b21 && b12<b22 ){	go=PathCheck("right Diagonal++");	}
			else if( b11<b21 && b12>b22 ){	go=PathCheck("left Diagonal++");	}
			else if( b11>b21 && b12<b22 ){	go=PathCheck("right Diagonal--");	}
			else if( b11>b21 && b12>b22 ){	go=PathCheck("left Diagonal--");	}
			if( go==true )
			{
				if(input2==wki){	JOptionPane.showMessageDialog(this,"!!!Wooh (PLAYER 2) won!!!");	Reset();	}
				else
				{
					board[b11][b12].setIcon(nnn);
					board[b21][b22].setIcon(input1);
					Undo();
					token=1;	
				}
			}
		}
		else if(flag=="bqu" )
		{
			boolean go=false;
			if( b11>b21 ){	go=PathCheck("pa6ad");	}
			else if( b11<b21 ){	go=PathCheck("agad");	}
			else if( b12>b22 ){	go=PathCheck("left");	}
			else if( b12<b22 ){	go=PathCheck("right");	}
			else if( b11<b21 && b12<b22 ){	go=PathCheck("right Diagonal++");	}
			else if( b11<b21 && b12>b22 ){	go=PathCheck("left Diagonal++");	}
			else if( b11>b21 && b12<b22 ){	go=PathCheck("right Diagonal--");	}
			else if( b11>b21 && b12>b22 ){	go=PathCheck("left Diagonal--");	}
			if( go==true )
			{
				if(input2==wki){	JOptionPane.showMessageDialog(this,"!!!Wooh (PLAYER 2) won!!!");	Reset();	}
				else
				{
					board[b11][b12].setIcon(nnn);
					board[b21][b22].setIcon(input1);
					Undo();
					token=1;	
				}
			}
		}
		else if(flag=="bki" )
		{
			if( b21==(b11-1) || b21==(b11+1) || b21==b11 && input2==nnn)
			{
				if( b22==b12 || b22==(b12+1) || b22==(b12-1) )
				{
					board[b11][b12].setIcon(nnn);
					board[b21][b22].setIcon(input1);
					Undo();
					token=1;
				}
			}
			else if( b21==(b11+1) || b21==(b11-1) || b21==b11 && input2!=nnn )
			{
				if( b22==b12 || b22==(b12+1) || b22==(b12-1) )
				{
					if(input2==wki){	JOptionPane.showMessageDialog(this,"!!!Wooh (PLAYER 2) won!!!");	Reset();	}
					else
					{
						board[b11][b12].setIcon(nnn);
						board[b21][b22].setIcon(input1);
						Undo();
						token=1;	
					}
				}
			}
		}
	}

	void Led(int pl,int ip)
	{
		if(pl==1)
		{
			p2LED.setVisible(false);
			p1i2LED.setVisible(false);	p2i1LED.setVisible(false);	p2i2LED.setVisible(false);
			p1LED.setVisible(true);	p1i1LED.setVisible(true);
		}

		else if(pl==2)
		{
			p1LED.setVisible(false);
			p1i1LED.setVisible(false);	p1i2LED.setVisible(false);	p2i2LED.setVisible(false);
			p2LED.setVisible(true);	p2i1LED.setVisible(true);

		}
		else if(token==1)
		{	
			if(ip==1)		{	p1i1LED.setVisible(false);		p1i2LED.setVisible(true);	}
			else if(ip==2)	{	p1i2LED.setVisible(false);		p2i1LED.setVisible(true);	
								p1LED.setVisible(false);		p2LED.setVisible(true);		}
		}

		else if(token==2)
		{	
			if(ip==1)		{	p2i1LED.setVisible(false);		p2i2LED.setVisible(true);	}
			else if(ip==2)	{	p2i2LED.setVisible(false);		p1i1LED.setVisible(true);	
								p2LED.setVisible(false);		p1LED.setVisible(true);		}
		}
	}

	c()
	{
		super("CHESS - Let's Play");
		this.setIconImage(new ImageIcon(getClass().getResource("./icons/icon.png")).getImage());

		Board();

		setLayout(null);      
		setSize(1366,768);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[])
	{
		new c();
	}
}