package com.controller.beach;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.dto.BeachDTO;

@Controller
public class BeachController {
	private static String getTagValue(String tag, Element eElement) {
		   NodeList nlList = eElement.getElementsByTagName(tag);
		    if(nlList.item(0)==null)
		    	return null;
		    NodeList nllList=nlList.item(0).getChildNodes();
		    Node nValue = (Node) nllList.item(0);
		    if(nValue == null) 
		        return null;
		    return nValue.getNodeValue();  
	}
	
	@RequestMapping(value = "/beachMapPresent", method = RequestMethod.GET)
	public ModelAndView beachPage(HttpSession session){
		BeachDTO bdto=new BeachDTO("","","","","","","","","","","","","","");
		ModelAndView mav=new ModelAndView();

		mav.addObject("bdto", bdto);
		mav.addObject("loc", "");
		mav.setViewName("beachMapPresent");
		return mav;
	}
	
	@RequestMapping(value = "/Beach", method = RequestMethod.GET)
	public ModelAndView beachInfo2(String staNm, HttpSession session){
		ModelAndView mav=new ModelAndView();
		try {
			System.out.println("받아온 해수욕장이름:"+staNm);
			BeachDTO bdto=(BeachDTO)session.getAttribute(staNm);
			
			if(bdto!=null) {
				mav.addObject("loc", " 위치보기");
			}else {
				mav.addObject("loc", "");
			}
			mav.addObject("bdto", bdto);
			mav.setViewName("beachMapPresent");

		}catch (Exception e) {
			// TODO: handle exception
		}
		return mav;
	}	
	
	@RequestMapping(value="/BeachInfo" ,method=RequestMethod.GET)
	@ResponseBody
	public List<BeachDTO> beachInfo(String sidoNm,HttpSession session){
		List<BeachDTO> list=new ArrayList();
		try {
				sidoNm = URLEncoder.encode(sidoNm, "utf-8");
				System.out.println("변환 한 euc-kr:"+sidoNm);
				String num="500";
				String numOfRows=URLEncoder.encode(num, "utf-8");
				String url="http://apis.data.go.kr/1192000/service/OceansBeachSeawaterService1/getOceansBeachSeawaterInfo1?serviceKey=3Md9YXyRjKEN438TPDzd8itwECgi8TBe%2Bwou4UlrGSG%2Bng6GKCD42ROverxTkZzBT3sNFPWBxIHzQSBu7TQIKw%3D%3D&pageNo=1&numOfRows="+numOfRows+"&SIDO_NM="+sidoNm+"&resultType=xml&RES_YEAR=2019";
				System.out.println(url.toString());
				DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				doc.getDocumentElement().normalize();
				Element element=doc.getDocumentElement();
				System.out.println(doc.getDocumentElement().getNodeName());
				
				NodeList nList=doc.getElementsByTagName("item");
				System.out.println(nList);
				System.out.println("데이터 리스트 갯수 :"+nList.getLength());
				
			
				System.out.println("=================================================================");
				String s = "";
				HashMap<String, String> map=new HashMap<String, String>();
		        map.put("staNm", "비교시작");
				for (int temp = 0; temp < nList.getLength(); temp++) {
					Node nNode=nList.item(temp);
					
					if(nNode.getNodeType()==Node.ELEMENT_NODE) {
						Element eElement=(Element)nNode;
							
						String staNm=getTagValue("staNm", eElement);
		           String staNmC=map.get("staNm");
		           System.out.println("비교결과:"+!staNmC.equals(staNm));
		           if(temp==0||!staNmC.equals(staNm)) {
	           
	               String res1=getTagValue("res1", eElement);
	               String res2=getTagValue("res2", eElement);
	               res1=res1.replace("&lt;", " < ");
	               res2=res2.replace("&lt;", " < ");
	              	BeachDTO bdto=new BeachDTO();
	              bdto.setSidoNm(getTagValue("sidoNm", eElement));
                  bdto.setGugunNm(getTagValue("gugunNm", eElement));
                  bdto.setStaNm(getTagValue("staNm", eElement));
                  bdto.setResNum(getTagValue("resNum", eElement));
                  bdto.setResLoc(getTagValue("resLoc", eElement));
                  bdto.setRes1(res1);
                  bdto.setRes2(res2);
                  bdto.setResYn(getTagValue("resYn", eElement));
                  bdto.setResYear(getTagValue("resYear", eElement));
                  bdto.setLat(getTagValue("lat", eElement));
                  bdto.setLon(getTagValue("lon", eElement));
                  list.add(bdto);
                  session.setAttribute(staNm,bdto);	
		           }
		           
						}
							
					
					}
					
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}