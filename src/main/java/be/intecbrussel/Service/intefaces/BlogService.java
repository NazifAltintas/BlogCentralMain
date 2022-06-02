package be.intecbrussel.Service.intefaces;

import be.intecbrussel.data.Blog;

import java.util.List;

public interface BlogService {
    public List<Blog> getAllBlogs();
    public Blog getBlogById(Long id);
    public void createBlog(Blog blog);
}
