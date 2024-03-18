/**
* Duncan Starkenburg
* CS 2100, Week 8 Lab
* THIS DOCUMENT WAS WRITTEN BY JACKIE HORTON
* This program creates a list of songs for a playlist
* by reading from a file.
*/

import java.io.*;
import java.util.Scanner;

public class PlayList
{
   public static void main(String[] args) throws IOException
   {
      Scanner input = new Scanner(new File("Classics.txt"));
      String title;
      String artist;
      final int NUM_SONGS = 6;
      // ADD LINES FOR TASK #1 HERE
      Song[] songs = new Song[NUM_SONGS];
      
      // ADD LINES FOR TASK #2 HERE
      int count = 0;
      while (count < NUM_SONGS && input.hasNext())
      {
         title = input.nextLine();
         artist = input.nextLine();
         songs[count] = new Song(title, artist);
         count++;
      }
      
      // ADD LINES FOR TASK #3 HERE
      for (Song song : songs)
      {
         System.out.println(song);      
      }
      input.close();
   }
}
