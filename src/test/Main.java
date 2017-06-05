package test;


//import de librerias de runtime de ANTLR
import java.util.ArrayList;
import java.util.List;

public class Main {
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// crear un analizador léxico que se alimenta apartir de la entrada
		// (archivo o consola)
		/*
		 * UNALangLexer lexer; if (args.length>0) lexer = new UNALangLexer(new
		 * ANTLRFileStream(args[0])); else lexer = new UNALangLexer(new
		 * ANTLRInputStream(System.in));
		 */
		List<String> booksForTraining = new ArrayList<String>();
		booksForTraining.add("C:\\Users\\Ace\\Documents\\Workspace\\plagio\\src\\Ejemplos\\basico.py");
		booksForTraining.add("C:\\Users\\Ace\\Documents\\Workspace\\plagio\\src\\Ejemplos\\Planetas.py");
		GLCP glcp = new GLCP (booksForTraining);
		
		float result = glcp.getProb("C:\\Users\\Ace\\Documents\\Workspace\\plagio\\src\\Ejemplos\\basico.py");
		System.out.println("RESULT + "+ result);
		
	}

}
