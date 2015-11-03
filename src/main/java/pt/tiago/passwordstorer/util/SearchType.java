package main.java.pt.tiago.passwordstorer.util;

public enum SearchType {
	SIGMA("Sigma"),
	INW("Innowave"),
	TDC("TDC"),
	ALL("");
	
	private String searchString;
	
	SearchType(String searchString){
		this.searchString = searchString;
	}

	public String getSearchString() {
		return searchString;
	}

}
