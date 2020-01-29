package com.example.springboot;

import org.json.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HelloController {

	@RequestMapping("/index")
	public String loginMessage(){

		ArrayList wordslist = new ArrayList();
		wordslist.add("Jallal elhazzat");
		wordslist.add("Ashley Snyder");

		String json = (new JSONArray(wordslist)).toString();



		return "index";
	}

	/*public List<PublisherInfo> filterByTabelPage(List<PublisherInfo> data, int pageNumer, int numberOfRecords){

		//return data.stream().filter(i->i.getCountry().equals(filter)).collect(Collectors.toList());

		data.stream().
	}*/


	public List<PublisherInfo> filterByTags(List<PublisherInfo> data, String filter){

		return data.stream().filter(i->i.getCountry().equals(filter)).collect(Collectors.toList());
	}

	public List<PublisherInfo> fetchTheSearchData(SearchCriteria search){
		List<PublisherInfo> data = new ArrayList<>();


		String[][] pebPerYear = new String[5][2];
		pebPerYear[0][0]="Year";
		pebPerYear[0][1]="Publication";
		//1
		pebPerYear[1][0]="2014";
		pebPerYear[1][1]="1000";

		//2
		pebPerYear[2][0]="2015";
		pebPerYear[2][1]="1170";

		//3
		pebPerYear[3][0]="2016";
		pebPerYear[3][1]="2010";

		//4
		pebPerYear[4][0]="2017";
		pebPerYear[4][1]="2200";

		//5
		pebPerYear[4][0]="2018";
		pebPerYear[4][1]="2500";


		/*publication per category*/
		//[['Task', 'Hours per Day'], ['Work', 11], ['Eat', 2], ['Commute', 2], ['Watch TV', 2], ['Sleep', 7]]
		String[][] pebPerCategory = new String[6][2];
		pebPerCategory[0][0]="Task";
		pebPerCategory[0][1]="Hours per Day";
		//1
		pebPerCategory[1][0]="Work";
		pebPerCategory[1][1]="11";

		//2
		pebPerCategory[2][0]="EatME";
		pebPerCategory[2][1]="2";

		//3
		pebPerCategory[3][0]="CommuteME";
		pebPerCategory[3][1]="2";

		//4
		pebPerCategory[4][0]="Watch ME";
		pebPerCategory[4][1]="2";

		//5
		pebPerCategory[5][0]="SleepME";
		pebPerCategory[5][1]="7";
		/***************************************************/

		//1st record
		PublisherInfo item = new PublisherInfo();
		item.setCustomerName("Jallal");
		item.setAddress("123 Happy Street");
		item.setCity("Happy City");
		item.setCountry("R1");
		item.setGender("M");
		item.setPostalCode("48108");
		item.setPublicationsPerYear(pebPerYear);
		item.setPublicationsPerCategory(pebPerCategory);

		//2nd record
		PublisherInfo item2 = new PublisherInfo();
		item2.setCustomerName("Jallal");
		item2.setAddress("123 Happy Street");
		item2.setCity("Happy City");
		item2.setCountry("P1");
		item2.setGender("M");
		item2.setPostalCode("48108");
		item2.setPublicationsPerYear(pebPerYear);
		item2.setPublicationsPerCategory(pebPerCategory);

		//3rd record
		PublisherInfo item3 = new PublisherInfo();
		item3.setCustomerName("Jallal");
		item3.setAddress("123 Happy Street");
		item3.setCity("Happy City");
		item3.setCountry("T1");
		item3.setGender("M");
		item3.setPostalCode("48108");
		item3.setPublicationsPerYear(pebPerYear);
		item3.setPublicationsPerCategory(pebPerCategory);

		//4th record
		PublisherInfo item4 = new PublisherInfo();
		item4.setCustomerName("Jallal");
		item4.setAddress("123 Happy Street");
		item4.setCity("Happy City");
		item4.setCountry("D1");
		item4.setGender("M");
		item4.setPostalCode("48108");
		item4.setPublicationsPerYear(pebPerYear);
		item4.setPublicationsPerCategory(pebPerCategory);

		//5th record
		PublisherInfo item5 = new PublisherInfo();
		item5.setCustomerName("Jallal");
		item5.setAddress("123 Happy Street");
		item5.setCity("Happy City");
		item5.setCountry("USA");
		item5.setGender("M");
		item5.setPostalCode("48108");
		item5.setPublicationsPerYear(pebPerYear);
		item5.setPublicationsPerCategory(pebPerCategory);

		//5th record
		PublisherInfo item6 = new PublisherInfo();
		item6.setCustomerName("Jallal");
		item6.setAddress("123 Happy Street");
		item6.setCity("Happy City");
		item6.setCountry("R2");
		item6.setGender("M");
		item6.setPostalCode("48108");
		item6.setPublicationsPerYear(pebPerYear);
		item6.setPublicationsPerCategory(pebPerCategory);

		//6th record
		PublisherInfo item7 = new PublisherInfo();
		item7.setCustomerName("Jallal");
		item7.setAddress("123 Happy Street");
		item7.setCity("Happy City");
		item7.setCountry("D2");
		item7.setGender("M");
		item7.setPostalCode("48108");
		item7.setPublicationsPerYear(pebPerYear);
		item7.setPublicationsPerCategory(pebPerCategory);

		//7th record
		PublisherInfo item8 = new PublisherInfo();
		item8.setCustomerName("Jallal");
		item8.setAddress("123 Happy Street");
		item8.setCity("Happy City");
		item8.setCountry("T2");
		item8.setGender("M");
		item8.setPostalCode("48108");
		item8.setPublicationsPerYear(pebPerYear);
		item8.setPublicationsPerCategory(pebPerCategory);

		//7th record
		PublisherInfo item9 = new PublisherInfo();
		item9.setCustomerName("Jallal");
		item9.setAddress("123 Happy Street");
		item9.setCity("Happy City");
		item9.setCountry("P2");
		item9.setGender("M");
		item9.setPostalCode("48108");
		item9.setPublicationsPerYear(pebPerYear);
		item9.setPublicationsPerCategory(pebPerCategory);

		data.add(item);
		data.add(item2);
		data.add(item3);
		data.add(item4);
		data.add(item5);
		data.add(item6);
		data.add(item7);
		data.add(item8);
		return data;
	}


	@PostMapping("/api/search")
	public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search, Errors errors) throws Exception {

		System.out.print("******************************************************\n");
		System.out.print(search.toString());
		System.out.print("******************************************************\n");
		List<PublisherInfo> data = fetchTheSearchData(search);
		if(null!=search.getCategory()){
			data = filterByTags(data,search.getCategory());
		}
		AjaxResponseBody result = new AjaxResponseBody();
		result.setMsg("success");
		result.setResult(data);
		return ResponseEntity.ok(data);
	}
}
