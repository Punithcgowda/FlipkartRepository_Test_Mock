package Kalpanemam_Questons;

public class B_RemoveDupfromString_Q2 
{
	public static void main(String[] args) 
	{
	
	String s="Welcome to expleo";
//	s.replace('e','a');
//	System.out.print(s.replace('e','a'));
	for(int i=0;i<s.length();i++)
	{
		char c=s.charAt(i);
		System.out.println(c);
		for(int j=i+1;j<s.length();j++)
		{
			if(c==s.charAt(j))
			{
				s=s.replace(s.charAt(j),':');
			}
			
		}
	}
	System.out.println(s);
	for(int i=0;i<s.length();i++)
	{
		if(s.charAt(i) !=':')
		{
			System.out.print(s.charAt(i));
		}
	}

	}
	
	

}
