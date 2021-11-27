package functions.handwritten;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class DigitRecognition {
    static File file = new File("C:\\Users\\User 1\\Desktop\\work\\group");
    static File output = new File("C:\\Users\\User 1\\Desktop\\work\\result.png");
    static File test = new File("C:\\Users\\User 1\\Desktop\\work\\test");
    static BufferedImage result;

    static int[] check() throws IOException {
        File[] arr = test.listFiles();
        int[] arrOfInfo = new int[arr.length];
        double numberOFDarkPixels;
        double numberOfCoincidence;
        Color color;
        BufferedImage test;
        for (File item : Objects.requireNonNull(arr)) {                                         //dodelat'
            numberOFDarkPixels = 0;
            numberOfCoincidence = 0;
            test = ImageIO.read(item);
            for (int i = 0; i < test.getWidth(); i++) {
                for (int j = 0; j < test.getHeight(); j++) {
                    color = new Color(test.getRGB(i, j));
                    if (color.getBlue() == 0 && color.getGreen() == 0 && color.getRed() == 0) {
                        numberOFDarkPixels++;
                        if (color.getRGB() == result.getRGB(i, j)) {
                            numberOfCoincidence++;
                        }
                    }
                }
            }
            int i = 0;
            arrOfInfo[i++]= (int) ((numberOfCoincidence / numberOFDarkPixels) * 100);
        }
        return arrOfInfo;
    }
    static void createResult() {
        try {
            BufferedImage result = ImageIO.read(output);
            for (int i = 0; i < result.getWidth(); i++) {
                for (int j = 0; j < result.getHeight(); j++) {
                    result.setRGB(i, j, new Color(255, 255, 255).getRGB());
                }
            }
            File[] arr = file.listFiles();
            for (File item : Objects.requireNonNull(arr)) {
                BufferedImage image = ImageIO.read(item);
                for (int i = 0; i < image.getWidth(); i++) {
                    for (int j = 0; j < image.getHeight(); j++) {
                        Color color = new Color(image.getRGB(i, j));
                        if (color.getBlue() == 0 && color.getGreen() == 0 && color.getRed() == 0) {
                            result.setRGB(i, j, color.getRGB());
                        }
                    }
                }
            }
            DigitRecognition.result = result;
            ImageIO.write(result, "png", output);
        } catch (IOException e) {
            System.out.println("Файл не найден или не удалось сохранить");
        }
    }

    public static void main(String[] args) throws IOException{
        createResult();
        System.out.println(Arrays.toString(check()));
    }
}
