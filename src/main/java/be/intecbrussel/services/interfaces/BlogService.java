package be.intecbrussel.services.interfaces;

import be.intecbrussel.data.Blog;

import java.util.List;

public interface BlogService {

    public List<Blog> getAllBlogs();
    public Blog getBlogById(Long id);
    public void createBlog(Blog blog);
    public void deleteBlog(Blog blog);
}
