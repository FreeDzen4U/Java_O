package Labs_O.Lab_5.task3;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

class DecodedWriter extends FilterWriter {

    private final char key;

    protected DecodedWriter(Writer out, char key) {
        super(out);
        this.key = key;
    }

    @Override
    public void write(int c) throws IOException {
        super.write((char) (c - key < 0 ? Character.MAX_VALUE + c - key : c - key));
    }
}
