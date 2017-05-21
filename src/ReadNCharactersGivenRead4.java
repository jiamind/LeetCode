/**
 * Created by udingji on 5/13/17.
 */
public class ReadNCharactersGivenRead4 {

    int read4(char[] buf){
        return 0;
    }

    // Question:
    // The API: int read4(char *buf) reads 4 characters at a time from a file.
    // The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
    // By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {

        int totalRead = 0;

        while (totalRead < n){
            char[] buffer = new char[4];
            int readCount = read4(buffer);
            if (readCount == 0) break;
            int loop = Math.min(n-totalRead,readCount);
            for (int i = 0; i < loop; i++){
                buf[totalRead++] = buffer[i];
            }
        }
        return totalRead;
    }
}
