package ee.ut.cs.exchange;


import android.os.Parcel;  
import android.os.Parcelable;

public class Book implements Parcelable {
	
    private String title;  
    private String author;  
    private int edition;  
       
    public String getBookTitle() {  
    	return title;  
    }  
    
    public void setBookTitle(String bookTitle) {  
    	this.title = bookTitle;  
    }  
    
    public String getAuthor() {  
    	return author;  
    }  
    
    public void setAuthor(String author) {  
    	this.author = author;  
    }  
    
    public int getEdition() {  
    	return edition;  
    }  
    
    public void setEdition(int edition) {  
    	this.edition = edition;  
    }  
       
    public static final Parcelable.Creator<Book> CREATOR = new Creator<Book>() {  
    	public Book createFromParcel(Parcel source) {  
    		Book mBook = new Book();  
    		mBook.title = source.readString();  
    		mBook.author = source.readString();  
    		mBook.edition = source.readInt();  
    		
    		return mBook;  
    	}  
    	
    	public Book[] newArray(int size) {  
    		return new Book[size];  
    	}  
    };
    
       
    public int describeContents() {  
    	return 0;  
    }  
    
    public void writeToParcel(Parcel parcel, int flags) {  
    	parcel.writeString(title);  
    	parcel.writeString(author);  
    	parcel.writeInt(edition);  
    }  
}  