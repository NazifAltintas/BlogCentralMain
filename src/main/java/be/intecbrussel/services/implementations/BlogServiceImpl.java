package be.intecbrussel.services.implementations;

import be.intecbrussel.data.Blog;
import be.intecbrussel.repository.BlogsRepository;
import be.intecbrussel.services.interfaces.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class BlogServiceImpl implements BlogService {
   private BlogsRepository blogsRepository;
    @Autowired
    public BlogServiceImpl(BlogsRepository blogsRepository) {
        this.blogsRepository = blogsRepository;
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogsRepository.findAll() ;
    }

    @Override
    public Blog getBlogById(long id) {
            Blog blog = blogsRepository.findById(id).get();
            return blog;
    }

    @Override
    public void createBlog(Blog blog) {
      blogsRepository.save(blog);

    }

    @Override
    public List<Blog> findBlogsByTitle(String title) {
        List<Blog> blogsList = new ArrayList<>();
        List<Blog> blogs = blogsRepository.findAll();
        for(Blog blog : blogs){
            String blogsTitle = blog.getTitle();
            if(!blogsTitle.isBlank() && blogsTitle.toLowerCase().contains(title.toLowerCase())){
                blogsList.add(blog);

            }

        }
        return blogsList;
        // Arrays.stream(blogs.toArray())
    }

    @Override
    public List<Blog> findBlogsByAuthor(String name) {
        List<Blog> blogsList = new ArrayList<>();
        List<Blog> blogs = blogsRepository.findAll();
        for(Blog blog : blogs){
         String authorName = blog.getAuteur().getName();
            if(authorName.equalsIgnoreCase(name)){
                blogsList.add(blog);
            }
        }
        return blogsList;
    }
}



