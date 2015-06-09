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

        File[] allFilesList = file.listFiles();

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

        paths = file.listFiles(fileNameFilter);

        for (int i = 0; i < paths.length; i++) {


            //  System.out.println("testing content of paths array : ");
           // System.out.println(paths[i].getAbsolutePath());
            workbookFileList.add(paths[i].getAbsoluteFile().getName());
            workbookPathList.add(paths[i].getAbsolutePath());

            //System.out.println("end testing");
        }


        for (File anyFile : allFilesList) {

            if (anyFile.isDirectory()) {
                walk(anyFile.getAbsolutePath(), extension);
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
