package com.factchecker.factChecker.entity;

import java.util.List;

public class Claims {

	private List<Claim> claims;

	// Getter and Setter
	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public static class Claim {
		private String text;
		private String claimant;

		private List<ClaimReview> claimReview;

		// Getters and Setters
		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getClaimant() {
			return claimant;
		}

		public void setClaimant(String claimant) {
			this.claimant = claimant;
		}

		public List<ClaimReview> getClaimReview() {
			return claimReview;
		}

		public void setClaimReview(List<ClaimReview> claimReview) {
			this.claimReview = claimReview;
		}
	}

	public static class ClaimReview {
		private Publisher publisher;
		private String title;
		private String textualRating;

		// Getters and Setters
		public Publisher getPublisher() {
			return publisher;
		}

		public void setPublisher(Publisher publisher) {
			this.publisher = publisher;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getTextualRating() {
			return textualRating;
		}

		public void setTextualRating(String textualRating) {
			this.textualRating = textualRating;
		}

	}

	public static class Publisher {
		private String name;

		// Getters and Setters
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
}
