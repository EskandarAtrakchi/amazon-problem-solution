import java.util.Arrays;

public class ImageProcessor {
    
    // Method to rotate the image 90 degrees clockwise
    public static int[][] rotateImage90(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;
        int[][] rotatedImage = new int[cols][rows];
        
        // Perform 90-degree rotation
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotatedImage[j][rows - 1 - i] = image[i][j];
            }
        }
        return rotatedImage;
    }
    
    // Main method to get the final image after performing transformations
    public static int[][] getFinalImage(int[][] image, int rotation, int verticalFlip, int horizontalFlip) {
        // Step 1: Rotate the image based on the given 'rotation' value (0, 1, 2, or 3)
        for (int i = 0; i < rotation; i++) {
            image = rotateImage90(image);
        }
        
        // Step 2: Apply vertical flip if verticalFlip == 1
        if (verticalFlip == 1) {
            image = verticalFlipImage(image);
        }
        
        // Step 3: Apply horizontal flip if horizontalFlip == 1
        if (horizontalFlip == 1) {
            image = horizontalFlipImage(image);
        }
        
        return image;
    }
    
    // Helper method to apply vertical flip (upside-down flip)
    public static int[][] verticalFlipImage(int[][] image) {
        int rows = image.length;
        int[][] flippedImage = new int[rows][];
        
        // Reverse the rows
        for (int i = 0; i < rows; i++) {
            flippedImage[i] = image[rows - 1 - i];
        }
        return flippedImage;
    }
    
    // Helper method to apply horizontal flip (left-right flip)
    public static int[][] horizontalFlipImage(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;
        
        // Reverse the columns in each row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][cols - 1 - j];
                image[i][cols - 1 - j] = temp;
            }
        }
        return image;
    }

    public static void main(String[] args) {
        // Example usage
        int[][] image = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int rotation = 1; // 90 degrees rotation
        int verticalFlip = 1; // Apply vertical flip
        int horizontalFlip = 0; // Do not apply horizontal flip
        
        int[][] result = getFinalImage(image, rotation, verticalFlip, horizontalFlip);
        
        // Print the final image
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
