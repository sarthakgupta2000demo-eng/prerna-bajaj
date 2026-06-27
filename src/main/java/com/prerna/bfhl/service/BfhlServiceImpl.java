package com.prerna.bfhl.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.prerna.bfhl.dto.BfhlRequest;
import com.prerna.bfhl.dto.BfhlResponse;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    @Value("${app.user.full-name}")
    private String fullName;

    @Value("${app.user.dob}")
    private String dob;

    @Value("${app.user.email}")
    private String email;

    @Value("${app.user.roll-number}")
    private String rollNumber;

    @Override
    public BfhlResponse processData(BfhlRequest request) {
        List<String> data = request.getData();

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();
        long sum = 0;
        StringBuilder allAlphaChars = new StringBuilder();

        for (String item : data) {
            if (isNumber(item)) {
                long num = Long.parseLong(item);
                sum += num;
                if (num % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }
            } else if (isAlphabet(item)) {
                alphabets.add(item.toUpperCase());
                allAlphaChars.append(item);
            } else {
                specialCharacters.add(item);
            }
        }

        String concatString = buildConcatString(allAlphaChars.toString());
        String userId = buildUserId();

        return BfhlResponse.builder()
                .isSuccess(true)
                .userId(userId)
                .email(email)
                .rollNumber(rollNumber)
                .oddNumbers(oddNumbers)
                .evenNumbers(evenNumbers)
                .alphabets(alphabets)
                .specialCharacters(specialCharacters)
                .sum(String.valueOf(sum))
                .concatString(concatString)
                .build();
    }

    private boolean isNumber(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isAlphabet(String s) {
        return s != null && !s.isEmpty() && s.chars().allMatch(Character::isLetter);
    }

    /**
     * Collects ALL characters from all alphabetic tokens,
     * reverses that character sequence, then alternates UPPER/lower
     * starting with UPPER for index 0.
     *
     * Example C: tokens ["A","ABCD","DOE"]
     * All chars: A A B C D D O E → reversed: E O D D C B A A
     * Alternating caps: E o D d C b A a → "EoDdCbAa"
     */
    private String buildConcatString(String allChars) {
        String reversed = new StringBuilder(allChars).reverse().toString();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
        }
        return result.toString();
    }

    private String buildUserId() {
        String namePart = fullName.toLowerCase().replace(" ", "_");
        return namePart + "_" + dob;
    }
}
