import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Filewalker filewalker = new Filewalker();
        String caminho = "C:\\Users\\bruno.devesa\\IdeaProjects\\FindFiles\\pastacenas";
        String extension = "txt";
        filewalker.walk(caminho,extension);

        List<String> workbookFileList = filewalker.getWorkbookFileList();
        List<String> workbookPathList = filewalker.getWorkbookPathList();

        System.out.println("All files *.txt are here listed: ");
        for (int i = 0; i < workbookFileList.size(); i++) {
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println("file : " + workbookFileList.get(i));
            System.out.println("path : " + workbookPathList.get(i));

        }
        int numberFiles = workbookFileList.size();
        System.out.println("total number of files founded = " + numberFiles);


     /*   try {
            filewalker.GetAllFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
