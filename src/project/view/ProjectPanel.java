package project.view;

import project.controller.ProjectController;
import project.model.APButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.*;

public class ProjectPanel extends JPanel
{
	private ProjectController appController;
	private GridLayout appLayout;
	public ProjectFrame myFrame;
	
	private APButton buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonTen;
	private APButton buttonEleven, buttonTwelve, buttonThirteen, buttonFourteen, buttonFifteen, buttonSixteen;
	
	int[][] sliderArray = new int[4][4];
	
	public ProjectPanel(ProjectController appController)
	{
		super();
		this.appController = appController;
			
		appLayout 	= new GridLayout(4,4);
		buttonOne 	= new APButton("1",1,1, true);
		buttonTwo 	= new APButton("2",2,2, true);
		buttonThree 	= new APButton("3",3,3, true);
		buttonFour 	= new APButton("4",4,4, true);
		buttonFive 	= new APButton("5",5,5, true);
		buttonSix 	= new APButton("6",6,6, true);
		buttonSeven 	= new APButton("7",7,7, true);
		buttonEight 	= new APButton("8",8,8, true);
		buttonNine 	= new APButton("9",9,9, true);
		buttonTen 	= new APButton("10",10,10, true);
		buttonEleven 	= new APButton("11",11,11, true);
		buttonTwelve 	= new APButton("12",12,12, true);
		buttonThirteen 	= new APButton("13",13,13, true);
		buttonFourteen 	= new APButton("14",14,14, true);
		buttonFifteen 	= new APButton("15",15,15, true);
		buttonSixteen 	= new APButton("16",15,15, false);
		
		setupPanel();
		setupListeners(buttonOne);
		setupListeners(buttonTwo);
		setupListeners(buttonThree);
		setupListeners(buttonFour);
		setupListeners(buttonFive);
		setupListeners(buttonSix);
		setupListeners(buttonSeven);
		setupListeners(buttonEight);
		setupListeners(buttonNine);
		setupListeners(buttonTen);
		setupListeners(buttonEleven);
		setupListeners(buttonTwelve);
		setupListeners(buttonThirteen);
		setupListeners(buttonFourteen);
		setupListeners(buttonFifteen);
		setupListeners(buttonSixteen);
	}
	
	public void closePanel()
	{
		myFrame.dispose();
	} 
	private void setupPanel()
	{
		
		this.setLayout(appLayout);
		this.add(buttonOne);
		this.add(buttonTwo);
		this.add(buttonThree);
		this.add(buttonFour);
		this.add(buttonFive);
		this.add(buttonSix);
		this.add(buttonSeven);
		this.add(buttonEight);
		this.add(buttonNine);
		this.add(buttonTen);
		this.add(buttonEleven);
		this.add(buttonTwelve);
		this.add(buttonThirteen);
		this.add(buttonFourteen);
		this.add(buttonFifteen);
		this.add(buttonSixteen);
		
		shuffle();
		
		buttonSixteen.setEnabled(false);
	}
	
	private void passPosNameEnable(APButton one, APButton two)
	{
		
		String oneText = one.getText();
		String twoText = two.getText();
		one.setText(twoText);
		two.setText(oneText);
		
		int onePos = one.getPos();
		int twoPos = two.getPos();
		one.setPos(twoPos);
		two.setPos(onePos);
		
		Boolean oneEnabled = one.isEnabled();
		Boolean twoEnabled = two.isEnabled();
		one.setEnabled(twoEnabled);
		two.setEnabled(oneEnabled);
	}
	
	private void winGame()
	{
		System.out.println("You win");
		appController.getAppFrame().dispose();
		
		VictoryFrame winFrame = new VictoryFrame(appController);
		buttonOne		.setEnabled(false);
		buttonTwo		.setEnabled(false);
		buttonThree		.setEnabled(false);
		buttonFour		.setEnabled(false);
		buttonFive		.setEnabled(false);
		buttonSix		.setEnabled(false);
		buttonSeven		.setEnabled(false);
		buttonEight		.setEnabled(false);
		buttonNine		.setEnabled(false);
		buttonTen		.setEnabled(false);
		buttonEleven		.setEnabled(false);
		buttonTwelve		.setEnabled(false);
		buttonThirteen	.setEnabled(false);
		buttonFourteen	.setEnabled(false);
		buttonFifteen	.setEnabled(false);
		buttonSixteen	.setEnabled(false);
		
		
	}
	
