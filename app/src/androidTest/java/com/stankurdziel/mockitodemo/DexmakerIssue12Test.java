package com.stankurdziel.mockitodemo;

import android.test.AndroidTestCase;
import android.widget.EditText;

import static org.mockito.Mockito.mock;

/**
 * This test demonstrates Dexmaker issue #12.
 *
 * @link https://github.com/crittercism/dexmaker/issues/12
 * <p/>
 * The test is written to pass with dexmaker 1.2: http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22dexmaker%22
 * That means that it demonstrates the issue#12. It will fail if the issue is fixed.
 */
public class DexmakerIssue12Test extends AndroidTestCase {

    private static final String EXPECTED_ERROR_MESSAGE
            = "dexcache == null (and no default could be found; consider setting the 'dexmaker.dexcache' system property)";
    private String preExistingCacheProperty;

    @Override
    protected void setUp() throws Exception {
        preExistingCacheProperty = System.getProperty("dexmaker.dexcache");
    }

    public void testMockAndroidObject() {
        try {
            mock(EditText.class);
            fail("expected an Exception");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains(EXPECTED_ERROR_MESSAGE));
        }
    }

    public void testMockAndroidObjectWorkAround() {
        System.setProperty("dexmaker.dexcache", getContext().getCacheDir().getPath());
        mock(EditText.class);
    }

    @Override
    protected void tearDown() throws Exception {
        if (preExistingCacheProperty != null) System.setProperty("dexmaker.dexcache", preExistingCacheProperty);
    }
}
