package MysticQuest;

public class testing {
    
    public class TryCatchExample {
        public static void main(String[] args) {
            try {
                // Kode yang mungkin menghasilkan pengecualian
                int[] numbers = {1, 2, 3};
                System.out.println(numbers[5]); // Ini akan menghasilkan ArrayIndexOutOfBoundsException
            } catch (ArrayIndexOutOfBoundsException e) {
                // Menangkap dan menangani pengecualian
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
            // Eksekusi dilanjutkan di sini setelah blok try-catch
            System.out.println("Program terus berjalan...");
        }
    }
    
}
