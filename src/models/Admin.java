package models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

public class Admin extends User {
	private List<Map<String, String>> users;
	  
	public Admin (String username, String password) {
		super(username, password);
		this.users = new ArrayList<>();
	}
	
	public void add(String username, String password) {
	    Map<String, String> userMap = new HashMap<>();
	    userMap.put(username, password);
	    users.add(userMap);
	    System.out.println("New user added: "+ username);
	}
		  
	public void remove(String username) {
		boolean found = false; 
	    Iterator<Map<String, String>> iterator = users.iterator();
	    while (iterator.hasNext()) {
	    	Map<String, String> userMap = iterator.next();
	        if (userMap.containsKey(username)) {
	        	iterator.remove();
	        	found = true;
			    System.out.println(username + " user removed.");
			    break;
	        }
	    }
		if(!found) {
		    System.out.println(username + " user not found");
		}
	}
		  
	public void update (String username, String password) {
		boolean found = false;
	    for(Map<String, String> userMap : users) {
	    	if(userMap.containsKey(username)) {
	    		userMap.put(username, password);
	    		found = true;
	    		System.out.println(username + " user updated.");
	    		break;
	    	}
	    }
		    
		if(!found) {
		    System.out.println(username + " user not found");
		}	    
	}
		  
	public void listUsers() {
		System.out.println("All users: ");
		for (Map<String, String> userMap : users) {
			for (Map.Entry<String, String> entry : userMap.entrySet()) {
				System.out.println("User name: " + entry.getKey());
		    }
		}
	}  

}

