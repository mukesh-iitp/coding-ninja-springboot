package com.example.TuneIn;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class TuneInApplication {

    public static void main(String[] args) {

        /*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

		 Tasks:
		1. Fetch context from ApplicationContext.xml and initiate Scanner.
		2. Fetch User details from Console.
		3. Get the required bean from context.
		4. Get the songs from Console and add them to the playlist
		5. Display the playlist reference Id
		6. Display the list of songs with their reference Id
		 */
    	
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Wecome to Music Playlist Application!");
    	System.out.println("What is your name?");
    	String userName = scanner.nextLine();
    	System.out.println("What is your age?");
    	int userAge = scanner.nextInt();
    	
    	User myUser = (User) context.getBean("myUser");
    	myUser.setUserDetail(userName, userAge);
    	
    	System.out.println("Do you want to add Songs to the Playlist?"
    			+ "\n1. Yes"
    			+ "\n2. No");
    	int addSong = scanner.nextInt();
    	if(addSong == 1) {
    		while(true) {
    			/* My wrong code
    			//Playlist playlist= (Playlist) context.getBean("myPlaylist"); //wrong
    			Playlist playlist = myUser.getPlaylist();
    			//Song song= (Song) context.getBean("mySong"); //wrong
    			//Song song = (Song) playlist.getPlaylistSongs();
    			System.out.println("Enter name of the song:");
    			String songName=scanner.nextLine();
    			//playlist.addSong(song);
    			 * 
    			 */
    			scanner.nextLine();
    			System.out.println("Enter name of the song");
    			String songName=scanner.nextLine();
    			Song song = (Song) context.getBean("mySong");
    			song.setName(songName);
    			Playlist playlist = myUser.getPlaylist();
    			playlist.addSong(song);
    			
    			System.out.println("Do you want to add Songs to the Playlist?"
    	    			+ "\n1. Yes"
    	    			+ "\n2. No");
    			if(scanner.nextInt() == 2)
    				break;
    			
        	}
    		
    		System.out.println("Your Playlist with reference Id: " + myUser.toString().substring(26) + " is Ready!!");
    		for(Song song : myUser.getPlaylist().getPlaylistSongs()) {
    			System.out.println("Song Name: "+song.getSongName()+"\t Reference Id: "+song.toString().substring(26));
    		}
    		
    	}
    	else if(addSong==2){
    		System.out.println("exiting application...");
    		//return;
    	}
    	
    	//try to check with invalid input and retry
    }

}
