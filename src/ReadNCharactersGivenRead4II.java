/**
 * Created by udingji on 5/12/17.
 */
public class ReadNCharactersGivenRead4II {

    // The API: int read4(char *buf) reads 4 characters at a time from a file.
    // The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
    // By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

    // Note:
    // The read function may be called multiple times.

    int read4(char[] buf){
        return 0;
    }

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

    // Define the last time the index we left off in our temporary buffer, as well as the number of characters we read from the file into the buffer.
    // Those are global variables since this method might be called multiple times
    int bufferIndex = 0;
    char[] buffer = new char[4];
    int numBufferRead = 0;
    public int read(char[] buf, int n) {

        // Keep track of the total number of character read. This value will be returned
        int totalCharRead = 0;

        // Loop until we read enough number of characters, or there is no characters to read
        while (totalCharRead < n){

            // If we left something in our buffer, don't read the file, read our buffer
            if (bufferIndex == 0){
                numBufferRead = read4(buffer);
                // If there is nothing to read from the file, break the loop
                if (numBufferRead == 0)
                    break;
            }

            // While we haven't read enough characters, and the index in our buffer not exceeds the number of characters in our buffer
            // Copy each character to the actual buf
            while (totalCharRead < n && bufferIndex < numBufferRead){
                buf[totalCharRead++] = buffer[bufferIndex++];
            }

            // If we read all the characters in our buffer, reset the index in our buffet.
            // So that next time we read from the actual file
            if (bufferIndex >= numBufferRead)
                bufferIndex = 0;
        }
        return totalCharRead;
    }
}
