import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno.devesa on 09-06-2015.
 */
public class Filewalker {

    List<String> workbookFileList = new ArrayList<String>();
    List<String> workbookPathList = new ArrayList<String>();

    File[] paths;
    FilenameFilter fileNameFilter;
    File file;

    public Filewalker() {
    }

    public void walk(String path, final String extension) {

        // create new file
        file = new File(path);

        File[] list = file.listFiles();

        for (File anyFile : list) {

            if (anyFile.isDirectory()) {
                walk(anyFile.getAbsolutePath(), extension);
            } else {

                // create new filename filter
                fileNameFilter = new FilenameFilter() {

                    @Override
                    public boolean accept(File dir, String name) {
                        if (name.toLowerCase().endsWith(extension)) {
                            return true;
                        }
                        return false;
                    }
                };

                // returns pathnames for files and directory
                paths = file.listFiles(fileNameFilter);
               // fills the List with file names and path names
                workbookFileList.add(anyFile.getAbsoluteFile().getName());
                workbookPathList.add(anyFile.getAbsolutePath());
            }
        }
    }

    public File[] getPaths() {
        return paths;
    }

    public List<String> getWorkbookFileList() {
        return workbookFileList;
    }

    public List<String> getWorkbookPathList() {
        return workbookPathList;
    }
}
