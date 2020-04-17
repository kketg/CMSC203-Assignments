/**
 * @author Kristofer Ter-Gabrielyan
 *
 */
public class Plot {
	private int x, y, width, depth;

	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}

	/**
	 * @param p
	 */
	public Plot(Plot p) {
		this.x = p.getX();
		this.y = p.getY();
		this.width = p.getWidth();
		this.depth = p.getDepth();
	}

	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	/**
	 * @param plot
	 * @return whether the plots overlap
	 */
	public boolean overlaps(Plot p) {
		int distanceX = p.getX() - x;
		int distanceY = p.getY() - y;
		boolean check = false;
		if ((distanceX < width && distanceY < depth) || (-distanceX > p.getWidth() && -distanceY > p.getDepth())) {
			check = true;
		}
		return check;
	}

	/**
	 * @param plot
	 * @return whether the plot is encompassed
	 */
	public boolean encompasses(Plot p) {
		boolean check = false;
		int endCoordX = x + width;
		int endCoordY = y + depth;
		int pEndCoordX = (p.getX() + p.getWidth());
		int pEndCoordY = (p.getY() + p.getDepth());
		if (p.getX() > x && p.getY() > y && pEndCoordX < endCoordX && pEndCoordY < endCoordY) {
			check = true;
		}
		return check;
	}

	/**
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param depth
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * @return string form
	 */
	public String toString() {
		return "Plot at (" + x + "," + y + ") of width " + width + " and depth " + depth;
	}

}
