package com.algoriths.dynamicprogramming;

import com.algoriths.dynamicprogramming.models.SubStringSequenceResult;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SubStringSequenceTest {
    @InjectMocks
    private SubStringSequence cut;

    @Test
    public void testFindSubSequenceUnitBaseString() {
        SubStringSequenceResult result = cut.findSubSequence("a", "efabcd");
        Assert.assertNotNull(result);
        Assert.assertEquals("a", result.getSequence());
    }

    @Test
    public void testFindSubSequenceUnitTargetString() {
        SubStringSequenceResult result = cut.findSubSequence("abcde", "c");
        Assert.assertNotNull(result);
        Assert.assertEquals("c", result.getSequence());
    }

    @Test
    public void testFindSubSequence() {
        SubStringSequenceResult result = cut.findSubSequence("54a11d22f33g44f55g66413121456987", "abcdfgfg");
        Assert.assertNotNull(result);
        Assert.assertEquals("adfgfg", result.getSequence());
    }

    @Test
    public void testFindSubSequenceNoCommonSubSequence() {
        SubStringSequenceResult result = cut.findSubSequence("54adfgfg", "1111111");
        Assert.assertNotNull(result);
        Assert.assertEquals("", result.getSequence());
    }

    @Test
    public void testFindSubSequenceSameStrings() {
        SubStringSequenceResult result = cut.findSubSequence("54adfgfg", "54adfgfg");
        Assert.assertNotNull(result);
        Assert.assertEquals("54adfgfg", result.getSequence());
    }

    @Test
    public void testFindSubSequenceNullBase() {
        SubStringSequenceResult result = cut.findSubSequence(null, "abcdfgfg");
        Assert.assertNotNull(result);
        Assert.assertEquals("", result.getSequence());
    }

    @Test
    public void testFindSubSequenceNullTarget() {
        SubStringSequenceResult result = cut.findSubSequence("abcd", null);
        Assert.assertNotNull(result);
        Assert.assertEquals("", result.getSequence());
    }
}
