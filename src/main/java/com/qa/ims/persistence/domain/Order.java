package com.qa.ims.persistence.domain;

public class Order {

			private Long id; 
			private Long customer_id;
			private Double price;
			
			public Order(Long customer_id, Double price) {
				super();
				this.customer_id = customer_id;
				this.price = price;
			}

			public Order(Long id, Long customer_id, Double price) {
				super();
				this.id = id;
				this.customer_id = customer_id;
				this.price = price;
			}

			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}

			public Long getCustomer_id() {
				return customer_id;
			}

			public void setCustomer_id(Long customer_id) {
				this.customer_id = customer_id;
			}

			public Double getPrice() {
				return price;
			}

			public void setPrice(Double price) {
				this.price = price;
			}

			@Override
			public String toString() {
				return "Order [id=" + id + ", customer_id=" + customer_id + ", price=" + price + "]";
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
				result = prime * result + ((id == null) ? 0 : id.hashCode());
				result = prime * result + ((price == null) ? 0 : price.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Order other = (Order) obj;
				if (customer_id == null) {
					if (other.customer_id != null)
						return false;
				} else if (!customer_id.equals(other.customer_id))
					return false;
				if (id == null) {
					if (other.id != null)
						return false;
				} else if (!id.equals(other.id))
					return false;
				if (price == null) {
					if (other.price != null)
						return false;
				} else if (!price.equals(other.price))
					return false;
				return true;
			}

			
			}
	





	
		
			