	private void setupListeners(APButton button)
	{		
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
				slideButton(button);		
			}
		});
	}
	
	public void restart()
	{
		//System.out.println("restarting");
		shuffle();
		resetEnabled();
	}
	private void checkWin()
	{
		int win = 0;
		
		int[] checkButton = { buttonOne.getPos(),buttonTwo.getPos(),buttonThree.getPos(),buttonFour.getPos(),
				buttonFive.getPos(),buttonSix.getPos(),buttonSeven.getPos(),buttonEight.getPos(),buttonNine.getPos(),
				buttonTen.getPos(),buttonEleven.getPos(),buttonTwelve.getPos(),buttonThirteen.getPos(),buttonFourteen.getPos(),
					buttonFifteen.getPos(),buttonSixteen.getPos() };
		
		for(int i = 0; i < 16; i++)
		{
			if(checkButton[i] == i + 1)
			{
				win++;
			}
			if(win == 16)
			{
				winGame();
			}
		}
	}
	private void resetEnabled()
	{
		System.out.println("Resetting Enabled");
		buttonOne		.setEnabled(true);
		buttonTwo		.setEnabled(true);
		buttonThree		.setEnabled(true);
		buttonFour		.setEnabled(true);
		buttonFive		.setEnabled(true);
		buttonSix		.setEnabled(true);
		buttonSeven		.setEnabled(true);
		buttonEight		.setEnabled(true);
		buttonNine		.setEnabled(true);
		buttonTen		.setEnabled(true);
		buttonEleven		.setEnabled(true);
		buttonTwelve		.setEnabled(true);
		buttonThirteen	.setEnabled(true);
		buttonFourteen	.setEnabled(true);
		buttonFifteen	.setEnabled(true);
		System.out.println("ButtonFifteen" + buttonFifteen.isEnabled());
		buttonSixteen	.setEnabled(false);
		repaint();
	}
	
	private void shuffle()
	{
		
		System.out.println("Shuffling");
		int random = ((int)(Math.random() * 5)+1);
		System.out.println("MATH IS" + random);
		
		random = 6;
		if(random == 1)
		{
			buttonOne		.setPosAndName(11,"11");
			buttonTwo		.setPosAndName(9, "9");
			buttonThree		.setPosAndName(1, "1");
			buttonFour		.setPosAndName(15,"15");
			buttonFive		.setPosAndName(12,"12");
			buttonSix		.setPosAndName(6, "10");
			buttonSeven		.setPosAndName(4, "4");
			buttonEight		.setPosAndName(14,"14");
			buttonNine		.setPosAndName(3, "3");
			buttonTen		.setPosAndName(8, "8");
			buttonEleven		.setPosAndName(4, "4");
			buttonTwelve		.setPosAndName(2, "2");
			buttonThirteen	.setPosAndName(6, "6");
			buttonFourteen	.setPosAndName(5, "5");
			buttonFifteen	.setPosAndName(7, "7");
			buttonSixteen	.setPosAndName(10,"");
		}
		if(random == 2)
		{
			buttonOne		.setPosAndName(11,"11");
			buttonTwo		.setPosAndName(10,"10");
			buttonThree		.setPosAndName(9, "9");
			buttonFour		.setPosAndName(16,"14");
			buttonFive		.setPosAndName(5, "5");
			buttonSix		.setPosAndName(6, "6");
			buttonSeven		.setPosAndName(3, "3");
			buttonEight		.setPosAndName(1, "1");
			buttonNine		.setPosAndName(15,"15");
			buttonTen		.setPosAndName(13,"13");
			buttonEleven		.setPosAndName(8, "8");
			buttonTwelve		.setPosAndName(12,"12");
			buttonThirteen	.setPosAndName(2, "2");
			buttonFourteen	.setPosAndName(4, "4");
			buttonFifteen	.setPosAndName(7, "7");
			buttonSixteen	.setPosAndName(14,"");
		}
		if(random == 3)
		{
			buttonOne		.setPosAndName(6, "6");
			buttonTwo		.setPosAndName(7, "7");
			buttonThree		.setPosAndName(8, "8");
			buttonFour		.setPosAndName(2, "2");
			buttonFive		.setPosAndName(4, "4");
			buttonSix		.setPosAndName(1, "1");
			buttonSeven		.setPosAndName(5, "5");
			buttonEight		.setPosAndName(9, "9");
			buttonNine		.setPosAndName(11,"11");
			buttonTen		.setPosAndName(10,"10");
			buttonEleven		.setPosAndName(16,"15");
			buttonTwelve		.setPosAndName(14,"14");
			buttonThirteen	.setPosAndName(13,"13");
			buttonFourteen	.setPosAndName(3, "3");
			buttonFifteen	.setPosAndName(12,"12");
			buttonSixteen	.setPosAndName(15,"");
		}
		if(random == 4)
		{
			buttonOne		.setPosAndName(8, "8");
			buttonTwo		.setPosAndName(5, "5");
			buttonThree		.setPosAndName(2, "2");
			buttonFour		.setPosAndName(11,"11");
			buttonFive		.setPosAndName(15,"15");
			buttonSix		.setPosAndName(3, "3");
			buttonSeven		.setPosAndName(6, "6");
			buttonEight		.setPosAndName(9, "9");
			buttonNine		.setPosAndName(10,"10");
			buttonTen		.setPosAndName(1, "1");
			buttonEleven		.setPosAndName(13,"13");
			buttonTwelve		.setPosAndName(12,"12");
			buttonThirteen	.setPosAndName(4, "4");
			buttonFourteen	.setPosAndName(7, "7");
			buttonFifteen	.setPosAndName(14,"14");
			buttonSixteen	.setPosAndName(16,"");
		}
		if(random == 5)
		{
			buttonOne		.setPosAndName(7, "7");
			buttonTwo		.setPosAndName(8, "8");
			buttonThree		.setPosAndName(10,"10");
			buttonFour		.setPosAndName(14,"14");
			buttonFive		.setPosAndName(16,"6");
			buttonSix		.setPosAndName(1, "1");
			buttonSeven		.setPosAndName(9, "9");
			buttonEight		.setPosAndName(2, "2");
			buttonNine		.setPosAndName(11,"11");
			buttonTen		.setPosAndName(3, "3");
			buttonEleven		.setPosAndName(4, "4");
			buttonTwelve		.setPosAndName(15,"15");
			buttonThirteen	.setPosAndName(5, "5");
			buttonFourteen	.setPosAndName(13,"13");
			buttonFifteen	.setPosAndName(12,"12");
			buttonSixteen	.setPosAndName(6, "");
		}
		if(random == 6)
		{
			buttonOne		.setPosAndName(1, "1");
			buttonTwo		.setPosAndName(2, "2");
			buttonThree		.setPosAndName(3, "3");
			buttonFour		.setPosAndName(4, "4");
			buttonFive		.setPosAndName(5, "5");
			buttonSix		.setPosAndName(6, "6");
			buttonSeven		.setPosAndName(7, "7");
			buttonEight		.setPosAndName(8, "8");
			buttonNine		.setPosAndName(9, "9");
			buttonTen		.setPosAndName(10, "10");
			buttonEleven		.setPosAndName(15, "15");
			buttonTwelve		.setPosAndName(11, "11");
			buttonThirteen	.setPosAndName(13, "13");
			buttonFourteen	.setPosAndName(14, "14");
			buttonFifteen	.setPosAndName(12, "12");
			buttonSixteen	.setPosAndName(16, "");	
		}
	}
	
	private void slideButton(APButton button)
	{
		if(button == buttonOne)
		{
			if(!buttonTwo.isEnabled())
			{
				passPosNameEnable(buttonTwo, buttonOne);
			}
			if(!buttonFive.isEnabled())
			{
				passPosNameEnable(buttonFive, buttonOne);
			}
			checkWin();
		}
		if(button == buttonTwo)
		{
			if(!buttonOne.isEnabled())
			{
				passPosNameEnable(buttonOne, buttonTwo);
			}
			if(!buttonSix.isEnabled())
			{
				passPosNameEnable(buttonSix, buttonTwo);
			}
			if(!buttonThree.isEnabled())
			{
				passPosNameEnable(buttonThree, buttonTwo);
			}
			checkWin();
		}
		if(button == buttonThree)
		{
			if(!buttonFour.isEnabled())
			{
				passPosNameEnable(buttonFour, buttonThree);
			}
			if(!buttonSeven.isEnabled())
			{
				passPosNameEnable(buttonSeven, buttonThree);
			}
			if(!buttonTwo.isEnabled())
			{
				passPosNameEnable(buttonTwo, buttonThree);
			}
			checkWin();
		}
		if(button == buttonFour)
		{
			if(!buttonThree.isEnabled())
			{
				passPosNameEnable(buttonThree, buttonFour);
			}
			if(!buttonEight.isEnabled())
			{
				passPosNameEnable(buttonEight, buttonFour);
			}
			checkWin();
		}
		if(button == buttonFive)
		{
			if(!buttonOne.isEnabled())
			{
				passPosNameEnable(buttonOne, buttonFive);
			}
			if(!buttonSix.isEnabled())
			{
				passPosNameEnable(buttonSix, buttonFive);
			}
			if(!buttonNine.isEnabled())
			{
				passPosNameEnable(buttonNine, buttonFive);
			}
			checkWin();
		}
		if(button == buttonSix)
		{
			if(!buttonFive.isEnabled())
			{
				passPosNameEnable(buttonFive, buttonSix);
			}
			if(!buttonTen.isEnabled())
			{
				passPosNameEnable(buttonTen, buttonSix);
			}
			if(!buttonTwo.isEnabled())
			{
				passPosNameEnable(buttonTwo, buttonSix);
			}
			if(!buttonSeven.isEnabled())
			{
				passPosNameEnable(buttonSeven, buttonSix);
			}
			checkWin();
		}
		if(button == buttonSeven)
		{
			if(!buttonSix.isEnabled())
			{
				passPosNameEnable(buttonSix, buttonSeven);
			}
			if(!buttonEleven.isEnabled())
			{
				passPosNameEnable(buttonEleven, buttonSeven);
			}
			if(!buttonThree.isEnabled())
			{
				passPosNameEnable(buttonThree, buttonSeven);
			}
			if(!buttonEight.isEnabled())
			{
				passPosNameEnable(buttonEight, buttonSeven);
			}
			checkWin();
		}
		if(button == buttonEight)
		{
			if(!buttonFour.isEnabled())
			{
				passPosNameEnable(buttonFour, buttonEight);
			}
			if(!buttonSeven.isEnabled())
			{
				passPosNameEnable(buttonSeven, buttonEight);
			}
			if(!buttonTwelve.isEnabled())
			{
				passPosNameEnable(buttonTwelve, buttonEight);
			}
			checkWin();
		}
		if(button == buttonNine)
		{
			if(!buttonTen.isEnabled())
			{
				passPosNameEnable(buttonTen, buttonNine);
			}
			if(!buttonThirteen.isEnabled())
			{
				passPosNameEnable(buttonThirteen, buttonNine);
			}
			if(!buttonFive.isEnabled())
			{
				passPosNameEnable(buttonFive, buttonNine);
			}
			checkWin();
		}
		if(button == buttonTen)
		{
			if(!buttonEleven.isEnabled())
			{
				passPosNameEnable(buttonEleven, buttonTen);
			}
			if(!buttonNine.isEnabled())
			{
				passPosNameEnable(buttonNine, buttonTen);
			}
			if(!buttonSix.isEnabled())
			{
				passPosNameEnable(buttonSix, buttonTen);
			}
			if(!buttonFourteen.isEnabled())
			{
				passPosNameEnable(buttonFourteen, buttonTen);
			}
			checkWin();
		}
		if(button == buttonEleven)
		{
			if(!buttonTwelve.isEnabled())
			{
				passPosNameEnable(buttonTwelve, buttonEleven);
			}
			if(!buttonTen.isEnabled())
			{
				passPosNameEnable(buttonTen, buttonEleven);
			}
			if(!buttonSeven.isEnabled())
			{
				passPosNameEnable(buttonSeven, buttonEleven);
			}
			if(!buttonFifteen.isEnabled())
			{
				passPosNameEnable(buttonFifteen, buttonEleven);
			}
			checkWin();
		}
		if(button == buttonTwelve)
		{
			if(!buttonEleven.isEnabled())
			{
				passPosNameEnable(buttonEleven, buttonTwelve);
			}
			if(!buttonEight.isEnabled())
			{
				passPosNameEnable(buttonTwelve, buttonEight);
			}
			if(!buttonSixteen.isEnabled())
			{
				passPosNameEnable(buttonSixteen, buttonTwelve);
			}
			checkWin();
		}
		if(button == buttonThirteen)
		{
			if(!buttonNine.isEnabled())
			{
				passPosNameEnable(buttonNine, buttonThirteen);
			}
			if(!buttonFourteen.isEnabled())
			{
				passPosNameEnable(buttonFourteen, buttonThirteen);
			}
			checkWin();
		}
		if(button == buttonFourteen)
		{
			if(!buttonThirteen.isEnabled())
			{
				passPosNameEnable(buttonThirteen, buttonFourteen);
			}
			if(!buttonTen.isEnabled())
			{
				passPosNameEnable(buttonTen, buttonFourteen);
			}
			if(!buttonFifteen.isEnabled())
			{
				passPosNameEnable(buttonFifteen, buttonFourteen);
			}
			checkWin();
		}
		if(button == buttonFifteen)
		{
			if(!buttonFourteen.isEnabled())
			{
				passPosNameEnable(buttonFifteen, buttonFourteen);
			}
			if(!buttonEleven.isEnabled())
			{
				passPosNameEnable(buttonFifteen, buttonEleven);
			}
			if(!buttonSixteen.isEnabled())
			{
				passPosNameEnable(buttonFifteen, buttonSixteen);
			}
			checkWin();
		}
		if(button == buttonSixteen)
		{
			if(!buttonTwelve.isEnabled())
			{
				passPosNameEnable(buttonSixteen, buttonTwelve);
			}
			if(!buttonFifteen.isEnabled())
			{
				passPosNameEnable(buttonSixteen, buttonFifteen);
			}
			checkWin();
		}
	}
}
