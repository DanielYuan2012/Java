import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DeleteJavaAnotations {		

   public static void deleteAnotations(FileReader reader,FileWriter writer) 
   {		
	
	Boolean slash_star = false;
	Boolean slash_slash = false;
	Boolean quotation = false;
	Character pre = null;
	Character cur = null;
		
	int flag = 0;	
	try{		
	  while((flag=reader.read()) != -1){		
		pre = cur;		
		cur = (char) flag;		
		
		if(slash_star==false && slash_slash == false && cur =='"'){
			quotation = true;
			writer.write(flag);
			continue;			
		}		
		if(quotation == true){
			if(cur =='"'){
				quotation = false;
			}
			writer.write(flag);
			continue;
		}		
		if(slash_slash==false &&cur == '*' && pre == '/'){
			slash_star = true;
			continue;								
		}		
		if( slash_star == true){				
			if(cur == '/' && pre == '*'){					
			slash_star = false;
			}				
			continue;				
		}		
		if(cur == '/' && pre == '/'){
			slash_slash = true;
			continue;
		}		
		if(slash_slash == true ){
			if( cur=='\n'){					
			slash_slash = false;
			}				
			continue;				
		}
		if(cur!='/' ){
			writer.write(flag);					
		}
		else
		{
			continue;
		}	
	 }
	}
	catch(IOException e){		
		e.printStackTrace();
	}
	finally{
		if(writer != null){
			try{
				writer.flush();
			    writer.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		if(reader != null){
			try{
				reader.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}		
	}	
  }




    public static void main(String[] args) throws IOException{
    	
    	FileReader reader = new FileReader("CopyOfanagrams1.java");
	FileWriter writer = new FileWriter("CopyOfanagrams1deleteanotations.java");
	deleteAnotations(reader, writer);
    
    
    }
    
    
    
    //modified
	
	
	
	
	

}

