package be.intecbrussel.service.intefaces;

import be.intecbrussel.data.Blog;

import java.util.List;

public interface BlogService {
    public List<Blog> getAllBlogs();
    public Blog getBlogById(int id);
    public void createBlog(Blog blog);
}
