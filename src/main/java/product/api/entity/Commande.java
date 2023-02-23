package product.api.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Commande {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "integer default 1")
	private int quantite;
	private Timestamp timestamp;
	private String Status;
	
	@OneToOne(cascade = CascadeType.ALL) 
	Client client;
	
	@ManyToMany(cascade = CascadeType.ALL )
	private Set<Product> products ;
	
	
	public Commande() {
	}
	
	public Commande(int quantite, Timestamp timestamp, String status, Client client, Set<Product> products) {
		super();
		this.quantite = quantite;
		this.timestamp = timestamp;
		Status = status;
		this.products = new HashSet<>();
		this.client = client;
		this.products = products;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Commande [id=" + id + ", quantite=" + quantite + ", timestamp=" + timestamp + ", Status=" + Status
				+ ", client=" + client + ", products=" + products + "]";
	}
	
	
}
