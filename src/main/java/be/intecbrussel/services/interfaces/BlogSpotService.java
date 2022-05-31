package be.intecbrussel.services.interfaces;

import be.intecbrussel.data.Blog;

import java.util.List;

public interface BlogSpotService {


    List<Blog> getAllBlogSpots();
    Blog getBlogSpotById();
    void deleteBlogById();

}
