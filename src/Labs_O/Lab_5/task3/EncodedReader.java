package Labs_O.Lab_5.task3;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

class EncodedReader extends FilterReader {

    private final char key;

    protected EncodedReader(Reader in, char key) {
        super(in);
        this.key = key;
    }

    @Override
    public int read() throws IOException {
        int readedChar = super.read();
        if(readedChar == -1) return -1;
        else return (char)readedChar + key > Character.MAX_VALUE ? readedChar + key % Character.MAX_VALUE : readedChar + key;
    }
}
