package com.project.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.project.model.Items;
import com.project.model.user;
import com.project.service.UserSha256;
import com.project.service.userService;

@Controller
public class userController {
	
	@Autowired
	private userService userservice;
	
	@GetMapping("/user/join")
	public void joinform() {
		
	}
	
	@GetMapping("/user/login")
	public String userlogin() {
		
		return "/user/login";
	}
	
	@PostMapping("/user/join")
	public void userjoin(@RequestBody user user,HttpServletRequest requset) {
		System.out.println(user+"체크.................");
		userservice.userjoin(user);
		
		
		// 로그인시 세션에 아이디 넘겨줌
		HttpSession session = requset.getSession();
		session.setAttribute("userid", user.getUserid());
		
	}
	
	@GetMapping("/user/logout")
	public String userlogout(HttpServletRequest requset) {
		
		//  세션삭제 = 로그아웃
		HttpSession session = requset.getSession();
		session.invalidate();
		
		return "index";
	}
	
	@PostMapping("/user/login")
	public String login(HttpServletRequest requset) throws IllegalAccessException {
		String id = requset.getParameter("userid");
		String pw = requset.getParameter("password");
		System.out.println("user가 입력한 값 :" + pw );
		pw = UserSha256.encrypt(pw);
		System.out.println("암호화한 값 :" + pw );
		
		userservice.loginchk(id,pw, requset);
		
		return "redirect:/";
	}
	
	@GetMapping("/user/movie")
	public String hospital(Model model, Pageable pageable) throws Exception {
		System.out.println("여기들어옴123");
		
		StringBuilder result = new StringBuilder(); 
		
		String key = "hs6il93KexDShXbgAiFhSmJJph3LErgBdvPKLQ0qQrXzAUG%2BtqTUSzNI6VaeH4c8ng%2BzsDSkIq6IH%2BNFIA8UMw%3D%3D";
		
		String urlStr = "https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=10&serviceKey="+key;
		
		URL url = new URL(urlStr);
		
		HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
		urlconnection.setRequestMethod("GET");
		
		BufferedReader br;
		
		br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
		
		String returnLine ;
		
		while((returnLine = br.readLine()) != null) {
			result.append(returnLine+"\n\r");
		}
		
		urlconnection.disconnect();
		
		
		System.out.println(result+ "....................result 123");
		
		// json으로 파싱
		JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject)parser.parse(result.toString());
        System.out.println(obj + " : obj 값 ...................");
        
        
        JSONArray dataArr = (JSONArray) obj.get("data");
		System.out.println(dataArr + " : dataArr 값 ...................");
		
        model.addAttribute("data",dataArr);
        
        
        return "/user/movie";
	}
	
	@GetMapping("/user/movie2")
	public void movie2(Model model) {
		
		System.out.println("둘어옴2");
	}
	
	@GetMapping("/user/movie3")
	public void movie3(Model model)  throws Exception{
		
		StringBuilder result = new StringBuilder(); 
		
		String urlStr = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220321";
		
		URL url = new URL(urlStr);
		
		HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
		urlconnection.setRequestMethod("GET");
		
		BufferedReader br;
		
		br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
		
		String returnLine ;
		
		while((returnLine = br.readLine()) != null) {
			result.append(returnLine+"\n\r");
		}
		
		urlconnection.disconnect();
	     
		
		JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject)parser.parse(result.toString());
        obj = (JSONObject) obj.get("boxOfficeResult");
        
        JSONArray dataArr = (JSONArray) obj.get("dailyBoxOfficeList");
		System.out.println(dataArr + "...........보낼값");
       
		model.addAttribute("dataArr",dataArr);
		
	}
	
	@PostMapping("/user/movie2")
	public String movie(@RequestParam String date, Model model) throws Exception {
		System.out.println(date);
		ModelAndView mav = new ModelAndView();
		
		System.out.println("여기들어옴");
		
		String split = date.replaceAll("-", "");
//		System.out.println(split.substring(1,9));
		
		StringBuilder result = new StringBuilder(); 
		
		System.out.println(split);
		
//		String date2 = split.substring(1,9);
		Calendar calendar = new GregorianCalendar();
		SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd");
		String chkDate = SDF.format(calendar.getTime());
		// date 값이 null 값일경우 어제 날짜로 데이터를 조회 (예외처리) 
		if(date.equals("")) {
			
			calendar.add(Calendar.DATE, -1);		
			chkDate = SDF.format(calendar.getTime());
			split = chkDate;
		}
		String urlStr = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt="+split;
		
		URL url = new URL(urlStr);
		
		HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
		urlconnection.setRequestMethod("GET");
		
		BufferedReader br;
		
		br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),"UTF-8"));
		
		String returnLine ;
		
		while((returnLine = br.readLine()) != null) {
			result.append(returnLine+"\n\r");
		}
		
		urlconnection.disconnect();
	     
		
		JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject)parser.parse(result.toString());
        obj = (JSONObject) obj.get("boxOfficeResult");
        
        JSONArray dataArr = (JSONArray) obj.get("dailyBoxOfficeList");
		System.out.println(dataArr + "...........보낼값");
		
		
		model.addAttribute("dataArr", dataArr);
		
//		
		return "/user/movie2";
	}
	
	@GetMapping("/user/modify")
	public void usermodify(HttpServletRequest req,Model model) {
		
		HttpSession session = req.getSession();
		String userid = session.getAttribute("userid").toString();
		System.out.println("asdsad");
		
		model.addAttribute("userinform", userservice.userinformation(userid));
	}
	
}
