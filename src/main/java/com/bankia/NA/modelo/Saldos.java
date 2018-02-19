package com.bankia.NA.modelo;

public class Saldos extends SaldosKey {
	
	
    public Saldos(Integer id, String description, Integer hours, String name, Integer prize) {
		super(id);
		this.description = description;
		this.hours = hours;
		this.name = name;
		this.prize = prize;
	}

	public Saldos(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	private String description;

    private Integer hours;

    private String name;

    private Integer prize;
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrize() {
        return prize;
    }

    public void setPrize(Integer prize) {
        this.prize = prize;
    }

	@Override
	public String toString() {
		return "Saldos [description=" + description + ", hours=" + hours + ", name=" + name + ", prize=" + prize + "]";
	}
    
    
}