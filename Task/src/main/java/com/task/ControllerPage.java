/*
 * package com.task;
 * 
 * import java.io.IOException; import java.util.ArrayList; import
 * java.util.List; import java.util.Optional;
 * 
 * import javax.servlet.http.HttpServletRequest;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.data.domain.Sort; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.ResponseBody; import
 * org.springframework.web.client.RestTemplate;
 * 
 * import com.fasterxml.jackson.core.JsonParseException; import
 * com.fasterxml.jackson.core.JsonProcessingException; import
 * com.fasterxml.jackson.databind.JsonMappingException; import
 * com.fasterxml.jackson.databind.ObjectMapper; import com.task.model.Response;
 * import com.task.model.ResponseList; import com.task.repository.ResponseRepo;
 * 
 * @Controller public class ControllerPage {
 * 
 * public List<Response> success =new ArrayList<>();
 * 
 * @Autowired ResponseRepo ResponseRepo;
 * 
 * @Autowired RestTemplate template; private Sort sortByIdAsc() { return new
 * Sort(Sort.Direction.ASC, "id"); }
 * 
 * @GetMapping("/data") public String fetchData(Model model) throws IOException
 * {
 * 
 * 
 * ObjectMapper m = new ObjectMapper();
 * 
 * List<Response> findAll = (List<Response>)
 * ResponseRepo.findAll(sortByIdAsc());
 * 
 * 
 * try {
 * 
 * if(findAll.size()>0) { model.addAttribute("data",findAll); } else { String
 * forObject =
 * template.getForObject("http://hradmin.aryupay.io/tracking/viewreport.php",
 * String.class); System.out.println(forObject+"forObject"); ResponseList
 * readValue = m.readValue(forObject,ResponseList.class);
 * 
 * success = readValue.getSuccess(); System.out.println(success);
 * 
 * success.stream().forEach(s-> System.out.print(s.getName()+"name"));
 * ResponseRepo.saveAll(success); model.addAttribute("data",success); }
 * RestTemplate temp=new RestTemplate(); Byte[] forObject2 = temp.getForObject(
 * "http://hradmin.aryupay.io//tracking//uploads//IMG_20190423_153014.jpg",
 * Byte[].class); System.out.println(forObject2.toString()+"dhafshjjhsfhdjhgj");
 * } catch (JsonParseException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } catch (JsonMappingException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); } catch (IOException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); }
 * 
 * 
 * 
 * return "table";
 * 
 * }
 * 
 * 
 * 
 * @GetMapping("getdetails")
 * 
 * @ResponseBody public Response onchange(HttpServletRequest request) throws
 * JsonProcessingException {
 * 
 * System.out.println("request is getting"); String attribute =
 * request.getParameter("updatenumber");
 * System.out.println("attribute is"+attribute);
 * 
 * System.out.println(success.size()+"size");
 * 
 * //List<Response> collect =
 * success.stream().filter(s->s.getId().equals(attribute)).collect(Collectors.
 * toList()); Optional<Response> findById =
 * ResponseRepo.findById(attribute.trim()); Response response = findById.get();
 * 
 * 
 * return response; }
 * 
 * 
 * @PostMapping("submitdetails")
 * 
 * public String updatedetails(Response response,Model model) {
 * System.out.println("comming"); System.out.println(response+"Response");
 * 
 * boolean existsById = ResponseRepo.existsById(response.getId());
 * if(existsById) { ResponseRepo.save(response);
 * model.addAttribute("info","saved successflly"); } else {
 * model.addAttribute("info","Entity not found"); } List<Response> data =
 * (List<Response>) ResponseRepo.findAll(sortByIdAsc());
 * model.addAttribute("data",data); return "table"; } }
 */