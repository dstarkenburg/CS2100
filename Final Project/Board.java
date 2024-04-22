/**
Duncan Starkenburg
CS 2100, Final Project
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public abstract class Board
{
   private ArrayList<ArrayList<CellStatus>> layout;
   private ArrayList<Move> aircraftLoc;
   private ArrayList<Move> subLoc;
   private ArrayList<Move> cruiserLoc;
   private ArrayList<Move> destroyerLoc;
   private ArrayList<Move> battleshipLoc;
   private Fleet fleet;
   public static final int SIZE = 100;

   private void setTiles(ArrayList<Move> movesAr, CellStatus newStatus)
   {
      for (int i = 0; i < movesAr.size(); i++){
         layout.get(movesAr.get(i).row()).set(movesAr.get(i).col(), newStatus);
      }
   }
  
   private ArrayList<Move> getTiles(String start, String end, String type)
   {
      Move startMove = new Move(start);
      Move endMove = new Move(end);
      int shipSize = switch(type)
      {
         case "A" -> 5;
         case "B" -> 4;
         case "C" -> 3;
         case "D" -> 2;
         default -> 3;
      };
      
      ArrayList<Move> output = new ArrayList<Move>(shipSize);
      
      if (startMove.row() < endMove.row())
      {
         if (startMove.col() == endMove.col())
         {
            for (int i = 0; i < shipSize; i++)
            {
               output.add(new Move(startMove.row() + i, startMove.col()));
            }
         }
         else
         {
            System.out.println("Error parsing board file!");
            System.exit(0);
         }
      }
      else if (startMove.row() > endMove.row())
      {
         if (startMove.col() == endMove.col())
         {
            for (int i = 0; i < shipSize; i++)
            {
               output.set(i, new Move(endMove.row() + i, startMove.col()));
            }
         }
         else
         {
            System.out.println("Error parsing board file!");
            System.exit(0);
         }
      }
      else
      {
         if (startMove.col() < endMove.col())
         {
            for (int i = 0; i < shipSize; i++)
            {
               output.add(new Move(startMove.row(), startMove.col() + i));
            }
         }
         else if (startMove.col() > endMove.col())
         {
            for (int i = 0; i < shipSize; i++)
            {
               output.add(new Move(startMove.row(), endMove.col() + i));
            }
         }
         else
         {
            System.out.println("Error parsing board file!");
            System.exit(0);
         }
      
      }
      return output;
      
   }
   
   public Board(String filename)
   {
      this.fleet = new Fleet();
      this.layout = new ArrayList<ArrayList<CellStatus>>(10);
      for(int i = 0; i < 10; i++)
      {
         layout.add(new ArrayList<CellStatus>(10));
         for(int j = 0; j < 10; j++)
         {
            layout.get(i).add(CellStatus.NOTHING);
         }
      }
      try
      {
            File txt = new File(filename);
            Scanner file = new Scanner(txt);
            String currLine;
            
            for (int i = 0; i < 5; i++)
            {
               currLine = file.nextLine();
               String[] line = currLine.split(" ");
               String type = line[0];
               String start = line[1];
               String end = line[2];
               ArrayList<Move> temp = getTiles(start, end, type);
               if (type.equals("A")){ aircraftLoc = temp;}
               else if (type.equals("B")){ battleshipLoc = temp;}
               else if (type.equals("C")){ cruiserLoc = temp;}
               else if (type.equals("D")){ destroyerLoc = temp;}
               else {subLoc = temp;}

               CellStatus typeEnum = switch(type)
               {
                  case "A" -> CellStatus.AIRCRAFT_CARRIER;
                  case "B" -> CellStatus.BATTLESHIP;
                  case "C" -> CellStatus.CRUISER;
                  case "D" -> CellStatus.DESTROYER;
                  default -> CellStatus.SUB;
               };
               setTiles(temp, typeEnum);
            }
            
            file.close();
      
      }
      catch (IOException e) 
      {
            System.out.println("Could not find board file(s)!");
            System.exit(0);
      }
   }
   
   public CellStatus applyMoveToLayout(Move m)
   {
      CellStatus curr = layout.get(m.row()).get(m.col());
      switch(curr)
      {
         case SUB:
            if (fleet.updateFleet(ShipType.ST_SUB))
            {
               setTiles(subLoc, CellStatus.SUB_SUNK);
               return CellStatus.SUB_SUNK;
            }
            else
            {
               layout.get(m.row()).set(m.col(), CellStatus.SUB_HIT);
               return CellStatus.SUB;
            }         
         case BATTLESHIP:
            if (fleet.updateFleet(ShipType.ST_BATTLESHIP))
            {
               setTiles(battleshipLoc, CellStatus.BATTLESHIP_SUNK);
               return CellStatus.BATTLESHIP_SUNK;
            }
            else
            {
               layout.get(m.row()).set(m.col(), CellStatus.BATTLESHIP_HIT);
               return CellStatus.BATTLESHIP;
            } 
         case AIRCRAFT_CARRIER:
            if (fleet.updateFleet(ShipType.ST_AIRCRAFT_CARRIER))
            {
               setTiles(aircraftLoc, CellStatus.AIRCRAFT_CARRIER_SUNK);
               return CellStatus.AIRCRAFT_CARRIER_SUNK;
            }
            else
            {
               layout.get(m.row()).set(m.col(), CellStatus.AIRCRAFT_CARRIER_HIT);
               return CellStatus.AIRCRAFT_CARRIER;
            }
         case CRUISER:
            if (fleet.updateFleet(ShipType.ST_CRUISER))
            {
               setTiles(cruiserLoc, CellStatus.CRUISER_SUNK);
               return CellStatus.CRUISER_SUNK;
            }
            else
            {
               layout.get(m.row()).set(m.col(), CellStatus.CRUISER_HIT);
               return CellStatus.CRUISER;
            }
         case DESTROYER:
            if (fleet.updateFleet(ShipType.ST_DESTROYER))
            {
               setTiles(destroyerLoc, CellStatus.DESTROYER_SUNK);
               return CellStatus.DESTROYER_SUNK;
            }
            else
            {
               layout.get(m.row()).set(m.col(), CellStatus.DESTROYER_HIT);
               return CellStatus.DESTROYER;
            }
         default:
            layout.get(m.row()).set(m.col(), CellStatus.NOTHING_HIT);
            return CellStatus.NOTHING;
      }
   }
   
   public boolean moveAvailable(Move m)
   {
      switch(layout.get(m.row()).get(m.col()))
      {
         case CRUISER:
            return true;
         case AIRCRAFT_CARRIER:
            return true;
         case DESTROYER:
            return true;
         case BATTLESHIP:
            return true;
         case SUB:
            return true;
         case NOTHING:
            return true; 
         default:
            return false;
      }
   }
   
   public ArrayList<ArrayList<CellStatus>> getLayout()
   {
      return layout;
   }
   
   public Fleet getFleet()
   {
      return fleet;
   }
   
   public boolean gameOver()
   {
      return fleet.gameOver();
   }
}