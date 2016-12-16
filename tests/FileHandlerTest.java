import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Created by Cree on 15/12/2016.
 */
public class FileHandlerTest {

    @Test
    public void makeUserShouldMakeValidUser(){
        User user = FileHandler.makeUser("Barry Hart");
        Assert.assertNotNull(user);
    }

    @Test
    public void makeBookShouldMakeValidBook(){
        Book book = FileHandler.makeBook("Murphy's War", "Barry Hart");
        Assert.assertNotNull(book);
    }



}
