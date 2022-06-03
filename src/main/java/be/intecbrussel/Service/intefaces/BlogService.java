package be.intecbrussel.service.intefaces;

import be.intecbrussel.data.Blog;

import java.util.List;

public interface BlogService {
    public List<Blog> getAllBlogs();


    public Blog getBlogById(long id);
 
    public void createBlog(Blog blog);
}
