/**
Duncan Starkenburg
CS 2100, Final Project
*/

public class Fleet
{
   // Declare private ship memebers
   private Ship battleShip;
   private Ship aircraftCarrier;
   private Ship cruiser;
   private Ship sub;
   private Ship destroyer;
   
   /**
   * Constructor that initializes ship fields
   */
   public Fleet()
   {
      this.battleShip = new Battleship();
      this.aircraftCarrier = new AircraftCarrier();
      this.cruiser = new Cruiser();
      this.sub = new Sub();
      this.destroyer = new Destroyer();
   }
   
   /**
   * Method that takes in a ship type and 
   * informs the respective ship that it is hit.
   * If sunk, return true, otherwise false.
   * @param s ship to inform of hit
   * @return  true if ship sunk, false otherwise.
   */
   public boolean updateFleet(ShipType s)
   {
      Ship ship = switch(s)
      {
         case ST_AIRCRAFT_CARRIER -> this.aircraftCarrier;
         case ST_BATTLESHIP -> this.battleShip;
         case ST_CRUISER -> this.cruiser;
         case ST_DESTROYER -> this.destroyer;
         case ST_SUB -> this.sub;
         default -> null;
      };
      return ship.hit();
   }
   
   /**
   * gameOver method returns gameOver boolean
   * @return Returns true if all ships have been
   *         sunk, returns false if not.
   */
   public boolean gameOver()
   {
      return battleShip.getSunk() &&
             aircraftCarrier.getSunk() &&
             cruiser.getSunk() &&
             sub.getSunk() &&
             destroyer.getSunk();
   }
}