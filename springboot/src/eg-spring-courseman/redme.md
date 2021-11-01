SPRINGBOOT
Repair:
	JDK 11 or new
	Maven 3.6
	IntelliJ IDEA
		Spring Tool Suite (STS)
		Postman
1. Getting Started: Hello SpringBoot!
	Spring Quickstart Guide: Spring | Spring Quickstart Guide
(1) Create project Demo: Spring Initializr
	Note: Project: Maven Project
		Language: Java
		Spirng Boot: 2.5.5
		Project Metadata:
			Group: com.example
			Artifact: demo
			Name: demo
		Dependencies: Spring Web (add dependencies …)
		GENERATE
(2) Add code file: DemoApplication.java In src/main/java/com/example/demo
(3) Run:
	Terminal:  mvnw spring-boot:run
	Browser: localhost:8080/hello
2. Project CourseMan
	Management: Sclass(Id, Name, Desc)
- Insert, update, delete, select (all, one)
Back end (basic) + Test API - Postman
Font end :
(1) Create new project: CourseMan
 
Dependencies:
	Spring Web
	Spring Data JPA
	H2 Database
(2) Create: Packet in: CourseMan/src/main/java/com.project.courseman
	controller
	model
	repository //connect to database
	service //method to work with database
(3) configuration project: File application.properties
	spring.datasource.url=jdbc:mysql://localhost:3306/db_eg_spring_courseman
spring.datasource.username=root
spring.datasource.password=12345
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
# = JPA / HIBERNATE
# ===============================
## Hibernate Properties
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update
logging.level.org.hibernate = ERROR
#Username and Password login
spring.security.user.name=courseman
spring.security.user.password=123456 
(4) code:
	- create a class in model: Sclass (format: class)
	Annotation:
	@Entity
	@Table(name="sclass")
Public class Sclass{
	@id
	@generatedValue(strategy=GenerationType, IDENTITIY)
	Private long id;
	@column(name="name")
	Private string name;
	@column(name="desc")
	Private string desc;
	//function: structured
	Public Sclass(){}
	Public Sclass(long id, string name, string desc){
		This.id=id;
		This.name=name;
		This.desc=desc;
	}
	Public long getId(){
		Return id;
	}
	Public void  setId(long id){
		This.id=id;
	}
	Public string getName(){
		Return name;
	}
	Public void  setName(string name){
		This.name=name;
	}
	Public string getDesc(){
		Return desc;
	}
	Public void  setDesc(string desc){
		This.desc=desc;
	}
- create a class in repository: SclassRepository (format: interface)
@Repository
public interface SclassRepository extends JpaRepository<Sclass,Long> {
}
- create a class in service: ISclassService (format: interface)
public interface ISclassService {
    //insert: add
    public Sclass addSclass(Sclass sclass);
    //update
    public Sclass updSclass(long id,Sclass sclass);
    //delete
    public  boolean delSclass(long id);
    //select all
    public List<Sclass> getallSclass();
    //select one
    public Sclass getoneSclass(long id);
}
- create a class in service: SclassServiceIml (format: class)
@Service
public class SclassServiceImpl implements ISclassService{
    @Autowired
    private SclassRepository sclassRepository;
    @Override
    public Sclass addSclass(Sclass sclass) {
        if(sclass!=null){
            return sclassRepository.save(sclass);
        }
        return null;
    }

    @Override
    public Sclass updSclass(long id, Sclass sclass) {
       if(sclass!=null){
           Sclass sclass1=sclassRepository.getById(id);
           if(sclass1!=null){
               sclass1.setName(sclass.getName());
               sclass1.setDesc(sclass.getDesc());
               return sclassRepository.save(sclass1);
           }
       }
        return null;
    }

    @Override
    public boolean delSclass(long id) {
        if(id>=1){
            Sclass sclass=sclassRepository.getById(id);
            if(sclass!=null){
                sclassRepository.delete(sclass);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Sclass> getallSclass() {

        return sclassRepository.findAll();
    }

    @Override
    public Sclass getoneSclass(long id) {
        if(id!=0)
        {
            Sclass sclass1=sclassRepository.getById(id);
            if(sclass1!=null)
            {
                sclass1.getName();
                sclass1.getDesc();

            }
        }
        return sclassRepository.getById(id);
    }
}
- create a class in controller: SclassController (format: class)
@Controller
public class CourseController {
    @Autowired
    private CourseService service;
    @GetMapping("course")
    public String index(Model model){
        model.addAttribute("SUBJECT",service.findAll());
        return "course/index";
    }
    @GetMapping("course/add")
    public String addcourse(Model model){
        model.addAttribute("SUBJECT",new Course());
        return "course/addcourse";
    }
    @PostMapping("course/save")
    public String save(@Validated Course course, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "redirect:/course";
        }
       service.save(course);
        redirectAttributes.addFlashAttribute("SUCCESS","Save a record successfully!");
        return "redirect:/course";
    }
    @GetMapping("course/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        service.deleteById(id.intValue());
        redirectAttributes.addFlashAttribute("SUBJECT","Delete a record succsessfully!");
        return "redirect:/course";
    }

    @GetMapping("/course/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("SUBJECT", service.findById(id));
        return "course/editcourse";
    }
    @GetMapping(value = "/course/search",params = "searchid")
    public String search(@RequestParam("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (!service.existsById(id)) {
            redirectAttributes.addFlashAttribute("SUBJECT","No ID in Database");
            return "redirect:/course";
        }
        model.addAttribute("SUBJECT", service.findById(id));
        return "course/index";
    }
}
Thiết kế View:
 
Lưu ý: Sử dụng kết hợp với Thymeleaf Engine:
	+ Biểu thức biến: $ {...}
	+ Lựa chọn biểu thức biến: * {...}
	+ Biểu thức tin nhắn: # {...}
	+ Biểu thức URL liên kết: @ {...}
	+ Biểu thức phân đoạn: ~ {...}


 




