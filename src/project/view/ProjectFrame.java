package project.view;

import project.controller.ProjectController;
import javax.swing.JFrame;

public class ProjectFrame extends JFrame
{
	private ProjectController appController;
	private ProjectPanel appPanel;
	
	/**
	 * creates the ChatFrame, calls setupframe
	 * @param ChatbotController appController
	 */
	public ProjectFrame(ProjectController appController)
	{
		super();
		this.appController = appController;
		appPanel = new ProjectPanel(appController);
		setupFrame();
	}
	
	/**
	 * Sets the settings for the chatframe
	 */
	private void setupFrame()
	{	
		this.setContentPane(appPanel);
		this.setSize(600,600);
		this.setTitle("Slider!");
		this.setResizable(false);
		this.setVisible(true);
	}
	
	/**
	 * Getter for the appController
	 * @return
	 */
	public ProjectController getBaseController()
	{
		return(appController);
	}
}
