
import java.util.*;
public class App {
    public static boolean AdminValidations(String username,String password)
    {
    	boolean flag=false;
    	if(username.equals("Ganesh98") && password.equals("Gani@1998"))
    	{
    	      return true;	
    	}
    	return flag; 
    }
	public static void main(String[] args) {
		   //initiliztion
		
		   VotingSystem.initilization();
		   boolean flag=true;
		   while(flag) {
			   Scanner scan=new Scanner(System.in);
			   System.out.println("1.Admin \n2.voter \n3.exit");
			   System.out.println("Enter your choice");
			   int choice=scan.nextInt();
			   switch(choice){
			   case 1:{
				   //admin section
				   System.out.print("Enter username :");
				   String username=scan.next();
				   System.out.println("Enter Password :");
				   String password=scan.next();
				   if(AdminValidations(username,password)) {
					   boolean admin=true;
					   while(admin) {
						   System.out.println("1.Candidates with votes \n2.Get Winner of Voting \n3.exit");
						   System.out.println("Enter The Choice....");
						   int admin_choice=scan.nextInt();
						   switch(admin_choice) {
						   case 1:{
							   //list of results
							   VotingSystem.displayCandidateWiseResults();
							   VotingSystem.HowManyMembersVotted();
							   break;
						   }
						   case 2:{
							   //get winner
							   VotingSystem.GettingResults();
							   break;
						   }
						   case 3:{
							    //exit admin
							    admin=false;
							    break;
						   }
						   default:{
							   System.out.println("Not a  valid admin choice");
							   break;
						   }
						   }
					   }
					   
				   }
				   else {
					   System.out.println("Username & Password Not Matched");
				   }
				   break;
			   }
			   case 2:{
				   //voter section
				   boolean voter=true;
				   while(voter) {
					   System.out.println("1.List of Candidates \n2.To Vote \n3.Exit");
					   System.out.println("Enter The choice");
					   int voter_choice=scan.nextInt();
					   switch(voter_choice) {
					   case 1:{
						   // List of candidates
						   VotingSystem.PrintListCandidates();
						   break;
					   }
					   case 2:{
						   // To vote   
						   System.out.println("Enter The voter id between 1 to 5");
						   
						   try {
							  int voterid=scan.nextInt();
							  boolean status=VotingSystem.CheckAlreadyVoted_OrNot(voterid);
							   if(status)
							   {
								   System.out.println("------Already Voted------");
							   }
							   else if(!status) {
								   
								   System.out.println("Enter the candidate name to vote for:");
								   String candidate_name=scan.next();
								   VotingSystem.voteToCandidate(voterid, candidate_name);
							   }
						   }
						   catch(InputMismatchException e) {
							   System.out.println("You Entred Invalid VoterID");
							   scan.nextLine();
						   }
						   
						  
				
						   break;
					   }
					   case 3:{
						    voter=false; 
						    break;
					   }
					   default:{
						   System.out.println("Not a valid voter choice");
					   }
					   }
				   }
				   
				   break;
			   }
			   case 3:{
				   //exit
				   break;
			   }
			   default:{
				   System.out.println("Enter Valid Choice..");
				   break;
			   }
			   }
			   
		   }
		

	}

}
