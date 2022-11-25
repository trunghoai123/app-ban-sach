package com.example.demo.service;

import java.util.List;

import javax.annotation.PostConstruct;

import com.example.demo.dao.SachRepository;
import com.example.demo.entity.Sach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SachServiceImp implements SachService {
	static String url_billing = "http://localhost:8082/cart";
	private static RestTemplate RestTemplate = new RestTemplate();
	private final String SACH_CACHE = "SACH";

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	private HashOperations<String, String, Sach> hashOperations;

	@Autowired
	private SachRepository sachRepository;

	@PostConstruct
	private void intializeHashOperations() {
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public List<Sach> findAll() {
		return sachRepository.findAll();
	}

	@Override
	public Sach save(Sach sach) {
		hashOperations.put(SACH_CACHE, sach.getTenSach(), sach);
		return sachRepository.save(sach);
	}

//    @Override
//    public List<Sach> getSachsByMaAndLoai(String maSach, int maLoai) {
//        return sachRepository.getSachsByTenVaLoai(maSach, maLoai);
//    }
  @Override
  public List<Sach> getSachsBySearch(String tenSach, String maLoai, String giaTu, String giaDen, String sort) {
  	if(sort.equals("asc") || sort == null) {
          if(maLoai != null) { // có mã loại
          	if(tenSach != null) {
          		if(giaTu != null && giaDen != null) {
          			return sachRepository.getSachsByKhoangGiaVaLoaiVaTenASC(Double.parseDouble(giaTu),
          					Double.parseDouble(giaDen), Integer.parseInt(maLoai), tenSach);
          		}
          		else if(giaTu != null && giaDen == null) {
             			return sachRepository.getSachsByKhoangGiaTuVaLoaiVaTenASC(Double.parseDouble(giaTu),
             					Integer.parseInt(maLoai), tenSach);
          		}
          		else if(giaTu == null && giaDen != null){
             			return sachRepository.getSachsByKhoangGiaDenVaLoaiVaTenASC(Double.parseDouble(giaDen),
             					Integer.parseInt(maLoai), tenSach);
          		}
          		else {            			
          			return sachRepository.getSachsByTenVaLoaiASC(tenSach, Integer.parseInt(maLoai));
          		}
          	}
          	else{ // ten sach == null
          		if(giaTu != null && giaDen != null) {
          			return sachRepository.getSachsByKhoangGiaVaLoaiASC(Double.parseDouble(giaTu),
          					Double.parseDouble(giaDen), Integer.parseInt(maLoai));
          		}
          		else if(giaTu != null && giaDen == null) {
          			return sachRepository.getSachsByKhoangGiaTuVaLoaiASC(Double.parseDouble(giaTu), Integer.parseInt(maLoai));
          		}
          		else if(giaTu == null && giaDen != null){
          			return sachRepository.getSachsByKhoangGiaDenVaLoaiASC(Double.parseDouble(giaDen), Integer.parseInt(maLoai));
          		}
          		else{ // if(giaTu == null && giaDen == null)
          			return sachRepository.getSachsByLoaiASC(Integer.parseInt(maLoai));
          		}
          	}
          } // không có mã loại
          else { 
          	if(tenSach != null) {
          		if(giaTu != null && giaDen != null) {
          			return sachRepository.getSachsByKhoangGiaVaTenASC(Double.parseDouble(giaTu),
          					Double.parseDouble(giaDen), tenSach);
          		}
          		else if(giaTu != null && giaDen == null) {
             			return sachRepository.getSachsByKhoangGiaTuVaTenASC(Double.parseDouble(giaTu), tenSach);
          		}
          		else if(giaTu == null && giaDen != null){
             			return sachRepository.getSachsByKhoangGiaDenVaTenASC(Double.parseDouble(giaDen), tenSach);
          		}
          		else {            			
          			return sachRepository.getSachsByTenASC(tenSach);
          		}
          	}
          	else{ // ten sach == null
          		if(giaTu != null && giaDen != null) {
          			return sachRepository.getSachsByKhoangGiaASC(Double.parseDouble(giaTu),Double.parseDouble(giaDen));
          		}
          		else if(giaTu != null && giaDen == null) {
          			return sachRepository.getSachsByKhoangGiaTuASC(Double.parseDouble(giaTu));
          		}
          		else if(giaTu == null && giaDen != null){
          			return sachRepository.getSachsByKhoangGiaDenASC(Double.parseDouble(giaDen));
          		}
          		else{ // if(giaTu == null && giaDen == null)
          			return sachRepository.findAll(); // không mã, không loại, không giá
          		}
          	}
          }
  	}
  	else if(sort.equals("desc") ) {
  		 // sort == "desc"
 		 if(maLoai != null) { // có mã loại
          	if(tenSach != null) {
          		if(giaTu != null && giaDen != null) {
          			return sachRepository.getSachsByKhoangGiaVaLoaiVaTenDESC(Double.parseDouble(giaTu),
          					Double.parseDouble(giaDen), Integer.parseInt(maLoai), tenSach);
          		}
          		else if(giaTu != null && giaDen == null) {
             			return sachRepository.getSachsByKhoangGiaTuVaLoaiVaTenDESC(Double.parseDouble(giaTu),
             					Integer.parseInt(maLoai), tenSach);
          		}
          		else if(giaTu == null && giaDen != null){
             			return sachRepository.getSachsByKhoangGiaDenVaLoaiVaTenDESC(Double.parseDouble(giaDen),
             					Integer.parseInt(maLoai), tenSach);
          		}
          		else {            			
          			return sachRepository.getSachsByTenVaLoaiDESC(tenSach, Integer.parseInt(maLoai));
          		}
          	}
          	else{ // ten sach == null
          		if(giaTu != null && giaDen != null) {
          			return sachRepository.getSachsByKhoangGiaVaLoaiDESC(Double.parseDouble(giaTu),
          					Double.parseDouble(giaDen), Integer.parseInt(maLoai));
          		}
          		else if(giaTu != null && giaDen == null) {
          			return sachRepository.getSachsByKhoangGiaTuVaLoaiDESC(Double.parseDouble(giaTu), Integer.parseInt(maLoai));
          		}
          		else if(giaTu == null && giaDen != null){
          			return sachRepository.getSachsByKhoangGiaDenVaLoaiDESC(Double.parseDouble(giaDen), Integer.parseInt(maLoai));
          		}
          		else{ // if(giaTu == null && giaDen == null)
          			return sachRepository.getSachsByLoaiDESC(Integer.parseInt(maLoai));
          		}
          	}
          } // không có mã loại
          else { 
          	if(tenSach != null) {
          		if(giaTu != null && giaDen != null) {
          			return sachRepository.getSachsByKhoangGiaVaTenDESC(Double.parseDouble(giaTu),
          					Double.parseDouble(giaDen), tenSach);
          		}
          		else if(giaTu != null && giaDen == null) {
             			return sachRepository.getSachsByKhoangGiaTuVaTenDESC(Double.parseDouble(giaTu), tenSach);
          		}
          		else if(giaTu == null && giaDen != null){
             			return sachRepository.getSachsByKhoangGiaDenVaTenDESC(Double.parseDouble(giaDen), tenSach);
          		}
          		else {            			
          			return sachRepository.getSachsByTenASC(tenSach);
          		}
          	}
          	else{ // ten sach == null
          		if(giaTu != null && giaDen != null) {
          			return sachRepository.getSachsByKhoangGiaDESC(Double.parseDouble(giaTu),Double.parseDouble(giaDen));
          		}
          		else if(giaTu != null && giaDen == null) {
          			return sachRepository.getSachsByKhoangGiaTuDESC(Double.parseDouble(giaTu));
          		}
          		else if(giaTu == null && giaDen != null){
          			return sachRepository.getSachsByKhoangGiaDenDESC(Double.parseDouble(giaDen));
          		}
          		else{ // if(giaTu == null && giaDen == null)
          			return sachRepository.findAll(); // không mã, không loại, không giá
          		}
          	}
          }
  	}
  	else if(sort.equals("pdesc") ) {
        if(maLoai != null) { // có mã loại
             if(tenSach != null) {
                if(giaTu != null && giaDen != null) {
                   return sachRepository.getSachsByKhoangGiaVaLoaiVaTenPriceDESC(Double.parseDouble(giaTu),
                         Double.parseDouble(giaDen), Integer.parseInt(maLoai), tenSach);
                }
                else if(giaTu != null && giaDen == null) {
                      return sachRepository.getSachsByKhoangGiaTuVaLoaiVaTenPriceDESC(Double.parseDouble(giaTu),
                            Integer.parseInt(maLoai), tenSach);
                }
                else if(giaTu == null && giaDen != null){
                      return sachRepository.getSachsByKhoangGiaDenVaLoaiVaTenPriceDESC(Double.parseDouble(giaDen),
                            Integer.parseInt(maLoai), tenSach);
                }
                else {            			
                   return sachRepository.getSachsByTenVaLoaiPriceDESC(tenSach, Integer.parseInt(maLoai));
                }
             }
             else{ // ten sach == null
                if(giaTu != null && giaDen != null) {
                   return sachRepository.getSachsByKhoangGiaVaLoaiPriceDESC(Double.parseDouble(giaTu),
                         Double.parseDouble(giaDen), Integer.parseInt(maLoai));
                }
                else if(giaTu != null && giaDen == null) {
                   return sachRepository.getSachsByKhoangGiaTuVaLoaiPriceDESC(Double.parseDouble(giaTu), Integer.parseInt(maLoai));
                }
                else if(giaTu == null && giaDen != null){
                   return sachRepository.getSachsByKhoangGiaDenVaLoaiPriceDESC(Double.parseDouble(giaDen), Integer.parseInt(maLoai));
                }
                else{ // if(giaTu == null && giaDen == null)
                   return sachRepository.getSachsByLoaiPriceDESC(Integer.parseInt(maLoai));
                }
             }
          } // không có mã loại
          else { 
             if(tenSach != null) {
                if(giaTu != null && giaDen != null) {
                   return sachRepository.getSachsByKhoangGiaVaTenPriceDESC(Double.parseDouble(giaTu),
                         Double.parseDouble(giaDen), tenSach);
                }
                else if(giaTu != null && giaDen == null) {
                      return sachRepository.getSachsByKhoangGiaTuVaTenPriceDESC(Double.parseDouble(giaTu), tenSach);
                }
                else if(giaTu == null && giaDen != null){
                      return sachRepository.getSachsByKhoangGiaDenVaTenPriceDESC(Double.parseDouble(giaDen), tenSach);
                }
                else {            			
                   return sachRepository.getSachsByTenASC(tenSach);
                }
             }
             else{ // ten sach == null
                if(giaTu != null && giaDen != null) {
                   return sachRepository.getSachsByKhoangGiaPriceDESC(Double.parseDouble(giaTu),Double.parseDouble(giaDen));
                }
                else if(giaTu != null && giaDen == null) {
                   return sachRepository.getSachsByKhoangGiaTuPriceDESC(Double.parseDouble(giaTu));
                }
                else if(giaTu == null && giaDen != null){
                   return sachRepository.getSachsByKhoangGiaDenPriceDESC(Double.parseDouble(giaDen));
                }
                else{ // if(giaTu == null && giaDen == null)
                   return sachRepository.findAll(); // không mã, không loại, không giá
                }
             }
          }
  	}
  	else { // pasc

          if(maLoai != null) { // có mã loại
          	if(tenSach != null) {
          		if(giaTu != null && giaDen != null) {
          			return sachRepository.getSachsByKhoangGiaVaLoaiVaTenPriceASC(Double.parseDouble(giaTu),
          					Double.parseDouble(giaDen), Integer.parseInt(maLoai), tenSach);
          		}
          		else if(giaTu != null && giaDen == null) {
             			return sachRepository.getSachsByKhoangGiaTuVaLoaiVaTenPriceASC(Double.parseDouble(giaTu),
             					Integer.parseInt(maLoai), tenSach);
          		}
          		else if(giaTu == null && giaDen != null){
             			return sachRepository.getSachsByKhoangGiaDenVaLoaiVaTenPriceASC(Double.parseDouble(giaDen),
             					Integer.parseInt(maLoai), tenSach);
          		}
          		else {            			
          			return sachRepository.getSachsByTenVaLoaiPriceASC(tenSach, Integer.parseInt(maLoai));
          		}
          	}
          	else{ // ten sach == null
          		if(giaTu != null && giaDen != null) {
          			return sachRepository.getSachsByKhoangGiaVaLoaiPriceASC(Double.parseDouble(giaTu),
          					Double.parseDouble(giaDen), Integer.parseInt(maLoai));
          		}
          		else if(giaTu != null && giaDen == null) {
          			return sachRepository.getSachsByKhoangGiaTuVaLoaiPriceASC(Double.parseDouble(giaTu), Integer.parseInt(maLoai));
          		}
          		else if(giaTu == null && giaDen != null){
          			return sachRepository.getSachsByKhoangGiaDenVaLoaiPriceASC(Double.parseDouble(giaDen), Integer.parseInt(maLoai));
          		}
          		else{ // if(giaTu == null && giaDen == null)
          			return sachRepository.getSachsByLoaiPriceASC(Integer.parseInt(maLoai));
          		}
          	}
          } // không có mã loại
          else { 
          	if(tenSach != null) {
          		if(giaTu != null && giaDen != null) {
          			return sachRepository.getSachsByKhoangGiaVaTenPriceASC(Double.parseDouble(giaTu),
          					Double.parseDouble(giaDen), tenSach);
          		}
          		else if(giaTu != null && giaDen == null) {
             			return sachRepository.getSachsByKhoangGiaTuVaTenPriceASC(Double.parseDouble(giaTu), tenSach);
          		}
          		else if(giaTu == null && giaDen != null){
             			return sachRepository.getSachsByKhoangGiaDenVaTenPriceASC(Double.parseDouble(giaDen), tenSach);
          		}
          		else {            			
          			return sachRepository.getSachsByTenPriceASC(tenSach);
          		}
          	}
          	else{ // ten sach == null
          		if(giaTu != null && giaDen != null) {
          			return sachRepository.getSachsByKhoangGiaPriceASC(Double.parseDouble(giaTu),Double.parseDouble(giaDen));
          		}
          		else if(giaTu != null && giaDen == null) {
          			return sachRepository.getSachsByKhoangGiaTuPriceASC(Double.parseDouble(giaTu));
          		}
          		else if(giaTu == null && giaDen != null){
          			return sachRepository.getSachsByKhoangGiaDenPriceASC(Double.parseDouble(giaDen));
          		}
          		else{ // if(giaTu == null && giaDen == null)
          			return sachRepository.findAll(); // không mã, không loại, không giá
          		}
          	}
          }
  	}
  }
//	@Override
//	public List<Sach> getSachsBySearch(String tenSach, String maLoai, String giaTu, String giaDen, String sort) {
//		if (sort.equals("asc") || sort == null) {
//			if (maLoai != null) { // có mã loại
//				if (tenSach != null) {
//					if (giaTu != null && giaDen != null) {
//						return sachRepository.getSachsByKhoangGiaVaLoaiVaTenASC(Double.parseDouble(giaTu),
//								Double.parseDouble(giaDen), Integer.parseInt(maLoai), tenSach);
//					} else if (giaTu != null && giaDen == null) {
//						return sachRepository.getSachsByKhoangGiaTuVaLoaiVaTenASC(Double.parseDouble(giaTu),
//								Integer.parseInt(maLoai), tenSach);
//					} else if (giaTu == null && giaDen != null) {
//						return sachRepository.getSachsByKhoangGiaDenVaLoaiVaTenASC(Double.parseDouble(giaDen),
//								Integer.parseInt(maLoai), tenSach);
//					} else {
//						return sachRepository.getSachsByTenVaLoaiASC(tenSach, Integer.parseInt(maLoai));
//					}
//				} else { // ten sach == null
//					if (giaTu != null && giaDen != null) {
//						return sachRepository.getSachsByKhoangGiaVaLoaiASC(Double.parseDouble(giaTu),
//								Double.parseDouble(giaDen), Integer.parseInt(maLoai));
//					} else if (giaTu != null && giaDen == null) {
//						return sachRepository.getSachsByKhoangGiaTuVaLoaiASC(Double.parseDouble(giaTu),
//								Integer.parseInt(maLoai));
//					} else if (giaTu == null && giaDen != null) {
//						return sachRepository.getSachsByKhoangGiaDenVaLoaiASC(Double.parseDouble(giaDen),
//								Integer.parseInt(maLoai));
//					} else { // if(giaTu == null && giaDen == null)
//						return sachRepository.getSachsByLoaiASC(Integer.parseInt(maLoai));
//					}
//				}
//			} // không có mã loại
//			else {
//				if (tenSach != null) {
//					if (giaTu != null && giaDen != null) {
//						return sachRepository.getSachsByKhoangGiaVaTenASC(Double.parseDouble(giaTu),
//								Double.parseDouble(giaDen), tenSach);
//					} else if (giaTu != null && giaDen == null) {
//						return sachRepository.getSachsByKhoangGiaTuVaTenASC(Double.parseDouble(giaTu), tenSach);
//					} else if (giaTu == null && giaDen != null) {
//						return sachRepository.getSachsByKhoangGiaDenVaTenASC(Double.parseDouble(giaDen), tenSach);
//					} else {
//						return sachRepository.getSachsByTenASC(tenSach);
//					}
//				} else { // ten sach == null
//					if (giaTu != null && giaDen != null) {
//						return sachRepository.getSachsByKhoangGiaASC(Double.parseDouble(giaTu),
//								Double.parseDouble(giaDen));
//					} else if (giaTu != null && giaDen == null) {
//						return sachRepository.getSachsByKhoangGiaTuASC(Double.parseDouble(giaTu));
//					} else if (giaTu == null && giaDen != null) {
//						return sachRepository.getSachsByKhoangGiaDenASC(Double.parseDouble(giaDen));
//					} else { // if(giaTu == null && giaDen == null)
//						return sachRepository.findAll(); // không mã, không loại, không giá
//					}
//				}
//			}
//		} else if (sort.equals("desc")) {
//			// sort == "desc"
//			if (maLoai != null) { // có mã loại
//				if (tenSach != null) {
//					if (giaTu != null && giaDen != null) {
//						return sachRepository.getSachsByKhoangGiaVaLoaiVaTenDESC(Double.parseDouble(giaTu),
//								Double.parseDouble(giaDen), Integer.parseInt(maLoai), tenSach);
//					} else if (giaTu != null && giaDen == null) {
//						return sachRepository.getSachsByKhoangGiaTuVaLoaiVaTenDESC(Double.parseDouble(giaTu),
//								Integer.parseInt(maLoai), tenSach);
//					} else if (giaTu == null && giaDen != null) {
//						return sachRepository.getSachsByKhoangGiaDenVaLoaiVaTenDESC(Double.parseDouble(giaDen),
//								Integer.parseInt(maLoai), tenSach);
//					} else {
//						return sachRepository.getSachsByTenVaLoaiDESC(tenSach, Integer.parseInt(maLoai));
//					}
//				} else { // ten sach == null
//					if (giaTu != null && giaDen != null) {
//						return sachRepository.getSachsByKhoangGiaVaLoaiDESC(Double.parseDouble(giaTu),
//								Double.parseDouble(giaDen), Integer.parseInt(maLoai));
//					} else if (giaTu != null && giaDen == null) {
//						return sachRepository.getSachsByKhoangGiaTuVaLoaiDESC(Double.parseDouble(giaTu),
//								Integer.parseInt(maLoai));
//					} else if (giaTu == null && giaDen != null) {
//						return sachRepository.getSachsByKhoangGiaDenVaLoaiDESC(Double.parseDouble(giaDen),
//								Integer.parseInt(maLoai));
//					} else { // if(giaTu == null && giaDen == null)
//						return sachRepository.getSachsByLoaiDESC(Integer.parseInt(maLoai));
//					}
//				}
//			} // không có mã loại
//			else {
//				if (tenSach != null) {
//					if (giaTu != null && giaDen != null) {
//						return sachRepository.getSachsByKhoangGiaVaTenDESC(Double.parseDouble(giaTu),
//								Double.parseDouble(giaDen), tenSach);
//					} else if (giaTu != null && giaDen == null) {
//						return sachRepository.getSachsByKhoangGiaTuVaTenDESC(Double.parseDouble(giaTu), tenSach);
//					} else if (giaTu == null && giaDen != null) {
//						return sachRepository.getSachsByKhoangGiaDenVaTenDESC(Double.parseDouble(giaDen), tenSach);
//					} else {
//						return sachRepository.getSachsByTenASC(tenSach);
//					}
//				} else { // ten sach == null
//					if (giaTu != null && giaDen != null) {
//						return sachRepository.getSachsByKhoangGiaDESC(Double.parseDouble(giaTu),
//								Double.parseDouble(giaDen));
//					} else if (giaTu != null && giaDen == null) {
//						return sachRepository.getSachsByKhoangGiaTuDESC(Double.parseDouble(giaTu));
//					} else if (giaTu == null && giaDen != null) {
//						return sachRepository.getSachsByKhoangGiaDenDESC(Double.parseDouble(giaDen));
//					} else { // if(giaTu == null && giaDen == null)
//						return sachRepository.findAll(); // không mã, không loại, không giá
//					}
//				}
//			}
//		}
//		return null;
//	}

	@Override
	public Sach getSachByMaSach(int maSach) {
		return sachRepository.getSachByMaSach(maSach);
	}

	@Override
	public Sach getSachInCache(int maSach) {
		Sach sach = sachRepository.getSachByMaSach(maSach);
		return hashOperations.get(SACH_CACHE, sach.getTenSach());
	}

	@Override
	public List<Sach> getSachByKhoanGia(double giaMin, double giaMax) {
		// TODO Auto-generated method stub
		return sachRepository.getSachByKhoanGia(giaMin, giaMax);
	}

	@Override
	public List<Sach> getSachsByNameASC() {
		// TODO Auto-generated method stub
		return sachRepository.getSachsByNameASC();
	}

	@Override
	public List<Sach> getSachsByNameDESC() {
		// TODO Auto-generated method stub
		return sachRepository.getSachsByNameDESC();
	}

	@Override
	public List<Sach> getSachByTenLoaiSach(String tenLoai) {
		// TODO Auto-generated method stub
		return sachRepository.getSachsByTenLoaiSach(tenLoai);
	}

	@Override
	public List<Sach> getSachsByTenSach(String tenSach) {
		return sachRepository.getSachsByTenSach("%" + tenSach + "%");
	}

	@Override
	public List<Sach> getSachByMaNXB(int maNXB) {
		return sachRepository.getSachsByNXB(maNXB);
	}

	@Override
	public List<Sach> getSachByTenNXB(String tenNXB) {
		return sachRepository.findSachByTenNXB(tenNXB);
	}

}
