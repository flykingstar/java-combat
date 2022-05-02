import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * @author dengzhe
 * @date 2022/4/30
 */
public class SelfClassLoader extends ClassLoader {

  public static void main(String[] args) throws Exception {
    Class<?> hello = new SelfClassLoader().findClass("Hello");
    hello.getMethod("hello").invoke(hello.newInstance());
  }

  @Override
  protected Class<?> findClass(String name) {
    Path path = Paths.get("/Hello.class");
    try {
      byte[] bytes = Files.readAllBytes(path);
      for (int i = 0; i < bytes.length; i++) {
        bytes[i] = (byte) (255 - bytes[i]);
      }
      return defineClass(name, bytes, 0, bytes.length);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
