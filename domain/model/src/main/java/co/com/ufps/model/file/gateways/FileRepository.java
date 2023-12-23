package co.com.ufps.model.file.gateways;

import java.io.File;

public interface FileRepository {
    void save(String name, File file);
}
