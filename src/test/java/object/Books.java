package object;

public class Books {
  private String title;
  private String author;
  private String publisher;

  public Books(String title, String author, String publisher) {
    this.title = title;
    this.author = author;
    this.publisher = publisher;
  }

  public Books() {
    this.title = "";
    this.author = "";
    this.publisher = "";
  }

  public String getAuthor() {
    return author;
  }

  public String getPublisher() {
    return publisher;
  }

  public String getTitle() {
    return title;
  }

  public void setAuthor(String newAuthor) {
    this.author = newAuthor;
  }

  public void setPublisher(String newPublisher) {
    this.publisher = newPublisher;
  }

  public void setTitle(String newTitle) {
    this.title = newTitle;
  }
}
