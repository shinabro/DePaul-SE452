package edu.depaul.se.jpa.basic.existingtables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PURCHASE_ORDER")
@NamedQueries({
    @NamedQuery(name = PurchaseOrder.PURCHASE_ORDER_QUERY_ALL,
            query = "select p from PurchaseOrder p"),
    @NamedQuery(name = PurchaseOrder.PURCHASE_ORDER_QUERY_BY_CUSTOMER,
            query = "SELECT p FROM PurchaseOrder p WHERE p.customerId = :" + PurchaseOrder.CUSTOMER_ID_PARAMETER_NAME),})
@NamedNativeQueries({
    @NamedNativeQuery(name = PurchaseOrder.PURCHASE_ORDER_NATIVE_QUERY_ALL, query = "select * from purchase_order")
})
public class PurchaseOrder implements Serializable {

    public static final String PURCHASE_ORDER_QUERY_ALL = "PurchaseOrder.findAll";
    public static final String PURCHASE_ORDER_NATIVE_QUERY_ALL = "PurchaseOrder.nativeFindAll";
    public static final String PURCHASE_ORDER_QUERY_BY_CUSTOMER = "PurchaseOrder.findByCustomer";
    public static final String CUSTOMER_ID_PARAMETER_NAME = "customerId";

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ORDER_NUM")
    private Integer orderNum;

    @Temporal(TemporalType.DATE)
    @Column(name = "SALES_DATE")
    private Date salesDate;

    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne(optional = false)
    private Customer customerId;
    private Short quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SHIPPING_COST")
    private BigDecimal shippingCost;
    @Column(name = "FREIGHT_COMPANY")
    private String freightCompany;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    public String getFreightCompany() {
        return freightCompany;
    }

    public void setFreightCompany(String freightCompany) {
        this.freightCompany = freightCompany;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderNum != null ? orderNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PurchaseOrder)) {
            return false;
        }
        PurchaseOrder other = (PurchaseOrder) object;
        if ((this.orderNum == null && other.orderNum != null) || (this.orderNum != null && !this.orderNum.equals(other.orderNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PurchaseOrder[ orderNum=" + orderNum + " ]";
    }

}
