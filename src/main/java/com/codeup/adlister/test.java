package com.codeup.adlister;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.PostsCategories;
import com.codeup.adlister.models.*;
import com.codeup.adlister.util.Password;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        User daniel = new User("daniel", "daniel@gmail.com", "password");
//        System.out.println(DaoFactory.getUsersDao().insert(daniel));
//       User user=DaoFactory.getUsersDao().findByUsername("daniel");
//        System.out.println(user.getUsername());
//        Ad ad = new Ad(2, "Couch for sale!", "Used leather couch, still in good shape", 49.99);
//        System.out.println(DaoFactory.getAdsDao().insert(ad));
//        List<Ad> ads = DaoFactory.getAdsDao().all();
//        for(Ad ad1 : ads){
//            System.out.println(ad1.getTitle());
//            System.out.println(ad1.getDescription());
//            System.out.println(ad1.getUserId());
//            System.out.println(ad1.getPrice());
//
//        };

//        Comment comment = new Comment(1,1, "Looks dope, can we meet up?");
//        DaoFactory.getCommentsDao().addComment(comment);

//        List<Comment> comments=DaoFactory.getCommentsDao().all(1);
//        for (Comment comment : comments){
//
//            System.out.println("Post #"+comment.getPostId() +": "+comment.getUserId()+": "+ comment.getContent());
//        }

//        Image image = new Image(1, "data:image/jpeg;base64,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", "leather couch");
//        DaoFactory.getImagesDao().insert(image);
//        ArrayList<Image> images = DaoFactory.getImagesDao().findByPostId(1);
//        for (Image image: images){
//            System.out.println("Image description: "+ image.getDescription());
//            System.out.println("image link: "+ image.getUrl());
//        }


//
//        PostCategories category = new PostCategories(1, 3);
//        DaoFactory.getPostsCategoriesDao().insert(category);
//        ArrayList<PostCategories> categories = DaoFactory.getPostsCategoriesDao().findByPostId(1);
//        for (PostCategories postCategories : categories){
//            System.out.println(postCategories.getCategory());
//        }



//        List<Ad> ads = DaoFactory.getAdsDao().all();
//        for(Ad ad1 : ads){
//            System.out.println("Title: "+ad1.getTitle());
//            System.out.println("Description: "+ad1.getDescription());
//            System.out.println("user id: "+ad1.getUserId());
//            System.out.println("price: $"+ad1.getPrice());
//            System.out.println("post id: "+ ad1.getId());
//            long postId=ad1.getId();
//            ArrayList<PostCategories> categories = DaoFactory.getPostsCategoriesDao().findByPostId(postId);
//            System.out.println("Categories: ");
//            for (PostCategories postCategories : categories){
//                System.out.println("   "+postCategories.getCategory());
//            }
//            ArrayList<Image> images = DaoFactory.getImagesDao().findByPostId(postId);
//            System.out.println("Images: ");
//            for (Image image: images){
//                System.out.println("   Image description: "+ image.getDescription());
//                System.out.println("   image link: "+ image.getUrl());
//            }
//            int commentsId= (int) postId;
//            List<Comment> comments=DaoFactory.getCommentsDao().all(commentsId);
//            System.out.println("Comments");
//            for (Comment comment : comments){
//                System.out.println("   Post #"+comment.getPostId() +": "+comment.getUserId()+": "+ comment.getContent());
//            }


//        List<Ad> ads = DaoFactory.getAdsDao().all();
//        for(Ad ad : ads){
//            long postId=ad.getId();
//            ArrayList<PostCategories> categories = DaoFactory.getPostsCategoriesDao().findByPostId(postId);
//            ad.setCategories(categories);
//            ArrayList<Image> images = DaoFactory.getImagesDao().findByPostId(postId);
//            ad.setImages(images);
//            int commentsId= (int) postId;
//            List<Comment> comments=DaoFactory.getCommentsDao().all(commentsId);
//            ad.setComments(comments);


//        };
//    String password="password";
//
//    //String hashedPassword="$2a$12$Fbm47FETSxu083hgKNPwUO5ACrBJ/vHuAKrcHtKjabdQHXN.sMTAS";
//    String hashedPassword="$2a$12$EB7i6A0P2GP0g/AzFjpd8u5I5GmItmGkqJN.DogOzSf6OCq5yGnB.";

        List<Ad> ads = DaoFactory.getAdsDao().search("Cha");
        for (Ad ad : ads){
            System.out.println(ad.getTitle());
        }











    }
}
