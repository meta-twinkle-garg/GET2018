package virtualcommandprompt;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
/**
 * This is the implementation of virtual command prompt..!!
 * It contains methods for following commands:
 * 1. mkdir
 * 2. bk (back)
 * 3. ls 
 * 4. find
 * 5. cd
 * @author Twinkle garg
 */
public class VirtualCommandPrompt {

    static Directory root;
    static Directory currentDirectory;
    static Directory directoryFound;

    /**
     * This method creates a directory and add it in its parent's folder list 
     * @param name
     * @param parent 
     */
    public static void mkdir(String name, Directory parent) {
        Directory directory = new Directory(parent, name);
        parent.addFolder(directory);
        Date date=new Date();
        directory.setTimestamp(date);
    }

    /**
     * This method change current directory to specified directory
     * @param name of directory
     */
    public static void changeDirectory(String name) {
        List<Directory> list = currentDirectory.getSubFolders();
        for (Directory directory : list) {
            if (directory.getName().equals(name)) {
                currentDirectory = directory;
                return;
            }
        }
        System.out.println("No such folder in current directory");
    }

    /**
     * This method displays the prompt starting from root
     * @param directory
     * @return prompt
     */
    public static String getPrompt(Directory directory) {
        String prompt = directory.getName();
        while (directory.getParent() != null) {
            prompt = directory.getParent().getName() + "/" + prompt + "";
            directory = directory.getParent();
        }
        return prompt;
    }

    /**
     * This method prints all the sub folders of current directory
     */
    public static void ls() {
        List<Directory> listOfFolders = currentDirectory.getSubFolders();
        for (Directory directory : listOfFolders) {
            System.out.print(directory.getTimestamp());
            System.out.println(directory.getName());
        }
    }

    /**
     * This method searches for the given directory
     * @param directoryName
     * @param current
     * @return true if found
     */
    public static boolean find(String directoryName, Directory current) {
        if (current.getName().equals(directoryName)) {
            directoryFound = current;
            return true;
        }
        List<Directory> list = current.getSubFolders();
        for (Directory directory : list) {
            find(directoryName, directory);
        }
        return false;
    }
    
    /**
     * This method changes current directory to parent directory
     */
    public static void back(){
        if(currentDirectory.getParent()!=null){
            currentDirectory=currentDirectory.getParent();
        }else{
            System.out.println("Cant go back further..!!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Virtual Commnd Prompt..!!!");
        root = new Directory(null, "R:");
        currentDirectory = root;
        while (true) {
            System.out.print(getPrompt(currentDirectory) + "/>");
            String fullCommand = sc.nextLine();
            String[] command = fullCommand.split(" ");
            switch (command[0]) {
                case "mkdir":
                    mkdir(command[1], currentDirectory);
                    break;
                case "cd":
                    changeDirectory(command[1]);
                    break;
                case "ls":
                    ls();
                    break;
                case "bk":
                    back();
                    break;
                case "find":
                    if (find(command[1], currentDirectory)) {
                        System.out.println("Directory found..!! at " + getPrompt(directoryFound));
                    }else{
                        System.out.println("Not found..!!");
                    }
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("wrong command");
            }
        }
    }
}
