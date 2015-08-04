package com.stankurdziel.mockitodemo;

import android.test.InstrumentationTestCase;
import android.view.View;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NormalUsageOfMockito extends InstrumentationTestCase {

    public void setUp() {
        // This workaround allows the test to work with Dexmaker 1.2. Commenting it results in error:
        // java.lang.IllegalArgumentException: dexcache == null (and no default could be found; consider setting the 'dexmaker.dexcache' system property)
        System.setProperty("dexmaker.dexcache", getInstrumentation().getTargetContext().getCacheDir().getPath());
    }

    public void testMockingAnAndroidClass() {
        View view = mock(View.class);
        when(view.getX()).thenReturn(400f);
        assertEquals(400f, view.getX());
    }
}
