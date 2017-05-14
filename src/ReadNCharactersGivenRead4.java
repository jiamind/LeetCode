/**
 * Created by udingji on 5/13/17.
 */
public class ReadNCharactersGivenRead4 {

    int read4(char[] buf){
        return 0;
    }

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
