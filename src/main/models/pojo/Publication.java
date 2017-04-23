package models.pojo;

/**
 * Created by admin on 22.04.2017.
 */
public class Publication {
    private int publication_id;
    private String name_publication;
    private String tag;
    private String text_publication;
    private int person_id;
    private String comment;
    private boolean moder;

    public Publication(int publication_id, String name_publication, String tag, String text_publication, int person_id, String comment, boolean moder) {
        this.publication_id = publication_id;
        this.name_publication = name_publication;
        this.tag = tag;
        this.text_publication = text_publication;
        this.person_id = person_id;
        this.comment = comment;
        this.moder = moder;
    }

    public int getPublication_id() {
        return publication_id;
    }

    public void setPublication_id(int publication_id) {
        this.publication_id = publication_id;
    }

    public String getName_publication() {
        return name_publication;
    }

    public void setName_publication(String name_publication) {
        this.name_publication = name_publication;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getText_publication() {
        return text_publication;
    }

    public void setText_publication(String text_publication) {
        this.text_publication = text_publication;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isModer() {
        return moder;
    }

    public void setModer(boolean moder) {
        this.moder = moder;
    }
}
