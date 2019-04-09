package com.example.palindromechecker;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity 
{
	// Layout interface
	EditText textEdit;
	TextView textView;
	Button   buttonEnter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		// Attach xml to interface
		textEdit    = findViewById(R.id.text_edit);
		textView    = findViewById(R.id.text_view);
		buttonEnter = findViewById(R.id.button_enter);
		
		// Button click method, check if text entered is palindrome
		buttonEnter.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// If entered text is a palidrome display text else display
				// other text
				if(isPalindrome(textEdit.getText().toString()))
					textView.setText("Palindrome!");
				else
					textView.setText("Not a Palindrome");
			}
		});
		
    }
	
	private boolean isPalindrome(String arg)
	{
		// Init return var
		boolean bool = true;
		
		// Convert arg string to lowercase (easier to check for palindrome)
		arg = arg.toLowerCase();
		
		// Convert arg string to char array (for looping)
		char[] ch = arg.toCharArray();
		
		// Init string for final string check without punctuation or spaces
		String str = "";
		
		// Create string for palindrome (no punc, space)
		for(char c: ch)
			if((c == '!') || (c == '?') || (c == ',') || (c == '.') || (c == ' '))
				continue;
			else
				str += c;
		
		// Finally, check if string is a palindrome
		for(int i=0; i<str.length(); i++)
			if(str.charAt(i) != str.charAt(str.length() - 1 - i))
				bool = false;
				
		return bool;
	}
}
