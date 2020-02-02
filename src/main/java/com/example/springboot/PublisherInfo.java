package com.example.springboot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PublisherInfo {


    public PublisherInfo(String authors, String title, String year, String sourceTitle, String volume, String issue, String artNo, String pageStart, String pageEnd, String pageCount, String citedByBy, String DOI, String link, String affiliations, String authorsWithAffiliations, String anBbstract, String author_Keywords, String indexKeywords, String bothKeywords, String correspondenceAddress, String editors, String publisherAddress, String conferenceName, String conferenceLocation, String conferenceDate, String publisher, String ISSN, String ISBN, String CODEN, String pubMedID, String languageOfOriginalDocument, String abbreviatedSourceTitle, String documentType, String source, String subject, String EID, String duplicatedIn, String country, String emailHost, String institution, String institutionWithCountry, String authorFull) {
        this.authors = authors;
        this.title = title;
        this.year = year;
        this.sourceTitle = sourceTitle;
        this.volume = volume;
        this.issue = issue;
        this.artNo = artNo;
        this.pageStart = pageStart;
        this.pageEnd = pageEnd;
        this.pageCount = pageCount;
        this.citedByBy = citedByBy;
        this.DOI = DOI;
        this.link = link;
        this.affiliations = affiliations;
        this.authorsWithAffiliations = authorsWithAffiliations;
        this.bbstract = anBbstract;
        this.authorKeywords = author_Keywords;
        this.indexKeywords = indexKeywords;
        this.bothKeywords = bothKeywords;
        this.correspondenceAddress = correspondenceAddress;
        this.editors = editors;
        this.publisherAddress = publisherAddress;
        this.conferenceName = conferenceName;
        this.conferenceLocation = conferenceLocation;
        this.conferenceDate = conferenceDate;
        this.publisher = publisher;
        this.ISSN = ISSN;
        this.ISBN = ISBN;
        this.CODEN = CODEN;
        this.pubMedID = pubMedID;
        this.languageOfOriginalDocument = languageOfOriginalDocument;
        this.abbreviatedSourceTitle = abbreviatedSourceTitle;
        this.documentType = documentType;
        this.source=source;
        this.subject = subject;
        this.EID = EID;
        this.duplicatedIn = duplicatedIn;
        this.country = country;
        this.emailHost = emailHost;
        this.institution = institution;
        this.institutionWithCountry = institutionWithCountry;
        this.authorFull = authorFull;
    }

    public String getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public  String getYear() {
        return year;
    }

    public String getSourceTitle() {
        return sourceTitle;
    }

    public String getVolume() {
        return volume;
    }

    public String getIssue() {
        return issue;
    }

    public String getArtNo() {
        return artNo;
    }

    public String getPageStart() {
        return pageStart;
    }

    public String getPageEnd() {
        return pageEnd;
    }

    public String getPageCount() {
        return pageCount;
    }

    public String getCitedByBy() {
        return citedByBy;
    }

    public String getDOI() {
        return DOI;
    }

    public String getLink() {
        return link;
    }

    public String getAffiliations() {
        return affiliations;
    }

    public String getAuthorsWithAffiliations() {
        return authorsWithAffiliations;
    }

    public String getBbstract() {
        return bbstract;
    }

    public String getAuthorKeywords() {
        return authorKeywords;
    }

    public List<String> getAuthorKeywordsAsList() {
        List<String> keyWords = new ArrayList<>();
        String[] split = authorKeywords.split(";");
        keyWords= Arrays.asList(split);
        return keyWords;
    }

    public List<String> getAuthorNameAsAsList() {
        List<String>  authorsNames = new ArrayList<>();
        String[] split = this.getAuthors().split(",");
        authorsNames= Arrays.asList(split);
        return  authorsNames;
    }

    public String getIndexKeywords() {
        return indexKeywords;
    }

    public String getBothKeywords() {
        return bothKeywords;
    }

    public String getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    public String getEditors() {
        return editors;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public String getConferenceLocation() {
        return conferenceLocation;
    }

    public String getConferenceDate() {
        return conferenceDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getISSN() {
        return ISSN;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getCODEN() {
        return CODEN;
    }

    public String getPubMedID() {
        return pubMedID;
    }

    public String getLanguageOfOriginalDocument() {
        return languageOfOriginalDocument;
    }

    public String getAbbreviatedSourceTitle() {
        return abbreviatedSourceTitle;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getSubject() {
        return subject;
    }

    public String getEID() {
        return EID;
    }

    public String getDuplicatedIn() {
        return duplicatedIn;
    }

    public String getEmailHost() {
        return emailHost;
    }

    public String getInstitution() {
        return institution;
    }

    public String getInstitutionWithCountry() {
        return institutionWithCountry;
    }

    public String getAuthorFull() {
        return authorFull;
    }

    String authors;
    String title;
    String year;
    String sourceTitle;
    String volume;
    String issue ;
    String artNo;
    String pageStart;
    String pageEnd;
    String pageCount;
    String citedByBy;
    String DOI;
    String link;
    String affiliations;
    String authorsWithAffiliations;
    String bbstract;
    String authorKeywords;
    String indexKeywords;
    String bothKeywords;
    String correspondenceAddress;
    String editors;
    String publisherAddress;
    String conferenceName;
    String conferenceLocation;
    String conferenceDate;
    String publisher;
    String ISSN;
    String ISBN;
    String CODEN;
    String pubMedID;
    String languageOfOriginalDocument;
    String abbreviatedSourceTitle;
    String documentType;
    String source;
    String subject;
    String EID;
    String duplicatedIn;
    String country;
    String emailHost;
    String institution;
    String institutionWithCountry;
    String authorFull;





    /* NEED TO BE REMOVED START*/
    String  CustomerName;
    String Gender;
    String Address;
    String City;
    String PostalCode;
    String Country;
    String[][] publicationsPerYear = new String[19][2];
    String[][] publicationsPerCategory= new String[19][2];
    /* NEED TO BE REMOVED END*/
    public String[][] getPublicationsPerCategory() {
        return publicationsPerCategory;
    }

    public void setPublicationsPerCategory(String[][] publicationsPerCategory) {
        this.publicationsPerCategory = publicationsPerCategory;
    }

    public String[][] getPublicationsPerYear() {
        return publicationsPerYear;
    }

    public void setPublicationsPerYear(String[][] publicationsPerYear) {
        this.publicationsPerYear = publicationsPerYear;
    }
    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }


}
