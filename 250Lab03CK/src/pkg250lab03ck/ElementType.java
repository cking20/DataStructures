package pkg250lab03ck;
//Created by 

public class ElementType {

    private String date;
    private String start;
    private String end;
    private String location;
    private String comment;

    public String GetKey( ) {
        return getDate();
    }
    
    public ElementType Clone() {
        ElementType clonedItem = new ElementType();
        //must set all attributes of new object to the 
        clonedItem.setComment(getComment());
        clonedItem.setDate(getDate());
        clonedItem.setEnd(getEnd());
        clonedItem.setStart(getStart());
        clonedItem.setLocation(getLocation());
        
        return clonedItem;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getLocation() {
        return location;
    }

    public String getComment() {
        return comment;
    }
    
}
