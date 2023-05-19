package cs3500.pa01;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * To walk the file system
 */
public class FileSystemWalker implements FileVisitor<Path> {
private ArrayList<MdFile> selectedFiles = new ArrayList<MdFile>();

  /**
   * to return the selected regular markdown files
   * @return the selected markdown files in an arraylist of files
   */
  public ArrayList<MdFile> getSelectedFiles() {
    return selectedFiles;
  }

  /**
   * things to do before visiting a directory
   * @param dir
   *          a reference to the directory
   * @param attrs
   *          the directory's basic attributes
   *
   * @return constant CONTINUE so that the file system moves ahead
   * @throws IOException if there is an issue with input output
   */
  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

    return CONTINUE;
  }

  /**
   * to add the file to the arraylist of selected files that will then be summarized
   *
   * @param file
   *          a reference to the file
   * @param attrs
   *          the file's basic attributes
   *
   * @return constant CONTINUE so that the file system moves ahead
   * @throws IOException if there is an issue with input output
   */
  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    String filename = file.getFileName().toString();
    if (attrs.isRegularFile() && filename.endsWith(".md")) {
      selectedFiles.add(new MdFile(file.toFile(), attrs.creationTime(), attrs.lastModifiedTime()));
    }
    return CONTINUE;
  }

  /**
   * to print a message if file visit fails
   *
   * @param file
   *          a reference to the file
   * @param exc
   *          the I/O exception that prevented the file from being visited
   *
   * @return constant CONTINUE so that the file system moves ahead
   * @throws IOException if there is an issue with input output
   */
  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
    return CONTINUE;
  }

  /**
   * things to do after visiting a directory
   *
   * @param dir
   *          a reference to the directory
   * @param exc
   *          {@code null} if the iteration of the directory completes without
   *          an error; otherwise the I/O exception that caused the iteration
   *          of the directory to complete prematurely
   *
   * @return constant CONTINUE so that the file system moves ahead
   * @throws IOException if there is an issue with input output
   */
  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
    return CONTINUE;
  }
}
