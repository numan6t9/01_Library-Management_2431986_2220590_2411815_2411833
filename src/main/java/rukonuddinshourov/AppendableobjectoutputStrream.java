package rukonuddinshourov;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableobjectoutputStrream extends ObjectOutputStream {
    public AppendableobjectoutputStrream(OutputStream out)throws IOException {
        super(out);
    }
}
