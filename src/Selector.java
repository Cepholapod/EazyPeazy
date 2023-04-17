import java.io.File;
import java.util.List;
/** 
 * 
 * @author sethm
 * DESCRIPTION: this class will likely be removed do not add to UML
 */
public interface Selector {
	List<Recipe> entreeSelector(File f);
	List<Recipe> sideSelector(File f);
	List<Recipe> dessertSelector(File f);

}
