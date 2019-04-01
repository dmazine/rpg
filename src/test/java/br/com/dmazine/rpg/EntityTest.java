package br.com.dmazine.rpg;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntityTest {

    @Test
    public void twoEntitiesWithSameId_shouldHaveTheSameHashCode() {
        final Entity entity1 = new Entity("id");
        final Entity entity2 = new Entity("id");

        Assert.assertEquals(entity1.hashCode(), entity2.hashCode());
    }

    @Test
    public void oneEntity_shouldBeEqualsToItself() {
        final Entity entity = new Entity("id");

        Assert.assertEquals(entity, entity);
    }

    @Test
    public void oneEntity_shouldNotBeEqualsToAnotherObject() {
        final Entity entity = new Entity("id");
        final Object object = new Object();

        Assert.assertNotEquals(entity, object);
    }

    @Test
    public void twoEntitiesWithSameId_shouldBeEquals() {
        final Entity entity1 = new Entity("id");
        final Entity entity2 = new Entity("id");

        Assert.assertEquals(entity1, entity2);
    }


}