package com.prerna.bfhl.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class BfhlResponse {

    @JsonProperty("is_success")
    private boolean isSuccess;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("email")
    private String email;
    @JsonProperty("roll_number")
    private String rollNumber;
    @JsonProperty("odd_numbers")
    private List<String> oddNumbers;
    @JsonProperty("even_numbers")
    private List<String> evenNumbers;
    @JsonProperty("alphabets")
    private List<String> alphabets;
    @JsonProperty("special_characters")
    private List<String> specialCharacters;
    @JsonProperty("sum")
    private String sum;
    @JsonProperty("concat_string")
    private String concatString;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final BfhlResponse r = new BfhlResponse();

        public Builder isSuccess(boolean v) {
            r.isSuccess = v;
            return this;
        }

        public Builder userId(String v) {
            r.userId = v;
            return this;
        }

        public Builder email(String v) {
            r.email = v;
            return this;
        }

        public Builder rollNumber(String v) {
            r.rollNumber = v;
            return this;
        }

        public Builder oddNumbers(List<String> v) {
            r.oddNumbers = v;
            return this;
        }

        public Builder evenNumbers(List<String> v) {
            r.evenNumbers = v;
            return this;
        }

        public Builder alphabets(List<String> v) {
            r.alphabets = v;
            return this;
        }

        public Builder specialCharacters(List<String> v) {
            r.specialCharacters = v;
            return this;
        }

        public Builder sum(String v) {
            r.sum = v;
            return this;
        }

        public Builder concatString(String v) {
            r.concatString = v;
            return this;
        }

        public BfhlResponse build() {
            return r;
        }
    }

    @JsonIgnore
    public boolean isSuccess() {
        return isSuccess;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public List<String> getOddNumbers() {
        return oddNumbers;
    }

    public List<String> getEvenNumbers() {
        return evenNumbers;
    }

    public List<String> getAlphabets() {
        return alphabets;
    }

    public List<String> getSpecialCharacters() {
        return specialCharacters;
    }

    public String getSum() {
        return sum;
    }

    public String getConcatString() {
        return concatString;
    }
}