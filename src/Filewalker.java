import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno.devesa on 09-06-2015.
 */
public class Filewalker {

    List<String> workbookFileList = new ArrayList<String>();
    File[] paths;
    FilenameFilter fileNameFilter;
    File file;

    public void walk(String pathUser) {

        // create new file
        file = new File(pathUser);
        // create new filename filter
        fileNameFilter = new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                if (name.toLowerCase().endsWith(".txt")) {
                    workbookFileList.add(name);
                    return true;
                }
                return false;
            }
        };

        // returns pathnames for files and directory
        paths = file.listFiles(fileNameFilter);
    }

    public File[] getPaths() {
        return paths;
    }

    public List<String> getWorkbookFileList() {
        return workbookFileList;
    }
}
