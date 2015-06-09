import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Filewalker filewalker = new Filewalker();
        filewalker.walk("C:\\Users\\bruno.devesa\\IdeaProjects\\FindFiles");
        List<String> workbookFileList = filewalker.getWorkbookFileList();
        File[] workbookPathList = filewalker.getPaths();

        System.out.println("All files *.txt are here listed: ");
        for (int i = 0; i < workbookFileList.size(); i++) {
            System.out.println("file : " + workbookFileList.get(i));
        }

        // for each pathname in pathname array
        for (File path : workbookPathList) {
            // prints file and directory paths
             System.out.println("path : " + path);
        }

    }
}
