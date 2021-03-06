package com.knockknock.yoo.springboot.domain.posts;

import com.knockknock.yoo.springboot.web.dto.PostsResponseDto;
import com.knockknock.yoo.springboot.web.dto.PostsSaveRequestDto;
import com.knockknock.yoo.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found post id=" + id));
        entity.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found post id="+ id));
        return new PostsResponseDto(entity);
    }

    // TODO readonly available?
    @Transactional
    public List<PostsResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsResponseDto::new)
                .collect(Collectors.toList());
    }
}
