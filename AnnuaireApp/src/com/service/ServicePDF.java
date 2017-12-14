package com.service;

import java.io.FileOutputStream;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.IBean;
import com.bean.compte.User;
import com.bean.contact.Entreprise;
import com.bean.contact.Particulier;
import com.bean.contact.Contact;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ServicePDF {
	private static Logger logger = LogManager.getLogger(ServicePDF.class);

	private static PdfPCell celluleSansBordure(String contenu) {
		PdfPCell cellule = new PdfPCell();
		
		//sans bordure
		cellule.setBorder(0);
		cellule.setHorizontalAlignment(Element.ALIGN_LEFT);
		
		//�crire
		cellule.addElement(new Paragraph(contenu, new Font()));
		return cellule;
	}
	
	private static PdfPTable genereEntete(User u) throws Exception {
		
		PdfPTable entete = new PdfPTable(2);
		
		entete.addCell(celluleSansBordure("Carnet d'adresse"));
		
		Image image = Image.getInstance("C:/java3/tpFinal_max_annie/images/annuaire.gif");
		image.setAlignment(Element.ALIGN_LEFT);
		image.scalePercent(25);
		
		PdfPCell cell = new PdfPCell(image, false);
		cell.setBorder(0);
		entete.addCell(cell);
		
		entete.addCell(celluleSansBordure("Identifiant"));
		entete.addCell(celluleSansBordure(u.getCredentials().getUsername()));
		
		entete.addCell(celluleSansBordure("Courriel"));
		entete.addCell(celluleSansBordure(u.getEmail()));
		
		return entete;
	}
	
	private static PdfPTable genereTableauContact(Set<IBean> contacts) {
		PdfPTable tab = new PdfPTable(4);
		
		tab.addCell("Nom");
		tab.addCell("T�l�phone");
		tab.addCell("Courriel");
		tab.addCell("Adresse");
		
		for (IBean c : contacts) {
			if (c instanceof Particulier) {
				tab.addCell(((Particulier) c).getNom()+", "+((Particulier) c).getPrenom());
			} else {
				tab.addCell(((Entreprise)c).getNom());
			}
			
			tab.addCell(((Contact)c).getTelephone());
			tab.addCell(((Contact)c).getCourriel());
			tab.addCell(((Contact)c).getAddress().toString());
		}
		return null;
	}
	
	public static void generePDF(User u, String filename) {
		Document doc = new Document();
		
		try {
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(filename));
			doc.open();
			
			doc.add(genereEntete(u));
			doc.add(genereTableauContact(u.getAddressBook().getFavoris()));
			
			doc.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		User u = new User("TOTO", "ytrewq");
		u.setEmail("toto@gmail.com");
		
		generePDF(u, "C:/java3/tpFinal_max_annie/pdf/"+u.getId()+".pdf");
	}
}
