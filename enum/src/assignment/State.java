package assignment;


	
	public enum State{   
		KA("Karnataka"), MP("MadhaPradesh");   
		  
		private String value;  
		State(String value){  
		this.setValue(value);  
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}  
		}  

