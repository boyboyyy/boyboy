package com.boy.service.impl;

import com.boy.domain.bo.FruitPagingToGetDataBo;
import com.boy.domain.vo.ResponseVo;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.boy.domain.Fruit;
import com.boy.mapper.FruitMapper;
import com.boy.service.FruitService;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService{

    @Autowired
    private FruitMapper fruitMapper;

    @Override
    public ResponseVo deleteByPrimaryKey(Long id) {

        boolean b = fruitMapper.deleteByPrimaryKey(id) > 0;

        if (!b){
            new ResponseVo("删除失败，可能不存在此信息", null,"0x500");
        }

        return new ResponseVo("删除成功", null,"0x200");
    }

    @Override
    public ResponseVo insertSelective(Fruit record) {

        int insert = fruitMapper.insertSelective(record);

        if (insert == 0){
            new ResponseVo("添加失败，可能不存在此信息", null,"0x500");
        }

        return new ResponseVo("添加成功", null,"0x200");
    }


    @Override
    public ResponseVo selectByPrimaryKey(Long id) {

        Fruit fruit = fruitMapper.selectByPrimaryKey(id);
        if (fruit == null){
            return new ResponseVo("查询失败，可能不存在此信息", null,"0x500");
        }

        return new ResponseVo("查询成功", fruit,"0x200");

    }

    @Override
    public ResponseVo updateByPrimaryKeySelective(Fruit record) {

        int update = fruitMapper.updateByPrimaryKeySelective(record);

        if (update == 0){
            new ResponseVo("修改失败，可能不存在此信息", null,"0x500");
        }

        return new ResponseVo("修改成功", null,"0x200");
    }

    /**
     * 分页查询
     *
     * @param guide 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public ResponseVo queryByPage(FruitPagingToGetDataBo fruitPagingToGetDataBo) {
////        String userId = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
////        System.out.println(userId);
//        Fruit fruit = fruitPagingToGetDataBo.getFruit();
//        if (fruit==null){
//            fruit = new Fruit();
//        }
////        guide.setCreateBy(Long.valueOf(userId));
//
//        List<FruitPagingToData> fileList = guideMapper.guidePagingToGetUserData(guidePagingToGetDataBo.getStart(),guidePagingToGetDataBo.getSize(),guidePagingToGetDataBo.getGuide());
//        Long count = guideMapper.getCount(guidePagingToGetDataBo.getGuide());
////        System.out.println(count);
//
////        HashMap<String,Object> map = new HashMap<>();
////        map.put("count",count);
////        map.put("list",fileList);
//
//        return new ResponseVo("查询成功",new GuidePagingToGetDataVo(fileList,Math.toIntExact(count)),"0x200");
//    }


}
