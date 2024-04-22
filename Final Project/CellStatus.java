/**
 * Used to represent the status of elements on the board.
 * At the start of the game, all cells are initialized to either the name of a ship (AIRCRAFT_CARRIER, BATTLESHIP, etc), 
 * or NOTHING. The same constant name with "_HIT" appended indicates that the ship has been hit on that cell. If a ship is
 * sunk, all cells associate with that ship are changed to their original value with "_SUNK" appended. 
 *
 * The overridden .toString methods return two character strings. The first character is the character displayed in a
 * text interface for the computer's board (hidden from user) and the second character is the character displayed
 * in a text interface for the player's board (so player can see).
 * THIS DOCUMENT WAS WRITTEN BY JACKIE HORTON FOR CS 2100
 */
public enum CellStatus 
{
    AIRCRAFT_CARRIER
    {
        @Override
        public String toString(){ return "oA"; }
    },
    AIRCRAFT_CARRIER_HIT
    {
        @Override
        public String toString(){ return "HX"; }
    },
    AIRCRAFT_CARRIER_SUNK
    {
        @Override
        public String toString(){ return "AX"; }
    },
    BATTLESHIP
    {
        @Override
        public String toString(){ return "oB"; }
    },
    BATTLESHIP_HIT
    {
        @Override
        public String toString(){ return "HX"; }
    },
    BATTLESHIP_SUNK
    {
        @Override
        public String toString(){ return "BX"; }
    },
    CRUISER
    {
        @Override
        public String toString(){ return "oC"; }
    },
    CRUISER_HIT
    {
        @Override
        public String toString(){ return "HX"; }
    },
    CRUISER_SUNK
    {
        @Override
        public String toString(){ return "CX"; }
    },
    DESTROYER
    {
        @Override
        public String toString(){ return "oD"; }
    },
    DESTROYER_HIT
    {
        @Override
        public String toString(){ return "HX"; }
    },
    DESTROYER_SUNK
    {
        @Override
        public String toString(){ return "DX"; }
    },
    SUB
    {
        @Override
        public String toString(){ return "oS"; }
    },
    SUB_HIT
    {
        @Override
        public String toString(){ return "HX"; }
    },
    SUB_SUNK
    {
        @Override
        public String toString(){ return "SX"; }
    },
    NOTHING
    {
        @Override
        public String toString(){ return "oo"; }
    },
    NOTHING_HIT
    {
        @Override
        public String toString(){ return "xx"; }
    }
}
