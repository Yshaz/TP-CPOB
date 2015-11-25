package edu.iut.app;

public class CommandLineOption<ValueType> /* EX1 : CLASSE GENERIC SUR le type ValueType */ {
	
	private ValueType val;
	
	public enum OptionType{
		NONE("None"),
		FILE("File"),
		STRING("String"),
		INTEGER("Integer"),
		DOUBLE("Double"),
		NOVALUE("NoValue");
		
		private String optionType;
		
		OptionType(String optionType) {
			this.optionType = optionType;
		}
		
		public String toString() {
			return optionType;
		}		
	}
	
	public CommandLineOption() {
		this.val = null;
	}
	
	public CommandLineOption(final OptionType optionType, final String key, final String description, final ValueType defaultValue) {
		this.val = defaultValue;
		this.key = key;
		this.description = description;
		this.optionType = optionType;
	}
	
	public void setOption(OptionType optionType, String key, String description, ValueType defaultValue) {
		this.val = defaultValue;
		this.key = key;
		this.description = description;
		this.optionType = optionType;
	}
	
	public  void setValue(ValueType value) {
		this.value = value;
	}
		
	public String getKey() {
		return this.key;
	}
	public String getDescription() {
		return this.description;
	}
	public ValueType getValue() {
		if (value != null) {
			return value;
		}
		return defaultValue;
	}
	public OptionType getOptionType() {
		return optionType;
	}

	protected String key;
	protected String description;
	protected ValueType defaultValue;
	protected ValueType value;
	protected OptionType optionType;
	

}
