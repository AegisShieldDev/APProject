package project.view;

import project.controller.ProjectController;
import project.view.VictoryFrame;
import project.model.APButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.*;

public class VictoryPanel extends JPanel
{
	private ProjectController appController;
	private JLabel label;
	private JButton replay, quit;
	private GridLayout appLayout;
	private JPanel panel;
	private ProjectPanel myGame;
	private VictoryFrame myFrame;
	
	public VictoryPanel(ProjectController appController, VictoryFrame myFrame)
	{
		this.appController = appController;
		appLayout = new GridLayout(2,1);
		this.setLayout(appLayout);
		this.myFrame = myFrame;
		JPanel panel = new JPanel(new GridLayout(1,2));
		
		JLabel label = new JLabel("<html>You win! <br><br> Replay?</html>", SwingConstants.CENTER);
		
		JButton replay = new JButton("Replay");
		JButton quit = new JButton("Quit");
		
		this.myGame = new ProjectPanel(appController);
		//myFrame.removeAll();
		
		
		this.add(label);
		this.add(panel);
		panel.add(replay);	
		panel.add(quit);
		
		addListeners(quit, replay);
	}
	
	public void addListeners(JButton quit, JButton replay)
	{
		quit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
				System.exit(0);
			}
		});
		replay.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
				//myGame.closePanel;
				
				ProjectFrame restartFrame = new ProjectFrame(appController);
				myFrame.dispose();
				myGame.restart();
				
			}
		});
	}
}
