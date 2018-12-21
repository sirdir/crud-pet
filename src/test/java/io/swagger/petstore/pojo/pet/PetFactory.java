package io.swagger.petstore.pojo.pet;

import java.util.Collections;

public class PetFactory {

    private static final String NAME = "leeroy jenkins!!!";
    private static final String STATUS = "available";
    private static final String TAG_NAME = "fat";
    private static final String CATEGORY_NAME = "Tabby";
    private static final String PHOTO_URL = "https://some.url.blah.blah.blah";

    public static Pet defaultPet() {
        final long ID = System.nanoTime();
        final long TAG_ID = System.nanoTime();
        final long CATEGORY_ID = System.nanoTime();

        Pet pet = new Pet();
        pet.setName(NAME);
        pet.setStatus(STATUS);
        pet.setId(ID);
        pet.setPhotoUrls(Collections.singletonList(PHOTO_URL));

        Category cat = new Category();
        cat.setId(CATEGORY_ID);
        cat.setName(CATEGORY_NAME);

        Tag tag = new Tag();
        tag.setId(TAG_ID);
        tag.setName(TAG_NAME);

        pet.setCategory(cat);
        pet.setTags(Collections.singletonList(tag));

        return pet;
    }

    public static Pet petWithCategoryAndTag(String categoryName, String tagName) {
        final long ID = System.nanoTime();
        final long TAG_ID = System.nanoTime();
        final long CATEGORY_ID = System.nanoTime();

        Pet pet = new Pet();
        pet.setName(NAME);
        pet.setStatus(STATUS);
        pet.setId(ID);
        pet.setPhotoUrls(Collections.singletonList(PHOTO_URL));

        Category cat = new Category();
        cat.setId(CATEGORY_ID);
        cat.setName(categoryName);

        Tag tag = new Tag();
        tag.setId(TAG_ID);
        tag.setName(tagName);

        pet.setCategory(cat);
        pet.setTags(Collections.singletonList(tag));

        return pet;
    }
}
