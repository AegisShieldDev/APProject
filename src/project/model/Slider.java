package project.model;

public class Slider
{
	Boolean[][] sliderArray = new Boolean[4][4];
			
	public Slider()
	{
		setupSlider();
	}
	
	public void setupSlider()
	{
		int fill = 1;
		for (int row = 0; row < sliderArray.length; row++)
		{
			for (int col = 0; col < sliderArray[0].length; col++)
			{
				if(fill != 16)
				{
					sliderArray[row][col] = true;
				}
				else
				{
					sliderArray[row][col] = false;
				}
					  
				fill++;
				  
				System.out.print(sliderArray[row][col] + " ");
			}
		}
	}
	
	public void slideTile(APButton button)
	{
		System.out.println("You clicked button " + button.getButtonNumber());
		
		int[] sur = button.getSurroundingButtons(button);
		Boolean[] enabledButtons = button.getEnabledButtons(button);
		
		for(int i = 0; i < 4; i++)
		{
			System.out.println("The surrounding buttons are " + sur[i]);
			System.out.println("The surrounding buttons are " + enabledButtons[i]);
		}
		
		
	}
	
	public Boolean isSurroundEnabled(APButton button)
	{
		int[] sur = button.getSurroundingButtons(button);
		if(button.getButtonPosition() == 1)
		{
			if(sliderArray[1][2] == false)
			{
				return false;
			}
		}
		if(button.getButtonPosition() == 11)
		{
			if(sliderArray[4][4] == false)
			{
				System.out.println("FAE OSFJASO");
				return false;
			}
		}
		
		return true;
	}
}
