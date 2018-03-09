package project.view;

import project.controller.ProjectController;
import project.model.APButton;
import project.model.Slider;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.*;

import javax.swing.JScrollPane;

public class ProjectPanel extends JPanel
{
	private ProjectController appController;
	private GridLayout appLayout;
	
	private APButton buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonTen;
	private APButton buttonEleven, buttonTwelve, buttonThirteen, buttonFourteen, buttonFifteen, buttonSixteen;
	
	int[][] sliderArray = new int[4][4];
	
	Slider slide;
	
	/**
	 * Creator of the ProjectPanel
	 * @param appController
	 */
	public ProjectPanel(ProjectController appController)
	{
		super();
		this.appController = appController;
		
		this.slide = new Slider();
		
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
		setupLayout();
		slide.setupSlider();
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
	
	/**
	 * Sets up the panel, adding buttons and other features
	 */
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
		
		buttonSixteen.setEnabled(false);
	}
	
	/**
	 * Provides formatting for parts setup
	 */
	private void setupLayout()
	{
		
	}
	
	/**
	 * Adds listeners to various parts including the chat button, check button, input field, and passButtons
	 */
	private void setupListeners(APButton button)
	{		
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent click)
			{
				if(button.getButtonNumber() == 1)
				{
					if(buttonTwo.isEnabled() == false)
					{
						buttonTwo.setEnabled(true);
						buttonOne.setEnabled(false);
					}
				}
					slide.slideTile(button);
				
			}
		});
	}
}
