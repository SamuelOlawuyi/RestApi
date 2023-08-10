package com.example.classactivity.services.servicesInterfaces;


import com.example.classactivity.entities.Commentfac;
import com.example.classactivity.entities.FacebookUser;

import java.util.List;

public interface ICommentServices {

    Commentfac createComment(Long postId, String commentText, FacebookUser user);
    List<Commentfac> getCommentsByPostId(Long postId);
}

