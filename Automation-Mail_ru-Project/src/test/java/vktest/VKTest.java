package vktest;

import org.testng.Assert;
import org.testng.annotations.Test;
import vk.VK;

public class VKTest {
    VK vk = new VK();

    @Test()
    public void postMessageTest() {
        vk.postMessage();
        Assert.assertTrue(vk.postIsPresent());
    }

    @Test(priority = 1)
    public void editMessageTest() {
        vk.editMessage();
        Assert.assertTrue(vk.postIsEdited());
    }

    @Test(priority = 2)
    public void deleteMessageTest() {
        vk.deleteMessage();
        Assert.assertFalse(vk.postIsPresent());
    }
}