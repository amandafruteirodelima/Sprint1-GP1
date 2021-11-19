package logging;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VersaoApp {
    public String pegarVersaoApp() throws FileNotFoundException, IOException, XmlPullParserException {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model versao;

        if ((new File("pom.xml")).exists()) {
            versao = reader.read(new FileReader("pom.xml"));
        } else {
            versao = reader.read(
                    new InputStreamReader(
                            LogErro.class.getResourceAsStream(
                                    "Eu nem sei o que essa merda faz"
                            )
                    )
            );
        }
        return versao.getVersion();
    }
}
