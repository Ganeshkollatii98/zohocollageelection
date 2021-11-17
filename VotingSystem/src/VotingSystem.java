
import java.util.*;
import java.util.Map.Entry;
public class VotingSystem {
         
         static List<String> candidates=new LinkedList<String>(Arrays.asList("Ram","Leela","Sitha"));
	     static Queue<Integer> voters=new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
         static Map<String, Integer> votingStatus=new HashMap<String,Integer>();
         static List<Integer> AlreadyVoter=new LinkedList<Integer>();
     
       public static void initilization() {
        	  for(String person:candidates)
        	  {
        		  votingStatus.put(person, 0);
        	  }
         }
        
         public static boolean CheckAlreadyVoted_OrNot(int voterId) {
        	 boolean flag=false;
        	 if(AlreadyVoter.contains(voterId))
        	 {
        		flag=true; 
        	 }
        	 return flag;
         }
     public static void voteToCandidate(int voterId,String candidateName) {
        	 
        		 if(voters.contains(voterId))
           	     {
           		  if(votingStatus.containsKey(candidateName))
           		  {
           			  votingStatus.put(candidateName, votingStatus.get(candidateName)+1);
           			   AlreadyVoter.add(voterId);
            		 System.out.println("------------You Voted Successfully--------------");
            	 
           		  }
           		  else {
           			  System.out.println("---You Entered Wrong Candidate Name again do voting ---");
           		  }
           	     }
        		
        	 
        	  
         }
         
      public static void PrintListCandidates() {
        	 int count =1;
        	 System.out.println("-------------------------------------");
        	 for(String candidate:candidates)
        	 {
        		System.out.println(count+"."+candidate); 
        		count++;
        	 }
        	 System.out.println("-------------------------------------");
         }

    public static void GettingResults() {

        	 List<Map.Entry<String, Integer>> list=new LinkedList<Map.Entry<String,Integer>>(votingStatus.entrySet());
  	        
  	        //sort the list
  	        Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {
  	        	public int compare(Map.Entry<String, Integer> pair1,Map.Entry<String, Integer> pair2) {
  	        		return (pair2.getValue()).compareTo(pair1.getValue());
  	        	}
 				});  
  	        
  	        int max=0;
  	        String winner="";
  	        // finding the candidate with maximum votes
  	        for(Entry<String, Integer> pair:list)
  	        {
  	              if(pair.getValue()>max)
  	              {
  	            	  max=pair.getValue();
  	            	  winner=pair.getKey();
  	              }
  	        }
  	        boolean flag=false;
  	        // check weather there are more then one candidate with maximum votes      
  	        for(Entry<String, Integer> pair:list)
  	        {
  	            if(pair.getValue()==max && !winner.equals( pair.getKey()))
  	            {
  	            	
  	            		flag=true;
  	            		break;
  	           }
  	        }
  	              if(!flag) {
  	            	  System.out.println("---------------------------");
  	            	  System.out.println("The Current Winner Is: "+winner +":"+votingStatus.get(winner));
  	            	  System.out.println("---------------------------");
  	              }
  	              else {
  	            	    List<Integer> duplicateVotes=new ArrayList<Integer>();
  	            	    List<String> candidates=new ArrayList<String>();
  	            	    duplicateVotes.add(list.get(0).getValue());

  	            	    candidates.add(list.get(0).getKey());
  	            	    

  	            	  int count=0;
  	            	    for(Entry<String,Integer> pair:list)
  	            	    {
  	            	    	if(count>0) {
  	            	    	     if(duplicateVotes.contains(pair.getValue())) {
  	            	    	    	duplicateVotes.add(pair.getValue());
  	            	    	    	candidates.add(pair.getKey());
  	            	    	     }	
  	            	    	}
  	            	    	count++;
  	            	    }
  	            	    String res="";
  	            	    for(String c:candidates)
  	            	    {
  	            	    	res+=c+"-"+duplicateVotes.get(0)+" ";
  	            	    	
  	            	    }
  	            	    System.out.println("Candidates with"+res+" have same majority of votes (We will re-elect them) ");
  	              }
  	        
  	        
         }
       
         public static void displayCandidateWiseResults() {

 	        List<Map.Entry<String, Integer>> list=new LinkedList<Map.Entry<String,Integer>>(votingStatus.entrySet());
 	        
 	        //sort the list
 	        Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {
 	        	public int compare(Map.Entry<String, Integer> pair1,Map.Entry<String, Integer> pair2) {
 	        		return (pair2.getValue()).compareTo(pair1.getValue());
 	        	}
				});  
          	 System.out.println("");
          	 System.out.println("--------------------------------");
        	for(Entry<String, Integer> pair:list)
        	{
        		

           	 System.out.println(pair.getKey() +" "+pair.getValue());
           	
        	}
        	 System.out.println("---------------------------------");
        	        
         }
         
         
         public static void HowManyMembersVotted() {
        	 System.out.println("------------Already Votted ids-------------");
        	 for(int id:AlreadyVoter)
        	 {
        		 System.out.print("|"+id);
        	 }
        	 System.out.println("");
        	 System.out.println("These Many Members Votted ->" +AlreadyVoter.size());
        	 System.out.println("--------------------------------------------");
        	 
         }
         
         
                        
}  
