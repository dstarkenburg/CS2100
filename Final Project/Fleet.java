/**
Duncan Starkenburg
CS 2100, Final Project
*/

public class Fleet
{
   private Ship battleShip;
   private Ship aircraftCarrier;
   private Ship cruiser;
   private Ship sub;
   private Ship destroyer;
   
   public Fleet()
   {
      this.battleShip = new Battleship();
      this.aircraftCarrier = new AircraftCarrier();
      this.cruiser = new Cruiser();
      this.sub = new Sub();
      this.destroyer = new Destroyer();
   }
   
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
   
   public boolean gameOver()
   {
      return battleShip.getSunk() &&
             aircraftCarrier.getSunk() &&
             cruiser.getSunk() &&
             sub.getSunk() &&
             destroyer.getSunk();
   }
}