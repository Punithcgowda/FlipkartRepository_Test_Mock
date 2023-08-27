package Kalpanemam_Questons;

import java.util.LinkedHashSet;

public class C_RemoveDuplicateWords_03 
{
	public static void main(String[] args) 
	{
		String s="i know What i dont know";
		String[] s1=s.split(" ");
		
		for(int i=0;i<s1.length;i++)
		{
		   String s3=s1[i];
		   for(int j=i+1;j<s1.length;j++)
		   {
			  if(s3.equals(s1[j]))
			  {
				  s1[j]="Dup";
			  }
		   }
		}
		
		for(int j=0;j<s1.length;j++)
		{
//			System.out.print(s1[j]+" ");
//		}
			if(s1[j] !="Dup")
			{
				System.out.print(s1[j]+" ");
			}
		}
		System.out.println();
		
		//Another Method to solve
		String st="i know What i dont know";
		String[] sta=st.split(" ");
		LinkedHashSet<String> l= new LinkedHashSet<String>();
		for(int i=0;i<sta.length;i++)
		{
			l.add(sta[i]);
		}
		for(String st2 :l)
		{
			System.out.print(st2+" ");
		}
		
	}
}


