package com.algorithms.dynamicprogramming.impl;

import com.algorithms.dynamicprogramming.models.SubStringSequenceResult;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class SubStringSequence {
    public SubStringSequenceResult findSubSequence(String base, String target) {
        if (StringUtils.isBlank(base) || StringUtils.isBlank(target)) {
            return new SubStringSequenceResult("", -1);
        }
        Map<String, SubStringSequenceResult> subStringSequenceResultMap = prepareInitialSubStringSequences(base, target);
        for (int i = 2; i <= base.length(); i++) {
            prepareSubStringSequences(base.substring(0, i), target, subStringSequenceResultMap);

        }
        return subStringSequenceResultMap.get(base);
    }

    private Map<String, SubStringSequenceResult> prepareInitialSubStringSequences(String base, String target) {
        Map<String, SubStringSequenceResult> subStringSequenceResultMap = new HashMap<>();
        for (int i = 0; i < base.length(); i++) {
            String sequence = base.substring(i, i + 1);
            if(StringUtils.lastIndexOf(target, sequence) != -1) {
                subStringSequenceResultMap.put(sequence, new SubStringSequenceResult(sequence, StringUtils.lastIndexOf(target, sequence)));
            } else {
                subStringSequenceResultMap.put(sequence, new SubStringSequenceResult("", StringUtils.lastIndexOf(target, sequence)));
            }

        }
        return subStringSequenceResultMap;
    }

    private void prepareSubStringSequences(String baseSubString, String targetString, Map<String, SubStringSequenceResult> stringToSequenceMap) {
        if (StringUtils.isBlank(baseSubString) || StringUtils.isBlank(targetString)) {
            return;
        }
        String knownSubString = baseSubString.substring(0, baseSubString.length() - 1);
        String searchString = baseSubString.substring(baseSubString.length() - 1, baseSubString.length());
        int lastKnownIndex = stringToSequenceMap.get(knownSubString).getLastIndex();
        if (lastKnownIndex != -1) {
            String targetSubSequence = targetString.substring(lastKnownIndex, targetString.length());
            if (targetSubSequence.contains(searchString)) {
                SubStringSequenceResult result = new SubStringSequenceResult(stringToSequenceMap.get(knownSubString).getSequence()+searchString, StringUtils.indexOf(targetString, searchString));
                stringToSequenceMap.put(baseSubString, result);
            } else {
                SubStringSequenceResult result = new SubStringSequenceResult(stringToSequenceMap.get(knownSubString).getSequence(), stringToSequenceMap.get(knownSubString).getLastIndex());
                stringToSequenceMap.put(baseSubString, result);
            }
        } else {
            if(stringToSequenceMap.get(searchString).getLastIndex() != -1) {
                SubStringSequenceResult result = new SubStringSequenceResult(searchString, stringToSequenceMap.get(searchString).getLastIndex());
                stringToSequenceMap.put(baseSubString, result);
            } else {
                SubStringSequenceResult result = new SubStringSequenceResult(stringToSequenceMap.get(knownSubString).getSequence(), -1);
                stringToSequenceMap.put(baseSubString, result);
            }
        }
    }
}
