
import java.util.*;
public class Main {
	
	private static ArrayList<Albums> albums = new ArrayList<>();

    public static void main(String[] args) {

        Albums album = new Albums("Album1","ABC");
        
        
        
        album.addSong("The Hook Up Song",4.5);
        album.addSong("Kala Chasma",3.5);
        album.addSong("Nachho Nachho",5.0);
        album.addSong("Happy New Year",5.0);
        albums.add(album);

        album = new Albums("Album2","XYZ");

        album.addSong("Ole Ole",4.5);
        album.addSong("Tip Tip",3.5);
        album.addSong("Chand Se Parda",4.5);
        album.addSong("Chand Se Parda",4.5);
        album.addSong("Jogi",3.5);

        albums.add(album);

        LinkedList<Songs> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("The Hook Up Song",playList_1);
        albums.get(0).addToPlayList("Nachho Nachho",playList_1);
        albums.get(1).addToPlayList("Ole Ole",playList_1);
        albums.get(1).addToPlayList("Chand Se Parda",playList_1);
        albums.get(1).addToPlayList("Jogi",playList_1);

        play(playList_1);

    }
    

    private static void play(LinkedList<Songs> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Songs> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("This playlist have no song");
        }else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            if(action == 0) {
            	System.out.println("Playlist complete");
                System.out.println("Press 7 to play the song again");
                quit = true;
            }else if(action == 1) {
            	if(!forward){
                    if(listIterator.hasNext()){
                        listIterator.next();
                    }
                    forward = true;
                }
                if(listIterator.hasNext()){
                    System.out.println("Now playing "+listIterator.next().toString());
                }else {
                    System.out.println("no song availble, reached to the end of the list");
                    forward = false;
                }
            }else if(action==2) {
            	if(forward){
                    if (listIterator.hasPrevious()){
                        listIterator.previous();
                    }
                    forward = false;
                }
                if(listIterator.hasPrevious()){
                    System.out.println("Now playing "+listIterator.previous().toString());
                }else {
                    System.out.println("we are the first song");
                    forward = false;
                }
            }else if(action==3) {
            	if(forward){
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                        forward = false;
                    }else {
                        System.out.println("we are at the start of the list");
                    }
                }else {
                    if(listIterator.hasNext()){
                        System.out.println("now playing "+listIterator.next().toString());
                        forward = true;
                    }else {
                        System.out.println("we have reached to the end of list");
                    }
                }
            }else if(action==4) {
            	printList(playList);
            }else if(action==5) {
            	printMenu();
            }else if(action ==6) {
            	 if (playList.size() >0){
                     listIterator.remove();
                     if(listIterator.hasNext()){
                         System.out.println("now playing "+listIterator.next().toString());
                     }
                     else {
                         if(listIterator.hasPrevious())
                         System.out.println("now playing "+listIterator.previous().toString());
                     }
                 }
            }else {
            	
            }
		
//            switch (action){
//
//                case 0:
//                    System.out.println("Playlist complete");
//                    System.out.println("Press 7 to play the song again");
//                    quit = true;
//                    break;
//
//                case 1:
//                    if(!forward){
//                        if(listIterator.hasNext()){
//                            listIterator.next();
//                        }
//                        forward = true;
//                    }
//                    if(listIterator.hasNext()){
//                        System.out.println("Now playing "+listIterator.next().toString());
//                    }else {
//                        System.out.println("no song availble, reached to the end of the list");
//                        forward = false;
//                    }
//                    break;
//                case 2:
//                    if(forward){
//                        if (listIterator.hasPrevious()){
//                            listIterator.previous();
//                        }
//                        forward = false;
//                    }
//                    if(listIterator.hasPrevious()){
//                        System.out.println("Now playing "+listIterator.previous().toString());
//                    }else {
//                        System.out.println("we are the first song");
//                        forward = false;
//                    }
//                    break;
//
//                case 3:
//                    if(forward){
//                        if(listIterator.hasPrevious()){
//                            System.out.println("Now playing "+listIterator.previous().toString());
//                            forward = false;
//                        }else {
//                            System.out.println("we are at the start of the list");
//                        }
//                    }else {
//                        if(listIterator.hasNext()){
//                            System.out.println("now playing "+listIterator.next().toString());
//                            forward = true;
//                        }else {
//                            System.out.println("we have reached to the end of list");
//                        }
//                    }
//                    break;
//
//                case 4:
//                    printList(playList);
//                    break;
//                case 5:
//                    printMenu();
//                    break;
//                case 6:
//                    if (playList.size() >0){
//                        listIterator.remove();
//                        if(listIterator.hasNext()){
//                            System.out.println("now playing "+listIterator.next().toString());
//                        }
//                        else {
//                            if(listIterator.hasPrevious())
//                            System.out.println("now playing "+listIterator.previous().toString());
//                        }
//                    }
//                    
//
//            }
            
            
        }
        
        while(quit == true) {
        	int action = sc.nextInt();
        	sc.nextLine();
        	if(action == 7) {
        		quit = false;
        		play(playList);
        	}
        	
        }
        
    }
    
    

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song\n"+
                "7 - start again");
    }

    private static void printList(LinkedList<Songs> playList){
        Iterator<Songs> iterator = playList.iterator();
        System.out.println("");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("");
    }
	
}
