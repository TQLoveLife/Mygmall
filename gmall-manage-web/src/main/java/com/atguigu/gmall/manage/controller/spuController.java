package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.beans.PmsBaseSaleAttr;
import com.atguigu.gmall.beans.PmsProductInfo;
import com.atguigu.gmall.beans.PmsProductSaleAttr;
import com.atguigu.gmall.service.PmsBaseSaleAttrService;
import com.atguigu.gmall.service.SpuSaleAttrService;
import com.atguigu.gmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class spuController {

    @Reference
    private SpuService spuService;

    @Reference
    private SpuSaleAttrService spuSaleAttrService;

    @Reference
    private PmsBaseSaleAttrService pmsBaseSaleAttrService;

    @ResponseBody
    @RequestMapping("spuImageList")
    public String spuImageList(String spuId){

        return  "木有图片哦";
    }

    @ResponseBody
    @RequestMapping("spuList")
    public List<PmsProductInfo> spuList(String catalog3Id){

        List<PmsProductInfo> pmsProductInfos = spuService.spuList(catalog3Id);
        return  pmsProductInfos;
    }

    @ResponseBody
    @RequestMapping("baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList(){

        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = pmsBaseSaleAttrService.baseSaleAttrList();
        return  pmsBaseSaleAttrs;
    }

    @ResponseBody
    @RequestMapping("saveSpuInfo")
    public  String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){

        spuService.saveSpuInfo(pmsProductInfo);
        return  "happy";
    }

    @ResponseBody
    @RequestMapping("spuSaleAttrList")
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId){
        List<PmsProductSaleAttr> pmsProductSaleAttrs = spuSaleAttrService.spuSaleAttrList(spuId);
        return pmsProductSaleAttrs;
    }

}
