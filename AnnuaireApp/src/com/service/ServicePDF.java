package com.service;

import java.io.FileOutputStream;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.IBean;
import com.bean.annuaire.Annuaire;
import com.bean.compte.User;
import com.bean.contact.Entreprise;
import com.bean.contact.Particulier;
import com.bean.contact.Contact;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ServicePDF {
	private static Logger logger = LogManager.getLogger(ServicePDF.class);
	
	private static final String PATH_PDF = "C:/java3/tpFinal_max_annie/pdf/";

	private static PdfPCell celluleSansBordure(String contenu) {
		PdfPCell cellule = new PdfPCell();
		
		//sans bordure
		cellule.setBorder(0);
		cellule.setHorizontalAlignment(Element.ALIGN_LEFT);
		
		//ï¿½crire
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
	
	private static Image genereCodeBar(User u, PdfWriter writer, PdfPTable tab) {
		PdfContentByte cByte = writer.getDirectContent();
		
		BarcodeEAN bar = new BarcodeEAN();
		bar.setCodeType(Barcode.EAN13);
		bar.setCode(Long.toString(System.currentTimeMillis())+u.getId());
		Image barCode = bar.createImageWithBarcode(cByte, null, null);
		
		PdfPCell cell = new PdfPCell(barCode, false);
		cell.setPaddingTop(10);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setColspan(2);
		cell.setBorder(0);
		tab.addCell(cell);
	
		return barCode;
	}
	
	private static PdfPTable genereTableauContact(Set<IBean> contacts) {
		PdfPTable tab = new PdfPTable(4);
		
		tab.addCell("Nom");
		tab.addCell("Téléphone");
		tab.addCell("Courriel");
		tab.addCell("Adresse");
		
		System.out.println(contacts);
		
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
		return tab;
	}
	
	public static void generePDF(User u) {
		Document doc = new Document();
		
		try {
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(PATH_PDF+u.getCredentials().getUsername()+".pdf"));
			doc.open();
			
			PdfPTable entete = genereEntete(u);
			entete.addCell(genereCodeBar(u, writer, entete));
			
			doc.add(entete);
			doc.add(new Paragraph("Favoris"));
			doc.add(genereTableauContact(u.getAddressBook().getFavoris()));
			doc.add(new Paragraph("Particuliers"));
			doc.add(genereTableauContact(u.getAddressBook().getListeParticuliers()));
			doc.add(new Paragraph("Entreprises"));
			doc.add(genereTableauContact(u.getAddressBook().getListeEntreprises()));
			
			doc.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
