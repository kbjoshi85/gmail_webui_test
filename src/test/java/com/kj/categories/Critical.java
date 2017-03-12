package com.kj.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

/**
 * Created by KJoshi on 3/10/17.
 */

@RunWith(Categories.class)
@Categories.IncludeCategory({Critical.class})
public interface Critical {
}
