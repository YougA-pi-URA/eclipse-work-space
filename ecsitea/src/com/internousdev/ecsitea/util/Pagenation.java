package com.internousdev.ecsitea.util;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsitea.dto.PagenationDTO;
import com.internousdev.ecsitea.dto.ProductInfoDTO;

public class Pagenation {

	public PagenationDTO initialize(List<ProductInfoDTO> list, int pageSize){

		PagenationDTO dto = new PagenationDTO();

		dto.setTotalPageSize((int)(Math.ceil(list.size() / pageSize)));

		dto.setCurrentPageNo(1);

		dto.setTotalRecordSize(list.size() - 1);

		dto.setStartRecordNo(pageSize * (dto.getCurrentPageNo() - 1));

		dto.setEndRecordNo(dto.getStartRecordNo() + (pageSize - 1));

		List<Integer> pageNumberList = new ArrayList<Integer>();
		for(int pageNumber = 1; pageNumber <= dto.getTotalPageSize(); pageNumber++){
			pageNumberList.add(pageNumber);
		}

		List<ProductInfoDTO> productInfoPages = new ArrayList<ProductInfoDTO>();
		for(int pageNumberOffset = dto.getStartRecordNo(); pageNumberOffset <= dto.getEndRecordNo(); pageNumberOffset++){
			productInfoPages.add(list.get(pageNumberOffset));
		}
		dto.setCurrentProductInfoPage(productInfoPages);

		if((dto.getStartRecordNo() - 1) <= 0){
			dto.setHasPreviusPage(false);
		}else{
			dto.setHasPreviusPage(true);
			dto.setPreviusPageNo(dto.getCurrentPageNo() - 1);
		}

		if(dto.getEndRecordNo() + pageSize > dto.getTotalRecordSize()){
			dto.setHasNextPage(false);
		}else{
			dto.setHasNextPage(true);
			dto.setNextPageNo(dto.getCurrentPageNo() + 1);
		}
		return dto;
	}


	public PagenationDTO getPage(List<ProductInfoDTO> list, int pageSize, String pageNo){

		PagenationDTO dto = new PagenationDTO();

		dto.setTotalPageSize((int)(Math.ceil(list.size() / pageSize)));

		dto.setCurrentPageNo(Integer.parseInt(pageNo));

		dto.setTotalRecordSize(list.size() - 1);

		dto.setStartRecordNo(pageSize * (dto.getCurrentPageNo() - 1));



		dto.setEndRecordNo(dto.getStartRecordNo() + (pageSize - 1));

		List<Integer> pageNumberList = new ArrayList<Integer>();
		for(int pageNumber = 1; pageNumber <= dto.getTotalPageSize(); pageNumber++){
			pageNumberList.add(pageNumber);
		}

		List<ProductInfoDTO> productInfoPages = new ArrayList<ProductInfoDTO>();
		for(int pageNumberOffset = dto.getStartRecordNo(); pageNumberOffset <= dto.getEndRecordNo();pageNumberOffset++){
			productInfoPages.add(list.get(pageNumberOffset));
		}
		dto.setCurrentProductInfoPage(productInfoPages);

		if((dto.getStartRecordNo() - 1) <= 0){
			dto.setHasPreviusPage(false);
		}else{
			dto.setHasPreviusPage(true);
			dto.setPreviusPageNo(dto.getCurrentPageNo() - 1);
		}

		if(dto.getEndRecordNo() + pageSize > dto.getTotalRecordSize()){
			dto.setHasNextPage(false);
		}else{
			dto.setHasNextPage(true);
			dto.setNextPageNo(dto.getCurrentPageNo() + 1);
		}

		return dto;
	}

}
