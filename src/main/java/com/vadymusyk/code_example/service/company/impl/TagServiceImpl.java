package com.vadymusyk.code_example.service.company.impl;

import com.vadymusyk.code_example.entity.company.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag getTagById(Long tagId) {
        return Optional.ofNullable(tagRepository.findOne(tagId))
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Tag addTag(String tag) {
        return tagRepository.save(new Tag(tag.toLowerCase()));
    }

    @Override
    public List<Tag> findAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag updateTag(long tagId, String tag) {
        Tag tagById = getTagById(tagId);
        tagById.setTag(tag);
        return tagRepository.save(tagById);
    }

    @Override
    public void deleteTag(long tagId) {
        Tag tagById = getTagById(tagId);
        tagRepository.delete(tagById);
    }
}
