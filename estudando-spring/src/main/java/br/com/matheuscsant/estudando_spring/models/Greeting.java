package br.com.matheuscsant.estudando_spring.models;

public class Greeting {

	private final long id;
	private final String content;
	private String optionalContent;

	public Greeting(GreetingBuilder builder) {
		this.id = builder.id;
		this.content = builder.content;
		this.optionalContent = builder.optionalContent;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getOptionalContent() {
		return optionalContent;
	}

	// Builder Class
	public static class GreetingBuilder {

		// required parameters
		private final long id;
		private final String content;

		// optional parameters
		private String optionalContent;

		public GreetingBuilder(long id, String content) {
			this.id = id;
			this.content = content;
		}

		public GreetingBuilder setOptionalContent(String optionalContent) {
			this.optionalContent = optionalContent;
			return this;
		}

		public Greeting build() {
			return new Greeting(this);
		}

	}

}
