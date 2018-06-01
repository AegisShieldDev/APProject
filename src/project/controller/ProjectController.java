package project.controller;

import project.view.ProjectFrame;
import project.model.*;

public class ProjectController
{	
	private ProjectFrame myFrame;
	
	public ProjectController()
	{
		myFrame = new ProjectFrame(this);
	}
	
	public void start()
	{
	}
	
	public ProjectFrame getAppFrame()
	{
		return myFrame;
	}
}
