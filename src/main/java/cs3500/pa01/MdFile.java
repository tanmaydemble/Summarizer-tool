package cs3500.pa01;

import java.io.File;
import java.nio.file.attribute.FileTime;

/**
 *to represent a regular markdown file and to store its attributes
 */
public class MdFile {
  private File file;
  private FileTime creationTime;
  private FileTime lastModTime;

  /**
   * instantiates a new markdown file object
   *
   * @param file the markdown file
   * @param creationTime time the markdown file was created
   * @param lastModTime time the markdown file was last modified
   */
  MdFile(File file, FileTime creationTime, FileTime lastModTime) {
    this.file = file;
    this.creationTime = creationTime;
    this.lastModTime = lastModTime;
  }

  /**
   * to access the file
   *
   * @return the markdown file as a file object
   */
  public File getFile() {
    return file;
  }

  /**
   * to access the creation time of a file
   *
   * @return the creation time of the markdown file
   */
  public FileTime getCreationTime() {
    return creationTime;
  }

  /**
   * to access the last modified time of a file
   *
   * @return the last modified time of the markdown file
   */
  public FileTime getLastModTime() {
    return lastModTime;
  }
}
