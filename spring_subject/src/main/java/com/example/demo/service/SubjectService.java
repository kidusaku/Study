package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SubjectMapper;
import com.example.demo.entity.SubjectEntity;

/**
* 科目情報 Service
*/
@Service
public class SubjectService {
  /**
   * 科目情報 Mapper
   */
  @Autowired
  private SubjectMapper subjectMapper;

  /**
   * 科目情報 全検索
   * @return  検索結果
   */
  public List<SubjectEntity> searchAll() {
      return subjectMapper.findAll();
  }
}