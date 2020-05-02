//package com.course.work.cdrent.infocd.service;
//
//import com.course.work.cdrent.cd.entity.CDEntity;
//import com.course.work.cdrent.cd.repository.CDRepository;
//import com.course.work.cdrent.genre.entity.GenreCdEntity;
//import com.course.work.cdrent.genre.repository.GenreCdRepository;
//import com.course.work.cdrent.infocd.dto.InfoCdDto;
//import com.course.work.cdrent.listgenre.entity.ListGenreEntity;
//import com.course.work.cdrent.listgenre.repository.ListGenreRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class InfoCdService {
//    private final CDRepository cdRepository;
//    private final ListGenreRepository listGenreRepository;
//    private final GenreCdRepository genreCdRepository;
//
//    public List<InfoCdDto> get() {
//        List<CDEntity> cds = cdRepository.findAll();
//        List<ListGenreEntity> genres = listGenreRepository.findAll();
//        List<GenreCdEntity> cdGenges = genreCdRepository.findAll();
//
//        Map<Integer, InfoCdDto> map = new HashMap<>();
//
//        cds.forEach(cd -> map.put(cd.getNumCd(),
//                new InfoCdDto(cd.getTitle(),
//                        cd.getReleaseYear(),
//                        cd.getCost(),
//                        cd.getCount(),
//                        null)));
//
//        map.keySet().stream().forEach(key -> {
//            cdGenges.stream().filter(e -> e.getNumCd() == key);
//        });
//
//    }
//}
