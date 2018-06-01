package project.view;

import project.controller.ProjectController;
import javax.swing.JFrame;

public class VictoryFrame extends JFrame
{
	private ProjectController appController;
	private VictoryPanel appPanel;
	
	/**
	 * creates the ChatFrame, calls setupframe
	 * @param ChatbotController appController
	 */
	public VictoryFrame(ProjectController appController)
	{
		super();
		this.appController = appController;
		appPanel = new VictoryPanel(appController, this);
		setupFrame();
	}
	
	/**
	 * Sets the settings for the chatframe
	 */
	private void setupFrame()
	{	
		this.setContentPane(appPanel);
		this.setSize(400,400);
		this.setTitle("Slider!");
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(appController.getAppFrame());
	}
	
	
}
