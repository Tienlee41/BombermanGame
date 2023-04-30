package uet.oop.bomberman.graphics;

import uet.oop.bomberman.utils.PathFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * Tất cả sprite (hình ảnh game) được lưu trữ vào một ảnh duy nhất
 * Class này giúp lấy ra các sprite riêng từ 1 ảnh chung duy nhất đó
 */
public final class SpriteSheet extends Image {

	public static SpriteSheet tiles = new SpriteSheet("/textures/classic.png", 256);
	private final String path;
	
	public SpriteSheet(String path, int size) {
		super(size);
		this.path = path;

		this.load();
	}
	
	private void load() {
		try {
			URL a = PathFile.getURL(this.path);
			BufferedImage img = ImageIO.read(Objects.requireNonNull(a));
			int w = img.getWidth();
			int h = img.getHeight();

			img.getRGB(0, 0, w, h, this.pixels, 0, w);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
