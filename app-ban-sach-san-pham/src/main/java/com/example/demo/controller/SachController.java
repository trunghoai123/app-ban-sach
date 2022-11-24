package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.SachRepository;
import com.example.demo.entity.LoaiSach;
import com.example.demo.entity.Sach;
import com.example.demo.service.LoaiSachService;
import com.example.demo.service.NhaXuatBanService;
import com.example.demo.service.SachService; 

@RestController
@RequestMapping("/sach")
public class SachController {
   
    @Autowired
    private SachService sachService;
    @Autowired
    private NhaXuatBanService nxbService;
    @Autowired
    private LoaiSachService loaiSachService;
    
//    http://localhost:8088/api/sachs
    @GetMapping("/sachs")
    public List<Sach> findAllSach(){
    	List<Sach> sachs = sachService.findAll();
    	if(sachs.size() > 0) {
    		sachs.forEach((sach) -> {
    			System.out.println(sach);
    		});
    	}
        return sachs;
    }
    
//  http://localhost:8081/sach/sachs/find?maSach=2
  @GetMapping("/sachs/find")
  public Sach findSachByMaSach(@RequestParam("maSach") int maSach) {
      return sachService.getSachByMaSach(maSach);
  }
    
    //http://localhost:8081/sach/sachs/cache?maSach=71
    @GetMapping("/sachs/cache")
    public Sach getSachInCache(@RequestParam("maSach") int maSach) {
  	  return sachService.getSachInCache(maSach);
    }
    
    //http://localhost:8081/sach/sachs/search?tenSach=h&maLoai=5&giaTu=10000&giaDen=250000&sort=desc
    //http://localhost:8081/sach/sachs/search?maLoai=2&giaDen=120000&sort=desc
    //http://localhost:8081/sach/sachs/search?giaTu=10000&sort=asc
    //http://localhost:8081/sach/sachs/search?&maLoai=2&giaTu=50000&giaDen=150000&sort=asc
    // tất cả params đều không bắt buộc
    @GetMapping("/sachs/search")
    public List<Sach> findSachsByTenSach(
    		@RequestParam(name = "tenSach", required = false) String tenSach,
    		@RequestParam(name = "maLoai", required = false) String maLoai,
    		@RequestParam(name = "giaTu", required = false) String giaTu,
    		@RequestParam(name = "giaDen", required = false) String giaDen,
    		@RequestParam(name = "sort", required = false) String sort) {

    	return sachService.getSachsBySearch(tenSach, maLoai, giaTu, giaDen, sort);
    }
    //
//    @GetMapping("/sachs/search/cache")
//    public List<Sach> findSachsByTenSachCache(
//    		@RequestParam(name = "tenSach", required = false) String tenSach,
//    		@RequestParam(name = "maLoai", required = false) String maLoai,
//    		@RequestParam(name = "giaTu", required = false) String giaTu,
//    		@RequestParam(name = "giaDen", required = false) String giaDen,
//    		@RequestParam(name = "sort", required = false) String sort) {
//    	return sachService.getSachsBySearchCache(tenSach, maLoai, giaTu, giaDen, sort);
//    }
    
//    http://localhost:8081/sach/sachs/giaSach?giaMin=100000&giaMax=150000
    @GetMapping("/sachs/giaSach")
    public List<Sach> getSachsByKhoangGia(@RequestParam("giaMin") int giaMin, @RequestParam("giaMax") int giaMax){
        return sachService.getSachByKhoanGia(giaMin, giaMax);
    }
    
//    http://localhost:8081/sach/sachs/sort/asc
    @GetMapping("/sachs/sort/asc")
    public List<Sach> getSachsByNameASC(){
        return sachService.getSachsByNameASC();
    } 
    
//    http://localhost:8081/sach/sachs/sort/desc
    @GetMapping("/sachs/sort/desc")
    public List<Sach> getSachsByNameDESC(){
        return sachService.getSachsByNameDESC();
    }
    
//    http://localhost:8081/sach/loaiSachs
    @GetMapping("/loaiSachs")
    public List<LoaiSach> getLoaiSachs() {   
        return loaiSachService.findAll();
    } 
    
//  http://localhost:8081/sach/sachs/loaiSach?tenLoai=Lịch sử
  @GetMapping("/sachs/loaiSach")
  public List<Sach> getSachByTenLoaiSach(@RequestParam("tenLoai") String tenLoai) {
	  
      return sachService.getSachByTenLoaiSach(tenLoai);
  }

  
  //Get All Sach by maNXB
  //http://localhost:8081/sach/sachs/findSachByNXB?maNXB=1
  @GetMapping("/sachs/findSachByNXB")
  public List<Sach> findSachByMaNXB(@RequestParam("maNXB") int maNXB) {
      return sachService.getSachByMaNXB(maNXB);
  }
  
  
//Get All Sach by tenNXB
  //http://localhost:8081/sach/sachs/findSachByTenNXB?tenNXB=Nhà Xuất Bản Tư Pháp
  @GetMapping("/sachs/findSachByTenNXB")
  public List<Sach> findSachByTenNXB(@RequestParam("tenNXB") String tenNXB) {
	  return sachService.getSachByTenNXB(tenNXB);
  }
  
  
  //http://localhost:8081/sach/sachs/save
//  {
//      "tenSach": "Một thoáng rực rỡ",
//      "tacGia": "Vương Quốc Vinh",
//      "soLuongTon": 6484,
//      "donGia": 96000.0,
//      "hinhAnh": "https://i.imgur.com/PyoarFm.jpg",
//      "maLoai": {
//          "maLoai": 2,
//          "tenLoai": "Kinh Dị"
//      },
//      "maNXB": {
//          "maNXB": 3,
//          "tenNXB": "Nhà Xuất Bản Trẻ"
//      },
//      "cTHoaDon": null
//  }
  @PostMapping("/sachs/save")
  public Sach saveSach(@RequestBody Sach sach) {
	  return sachService.save(sach);
  }
}
