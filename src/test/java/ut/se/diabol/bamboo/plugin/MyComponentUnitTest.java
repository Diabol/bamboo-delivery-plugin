package ut.se.diabol.bamboo.plugin;

import org.junit.Test;
import se.diabol.bamboo.plugin.MyPluginComponent;
import se.diabol.bamboo.plugin.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}