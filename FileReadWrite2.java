
public class FileReadWrite2 {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFileBuffered = "destination_buffered.txt";
        String destinationFileUnbuffered = "destination_unbuffered.txt";
        
        // Using Buffered Streams for Efficient File Copy
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFileBuffered))) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            long startTime = System.nanoTime();
            
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            
            long endTime = System.nanoTime();
            System.out.println("Buffered Streams Copy Time: " + (endTime - startTime) / 1_000_000 + " ms");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found!");
        } catch (IOException e) {
            System.out.println("Error reading or writing the file.");
        }
        
        // Using Unbuffered Streams for Comparison
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFileUnbuffered)) {
            
            int data;
            long startTime = System.nanoTime();
            
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            
            long endTime = System.nanoTime();
            System.out.println("Unbuffered Streams Copy Time: " + (endTime - startTime) / 1_000_000 + " ms");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found!");
        } catch (IOException e) {
            System.out.println("Error reading or writing the file.");
        }
    }
}

