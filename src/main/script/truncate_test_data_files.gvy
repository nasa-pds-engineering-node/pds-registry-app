import static groovy.io.FileType.*
import java.nio.channels.FileChannel;

class TruncateImgFilesInPlace {

    static def truncate_img(File f){
  	if (f.getPath().endsWith(".img") || f.getPath().endsWith(".qub")){
	 	println f.getPath()
		FileChannel outChan = new FileOutputStream(f.getPath(), true).getChannel();
		outChan.truncate(10);
		outChan.close();
	}
    }

    static void main(String[] args) {
	File baseDir = new File("./target/v11400/")
	baseDir.eachFileRecurse(FILES, { f -> truncate_img(f) })
    }

}
