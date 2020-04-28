package om.changgou.goods.service.BrandService;

import com.github.pagehelper.Page;
import om.changgou.goods.pojo.Brand;

import java.util.HashMap;
import java.util.List;

/**
 * @author : Gordon Zhang
 * @Date: 4/24/2020 10:25 AM
 * @Version 1.0
 */
public interface BrandService {
    /**
     * @return
     */
    public List<Brand> findAll();

    /**
     * @param id
     * @return
     */
    public Brand findById(Integer id);

    // TODO: 4/24/2020

    /***
     * 新增品牌
     * @param brand
     */
    public void addBrand(Brand brand);
    // TODO: 4/24/2020  

    /***
     * 修改品牌数据
     * @param brand
     */

    public void updateBrand(Brand brand);
    // TODO: 4/24/2020

    /***
     * 删除品牌
     * @param id
     */

    public void deleteBrand(Integer id);
    // TODO: 4/24/2020

    /***
     * 多条件搜索品牌方法
     * @param searchMap
     * @return
     */

    public List<Brand> findList(HashMap<String, Object> searchMap);
    // TODO: 4/24/2020

    /***
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    public Page<Brand> findPage(int page, int size);
    // TODO: 4/24/2020

    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */

    public Page<Brand> findPage(HashMap<String, Object> searchMap, int page, int size);

    public List<HashMap> findListByCategoryName(String categoryName);

}
