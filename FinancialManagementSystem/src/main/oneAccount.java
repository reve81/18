package main;

import java.util.Objects;

/**
 * Represents a financial transaction record.
 * Each record includes ID, date, transaction type, category, and amount.
 */
public class oneAccount {
	private int no;             // Unique identifier
	private int date;           // Date in YYYYMMDD format
	private String IOtype;      // Transaction type (e.g., "income" or "expense")
	private String type;        // Transaction category
	private double price;       // Transaction amount

	/**
	 * Constructs a new oneAccount with specified parameters.
	 *
	 * @param no            Unique identifier for the record
	 * @param date          Date of the transaction (YYYYMMDD format)
	 * @param IOtype        Type of transaction (e.g., "income" or "expense")
	 * @param type          Category of the transaction
	 * @param price         Amount of the transaction (must be non-negative)
	 * @throws IllegalArgumentException if any parameter is invalid
	 */
	public oneAccount(int no, int date, String IOtype, String type, double price) {
		validateNo(no);
		validateDate(date);
		validateIOtype(IOtype);
		validateType(type);
		validatePrice(price);

		this.no = no;
		this.date = date;
		this.IOtype = IOtype;
		this.type = type;
		this.price = price;
	}

	// Getters and setters with validation
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		validateNo(no);
		this.no = no;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		validateDate(date);
		this.date = date;
	}

	public String getIOtype() {
		return IOtype;
	}

	public void setIOtype(String IOtype) {
		validateIOtype(IOtype);
		this.IOtype = IOtype;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		validateType(type);
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		validatePrice(price);
		this.price = price;
	}

	// Validation methods
	private void validateNo(int no) {
		if (no < 0) {
			throw new IllegalArgumentException("ID must be a non-negative integer");
		}
	}

	private void validateDate(int date) {
		if (date < 0) {
			throw new IllegalArgumentException("Date must be a valid YYYYMMDD format");
		}
		// Additional date validation logic can be added here
	}

	private void validateIOtype(String type) {
		if (type == null || type.trim().isEmpty()) {
			throw new IllegalArgumentException("Transaction type cannot be null or empty");
		}
	}

	private void validateType(String category) {
		if (category == null || category.trim().isEmpty()) {
			throw new IllegalArgumentException("Category cannot be null or empty");
		}
	}

	private void validatePrice(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Amount must be a non-negative value");
		}
	}

	@Override
	public String toString() {
		return "oneAccount{" +
				"no=" + no +
				", date=" + date +
				", IOtype='" + IOtype + '\'' +
				", type='" + type + '\'' +
				", price=" + price +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		oneAccount that = (oneAccount) o;
		return no == that.no &&
				date == that.date &&
				Double.compare(that.price, price) == 0 &&
				Objects.equals(IOtype, that.IOtype) &&
				Objects.equals(type, that.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(no, date, IOtype, type, price);
	}
}
