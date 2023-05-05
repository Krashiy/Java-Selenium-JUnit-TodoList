package helpers;

import com.sun.jna.Function;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListHelper {
  public static Function dropDownListHelper(int size, int index, List<WebElement> options, WebElement button){
    if(size == index){
      return null;
    }
    if(index != 0){
      button.click();
      options.get(index).click();
    }else{
      options.get(index).click();
    }
    return dropDownListHelper(size, index+1, options, button);
  }
}
