//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-520 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.02.14 at 10:19:02 AM EST 
//


package au.com.thinkingrock.xsd.tr.view.actions.screens;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SortColumn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SortColumn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="columnID" use="required" type="{http://thinkingrock.com.au/xsd/tr/view/actions/screens}ColumnID" />
 *       &lt;attribute name="descending" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SortColumn")
public class SortColumn {

    @XmlAttribute(required = true)
    protected ColumnID columnID;
    @XmlAttribute
    protected Boolean descending;

    /**
     * Gets the value of the columnID property.
     * 
     * @return
     *     possible object is
     *     {@link ColumnID }
     *     
     */
    public ColumnID getColumnID() {
        return columnID;
    }

    /**
     * Sets the value of the columnID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnID }
     *     
     */
    public void setColumnID(ColumnID value) {
        this.columnID = value;
    }

    /**
     * Gets the value of the descending property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDescending() {
        return descending == null ? false : descending;
    }

    /**
     * Sets the value of the descending property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDescending(Boolean value) {
        this.descending = value;
    }

}
