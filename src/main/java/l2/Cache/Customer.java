package l2.Cache;

import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="L2_Customer")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Customer {
  
  public Customer()
  {}
  
  public Customer(int cid, String cname, int cbill) {
	super();
	this.cid = cid;
	this.cname = cname;
	this.cbill = cbill;
  }

  @Id 
  @Column(name="CustomerID")
  private int cid;
  @Column(name="CustomerName")
  private String cname;
  @Column(name="CustomerBill")
  private int cbill;
  
  @Override
  public String toString() {
	return "Customer [cid=" + cid + ", cname=" + cname + ", cbill=" + cbill + "]";
  }

  public int getCid() {
	return cid;
  }

  public void setCid(int cid) {
	this.cid = cid;
  }

  public String getCname() {
	return cname;
  }

  public void setCname(String cname) {
	this.cname = cname;
  }

  public int getCbill() {
	return cbill;
  }

  public void setCbill(int cbill) {
	this.cbill = cbill;
  }
    
  
}
