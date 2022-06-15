package be.intecbrussel.services.implementations;

import be.intecbrussel.data.Blog;
import be.intecbrussel.repository.BlogsRepository;
import be.intecbrussel.services.interfaces.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {
    private BlogsRepository blogsRepository;

    @Autowired
    public BlogServiceImpl(BlogsRepository blogsRepository) {
        this.blogsRepository = blogsRepository;
    }

    @Override
    public List<Blog> getAllBlogs() {
        List<Blog> blogList = new ArrayList<>();
        blogList = blogsRepository.findAll();

        return blogList;
    }

    @Override
    public Blog getBlogById(Long id) {
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
        for (Blog blog : blogs) {
            String blogsTitle = blog.getTitle();
            if (!blogsTitle.isBlank() && blogsTitle.toLowerCase().contains(title.toLowerCase())) {
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
        for (Blog blog : blogs) {
            String authorName = blog.getAuteur().getName();
            if (authorName.equalsIgnoreCase(name)) {
                blogsList.add(blog);
            }
        }
        return blogsList;
    }

    @Override
    public void deleteBlog(Blog blog) {

    }

    @Override
    public List<Blog> sortByDate() {
        List<Blog> blogs = blogsRepository.findAll();
        blogs.stream()
                .sorted(Comparator.comparing(Blog::getDateTime))
                .collect(Collectors.toList());
        //Collections.reverse(blogs);
        return blogs;
    }

    @Override
    public List<Blog> getBlogByPageNum(int num) {
        List<Blog> blogs = blogsRepository.findAll();
        List<Blog> blogList = new ArrayList<>();
        int value = num * 6;
        int index1 = 0;

        if (num != 1) {
            index1 = value/num;
        }
     int  index2 = index1+6;
         if(index2 >= blogs.size())
             index2 = blogs.size();
        return blogs.subList(index1,index2);
    }


}



