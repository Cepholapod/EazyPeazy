import java.io.File;
import java.util.List;

public interface Selector {
	List<Recipe> entreeSelector(File f);
	List<Recipe> sideSelector(File f);
	List<Recipe> dessertSelector(File f);

}
