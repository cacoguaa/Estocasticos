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
		
		String base = "C:\\Users\\Ace\\Documents\\Workspace\\Estocasticos\\";
		List<String> booksForTraining = new ArrayList<String>();
		booksForTraining.add(base + "src\\examples\\basico.py");
		booksForTraining.add(base + "src\\examples\\MONTE.py");
		GLCP glcp = new GLCP (booksForTraining);
		double result = glcp.getProb(base + "src\\examples\\basico.py");
		System.out.println("RESULT + "+ result);
		
	}

}
