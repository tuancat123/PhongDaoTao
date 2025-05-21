package com.example.phongdaotao.Converter;

import com.example.phongdaotao.Entity.KhoiKienThuc;
import com.example.phongdaotao.Repository.KhoiKienThucRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class KhoiKienThucConverter implements Converter<String, KhoiKienThuc> {

    private final KhoiKienThucRepository repository;

    public KhoiKienThucConverter(KhoiKienThucRepository repository) {
        this.repository = repository;
    }

    @Override
    public KhoiKienThuc convert(String source) {
        try {
            int id = Integer.parseInt(source);
            return repository.findById(id).orElse(null);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
