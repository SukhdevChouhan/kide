package com.espark.adarsh.persistence.entites.construct;

import javax.persistence.*;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;

@MappedSuperclass
public abstract class AbstractEntity<E extends Serializable> implements Entity<E> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = true, nullable = false, unique = true, updatable = true)
	private E id;

	protected AbstractEntity(Class<? extends Entity> entity) {
		final Class<? extends Entity> entityObject = entity;
		System.out.println(entity.getCanonicalName());
	}

	@Override
	public E getId() {
		if(id.toString().contains(",")){
			try {
				id=(E) NumberFormat.getNumberInstance(java.util.Locale.US).parse((String) id);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("Error while getting parsing Id : "+id);
				e.printStackTrace();
			}
//			String id1 = id.toString();
//			int id2=id1.indexOf(",");
//			String[] s1= id1.split(",");
//			String s2=s1[0]+""+s1[1];
//			id=Integer.parseInt(s2);
		}
		return id;
	}

	public void setId(E id) {
		this.id = id;
	}

	@PrePersist
	protected void prePersist() {
	}

	@PreUpdate
	protected void preUpdate() {
	}

	@PreRemove
	protected void preRemove() {
	}

	@Override
	public int compareTo(Object o) {

		if (o instanceof javax.persistence.Entity) {
			Entity entity = (Entity) o;
			return 0;
		}
		return 1;
	}

}