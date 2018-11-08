import java.awt.Color;
public class SeamCarver {
	// create a seam carver object based on the given picture
	int width;
	int height;
	Picture pic;
	public SeamCarver(Picture picture) {
		pic = picture;
		width = pic.width();
		height = pic.height();
	}
	// current picture
	public Picture picture() {
		return null;
	}
	// width of current picture
	public int width() {
		return width;
	}

	// height of current picture
	public int height() {
		return height;
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		if(x == 0 || x == width() - 1 || y == 0 || y == height() - 1) {
			return 1000;
		}
		return Math.sqrt(calculatesquare(pic.get(x - 1,y), pic.get(x + 1, y))
		+ calculatesquare(pic.get(x, y - 1), pic.get(x, y + 1)));
	}
	public double calculatesquare(Color one, Color two) {
		double r = one.getRed() - two.getRed();
		double g = one.getGreen() - two.getGreen();
		double b = one.getBlue() - two.getBlue();
				return r * r + g * g + b * b;
	}
	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}