package bytehala;

public class Skiing {
	
	int[][] field;
	int w;
	int h;
	
	int longestRide;
	int highestDrop;
	
	public Skiing(int w, int h, int[][] field) {
		this.w = w;
		this.h = h;
		this.field = field;
	}
	
	public void solve() {
		for(int y = 0; y < h; y++) {
			for(int x = 0; x < w; x++) {
				if(isPeak(x, y)) {
					skiFrom(x, y, 1, 0);
				}
			}
		}
	}
	
	private void skiFrom(int x, int y, int currentRideLength, int currentDrop) {
		if (canGoNorth(x, y)) {
			skiFrom(x, y-1, currentRideLength + 1, currentDrop + getAltitude(x, y) - getAltitude(x, y-1));
		}
		if (canGoSouth(x, y)) {
			skiFrom(x, y+1, currentRideLength + 1, currentDrop + getAltitude(x, y) - getAltitude(x, y+1));
		}
		if (canGoEast(x, y)) {
			skiFrom(x+1, y, currentRideLength + 1, currentDrop + getAltitude(x, y) - getAltitude(x+1, y));
		}
		if (canGoWest(x, y)) {
			skiFrom(x-1, y, currentRideLength + 1, currentDrop + getAltitude(x, y) - getAltitude(x-1, y));
		}
		
		if(currentRideLength >= longestRide && currentDrop > highestDrop) {
			longestRide = currentRideLength;
			highestDrop = currentDrop;
		}
	}
	
	private int getAltitude(int x, int y) {
		return field[y][x];
	}

	boolean isPeak(int x, int y) {
		return 	(y == 0 || getAltitude(x, y) > getAltitude(x, y-1)) &&// north
				(y == h - 1 || getAltitude(x, y) > getAltitude(x, y+1)) && //south
				(x == w - 1 || getAltitude(x, y) > getAltitude(x+1, y)) && // east
				(x == 0 || getAltitude(x, y) > getAltitude(x-1, y));// west;
	}
	
	private boolean canGoNorth(int x, int y) {
		return y > 0 && getAltitude(x, y) > getAltitude(x, y-1);
	}
	
	boolean canGoSouth(int x, int y) {
		return y < h-1 && getAltitude(x, y) > getAltitude(x, y+1);
		
	}
	
	boolean canGoEast(int x, int y) {
		return x < w-1 && getAltitude(x, y) > getAltitude(x+1, y);
		
	}
	
	boolean canGoWest(int x, int y) {
		return x > 0 && getAltitude(x, y)  > getAltitude(x-1, y);
	}
	
	public int getLongestRide() {
		return longestRide;
	}
	
	public int getHighestDrop() {
		return highestDrop;
	}

}
