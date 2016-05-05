package com.example.llw.demo_sax_xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by llw on 2016/5/5.
 */
public class XmlContHandler extends DefaultHandler {

    private List<Student> students = null;
    private Student mStudent;
    private String tagName = null;

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void startDocument() throws SAXException {
        students = new ArrayList<Student>();
    }

    @Override
    public void endDocument() throws SAXException {
        // TODO Auto-generated method stub
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes atts) throws SAXException {
        if (localName.equals("student")) {
            mStudent = new Student();
            mStudent.setId(atts.getValue("id"));
        }
        this.tagName = localName;
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (localName.equals("student")) {
            students.add(mStudent);
            mStudent = null;
        }
        this.tagName = null;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (tagName != null) {
            String data = new String(ch, start, length);

            if (tagName.equals("name")) {
                this.mStudent.setName(data);
            } else if (tagName.equals("sex")) {
                this.mStudent.setSex(data);
            } else if (tagName.equals("age")) {
                this.mStudent.setAge(Integer.parseInt(data));
            }
        }
    }
}
