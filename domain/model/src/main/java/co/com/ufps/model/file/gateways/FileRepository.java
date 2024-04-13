package co.com.ufps.model.file.gateways;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface FileRepository {
    void save(String name, File file) throws IOException;

    InputStream findByName(String name);
}
