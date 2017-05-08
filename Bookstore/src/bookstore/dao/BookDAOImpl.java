package bookstore.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;



import bookstore.model.Book;
import bookstore.model.Books;


public class BookDAOImpl implements BookDAO {
	
	File file =new File("/home/carina/Documents/workspace-sts-3.8.3.RELEASE/Bookstore/src/bookstore/model/Book.xml");

	
	static Books books = new Books();
	
	static{
		
		books.setList(new ArrayList<Book>());
		
		Book bk1 = new Book();
		bk1.setIdBook(1);
		bk1.setTitle("Insomnii");
		bk1.setAuthor("Irina Binder");
		bk1.setGender("Drama");
		bk1.setPrice(22);
		bk1.setStock(3);
		
		Book bk2 = new Book();
		bk2.setIdBook(2);
		bk2.setTitle("Hotul de carti");
		bk2.setAuthor("Markus Zusak");
		bk2.setPrice(18);
		bk2.setStock(2);
		
		books.getList().add(bk1);
		books.getList().add(bk2);
		
	
	}
	
	
	
	@Override
	public List<Book> list() {
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		     
		    Books bks = (Books) jaxbUnmarshaller.unmarshal(file);
		    

		    List<Book> newList = new ArrayList<Book>(bks.getList());
		    return newList;
		    
			}catch(JAXBException e){
	    		e.printStackTrace();
	    	}

			return null;
	}

	@Override
	public void saveOrUpdate(Book book) {
		try{
 		   
		    JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    books.getList().add(book);
		    jaxbMarshaller.marshal(books, file);
		    
		    	}catch(JAXBException e){
		    		e.printStackTrace();
		    	}
		    
	}

	@Override
	public void delete(int idBook) {
		List<Book> found = new ArrayList<Book>();
		for(Book book : books.getList()){
		    if(book.getIdBook() == idBook){
		        found.add(book);
		    }
		}
		books.getList().removeAll(found);
		
		
		InputSource source = null;
		try {
			source = new InputSource(new FileInputStream(file));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}

		XPathFactory builder = XPathFactory.newInstance();
		XPath xpath = builder.newXPath();

		XPathExpression exp = null;
		try {
			exp = xpath.compile("Books/book[idBook=" + idBook +"]");
		} catch (XPathExpressionException e1) {
			e1.printStackTrace();
		}

		Node node = null;
		try {
			node = (Node) exp.evaluate(source, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		node.getParentNode().removeChild(node);
		
		try{
 		   
		    JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		//    users.getList().add(user);
		    jaxbMarshaller.marshal(books, file);
		    
		    	}catch(JAXBException e){
		    		e.printStackTrace();
		    	}
		    

	}

	@Override
	public Book getIdBook(int idBook) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getTitle(String title) {
		
		
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		     
		    Books bks = (Books) jaxbUnmarshaller.unmarshal(file);
		    
		    List<Book> newList = new ArrayList<Book>();
		    
		   for(Book bk : bks.getList()){
			   if(bk.getTitle().toLowerCase().contains(title.toLowerCase())){
				   newList.add(bk);
			   System.out.println("am ajuns pana aici in try");
			   System.out.println("autor:   "+bk.getAuthor());
			   }
		   }

		    
		   return newList;
		    
			}catch(JAXBException e){
	    		e.printStackTrace();
	    	}

		System.out.println("am ajuns pana aici dupa try");
			
			return null;
	}

	@Override
	public List<Book> getAuthor(String author) {
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		     
		    Books bks = (Books) jaxbUnmarshaller.unmarshal(file);
		    
		    List<Book> newList = new ArrayList<Book>();
		    
		   for(Book bk : bks.getList()){
			   if(bk.getAuthor().toLowerCase().contains(author.toLowerCase())){
				   newList.add(bk);
			   System.out.println("am ajuns pana aici in try");
			   System.out.println("autor:   "+bk.getAuthor());
			   }
		   }

		    
		   return newList;
		    
			}catch(JAXBException e){
	    		e.printStackTrace();
	    	}

		System.out.println("am ajuns pana aici dupa try");
			
			return null;
	}

	@Override
	public List<Book> getGender(String gender) {
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		     
		    Books bks = (Books) jaxbUnmarshaller.unmarshal(file);
		    
		    List<Book> newList = new ArrayList<Book>();
		    
		   for(Book bk : bks.getList()){
			   if(bk.getGender().toLowerCase().contains(gender.toLowerCase())){
				   newList.add(bk);
			   System.out.println("am ajuns pana aici in try");
			   System.out.println("autor:   "+bk.getAuthor());
			   }
		   }

		    
		   return newList;
		    
			}catch(JAXBException e){
	    		e.printStackTrace();
	    	}

		System.out.println("am ajuns pana aici dupa try");
			
			return null;
	}
	
	public List<Book> sell(int idBook){
		
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance(Books.class);
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		     
		    Books bks = (Books) jaxbUnmarshaller.unmarshal(file);
		    
		    
		   for(Book bk : bks.getList()){
			   if(bk.getIdBook() == idBook){
				bk.setStock(bk.getStock()-1);
				
			//	JAXBContext jaxbContext2 = JAXBContext.newInstance(Books.class);
			    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
				
				 jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				//    books.getList().add(book);
				    jaxbMarshaller.marshal(bks, file);
		
			  }
		   }

			 return bks.getList();
		    
			}catch(JAXBException e){
	    		e.printStackTrace();
	    	}			
		
		
	
		
			return null;
	}
	
	
	 public static final String RESOURCES_DIR;
	    public static final String OUTPUT_DIR;

	    static {
	        RESOURCES_DIR = "/home/carina/Documents/workspace-sts-3.8.3.RELEASE/Bookstore/src/bookstore/model/";
	        OUTPUT_DIR = "/home/carina/Documents/workspace-sts-3.8.3.RELEASE/Bookstore/WebContent/WEB-INF/output/";
	    }
	    
	@Override
	public void createPDF(){
		
		 // the XSL FO file
        File xsltFile = new File(RESOURCES_DIR + "/pdfBook.xsl");
        
        // the XML file which provides the input
        StreamSource xmlSource = new StreamSource(file);
        
        // create an instance of fop factory
        FopFactory fopFactory = FopFactory.newInstance();
        
        // a user agent is needed for transformation
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        
        // Setup output
        OutputStream out = null;
        try {
			out = new java.io.FileOutputStream(OUTPUT_DIR + "/output.pdf");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        try {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            // Resulting SAX events (the generated FO) must be piped through to
            // FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            // That's where the XML is first transformed to XSL-FO and then
            // PDF is created
            try {
				transformer.transform(xmlSource, res);
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } catch (FOPException | TransformerConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
            try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
	
	

}
