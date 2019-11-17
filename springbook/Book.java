package spingboot;

/**
 * Created with IntelliJ IDEA.
 * User: rejeev
 * Date: 2019-11-17
 */
public class Book {
	private String name;
	private String author;
	private String[] tags;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}
}
