package Graphics;

public class TileSheet {
	public Tile[] tiles = new Tile[256];
	
	public Tile getTile(int i) {
		if ( i < tiles.length ) {
			return tiles[i];
		}
		return null;
	}
	
}
