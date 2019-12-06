package mb;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;


/**
 *
 * @author Nikam
 */
public class ReadFile {
    
   private Scanner input ;
   
	  
	  private  MyQueue Persons [] ;
	  private int jobs[][] ;
	  private  Stack st = new Stack(); 
	  private int matching[] ;

   
   public ReadFile()
   {
       
   }
   
   
    public void openFile()
  {
      try
      {
          input= new Scanner(new File(getClass().getResource("readfile.txt").getFile()));
      }

          

      catch(FileNotFoundException fileNotFound)
      {
         System.err.print("Can't open file...");
         System.exit(1);
      }
  }//
    
    public void readText()
    {
    	int test , n;
       
       
        try {
            while (input.hasNext())
            {
            	test = input.nextInt();
                for(int i =0; i<test ; i++)
                {
                    n = input.nextInt();
                    Persons = new MyQueue[n];
                    jobs = new int[n][n];
                    matching =new int[n];
                    Arrays.fill(matching, -1);
                    
                    for(int j=n; j>0;j--){
                        
                        st.push(new Integer(j));
                      

                    }
                    for(int j=0 ; j<n ; j++)
                    {
                    	 Persons[j] = new MyQueue();
                        for(int k=0; k<n ; k++){
                        int temp = input.nextInt();
                      
                      
                        Persons[j].enqueue(temp);
                        }


                    }

                    for(int j=0 ; j<n ; j++)
                    {
                        int first = 1;
                        for(int k = 0;k<n; k++)
                        {

                        int temp = input.nextInt();
                        jobs[j][temp-1] = first;
                        first ++;
                        }

                    }
                   
                    
                    ////////
                    while(!st.empty())
                    {
                        Object obj = st.pop();
                        int person = Integer.parseInt(obj.toString());
                        int job =Persons[person-1].dequeue();
                        if(matching[job-1]== -1)
                        {
                        	matching[job-1] = person;
                        	
                        }
                        else{
                        	int priority = jobs[job-1][person-1 ];
                        	int currentPerson = matching[job-1];
                        	if(priority<jobs[job-1][currentPerson-1])
                        	{
                        		st.push(new Integer(currentPerson));
                        		matching[job-1] = person;
                        	}
                        	 
                        	
                        	
                        }//end else
                        
                    }//end while
                    // print output
                   print(n,i);

                }
            }
           
            
        }
        
         catch(NoSuchElementException elementException)
         {
             System.err.println("File improperly formed.");
             input.close();
             System.exit(1);
            
         }
         
         catch(IllegalStateException stateException)
         {
             System.err.println("Error reading from file .");
             System.exit(1);
             
         }
        
    }
    //the method that sets Arraylist alphabets 
   
    
    public void print(int n,int i)
    {
    	 System.out.printf("#%d\n",i+1);
         for(int j=0; j<n ; j++)
          	
          	System.out.printf("%d ",matching[j]);
         System.out.println("\n");

        
    }
    
        
      public void closeFile()
  {
      if(input!=null)
          input.close();
          
  }
   
    
}
 