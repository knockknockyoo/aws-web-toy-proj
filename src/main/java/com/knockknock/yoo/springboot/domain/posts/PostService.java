package com.knockknock.yoo.springboot.domain.posts;

import com.knockknock.yoo.springboot.web.dto.PostsResponseDto;
import com.knockknock.yoo.springboot.web.dto.PostsSaveRequestDto;
import com.knockknock.yoo.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts entity = postsRepository.findOne(id);
        if (entity.equals(null)) throw new IllegalArgumentException("no post found id="+ id);
        entity.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findOne(id);
        if (entity.equals(null)) throw new IllegalArgumentException("no post found id="+ id);
        return new PostsResponseDto(entity);

    }
}
