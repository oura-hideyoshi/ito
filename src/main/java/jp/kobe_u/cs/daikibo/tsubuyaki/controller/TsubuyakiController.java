@Controller

  
public class TsubuyakiController {

  
    @Autowired

  
    TsubuyakiService ts;

  
    //タイトル画面を表示

  
    @GetMapping("/")

  
    String showIndex() {

  
        return "index";

  
    }

  
    //メイン画面を表示

  
    @GetMapping("/read")

  
    String showTsubuyakiList(Model model) {

  
        List<Tsubuyaki> list = ts.getAllTsubuyaki(); //全つぶやきを取得

  
        model.addAttribute("tsubuyakiList", list);   //モデル属性にリストをセット

  
        model.addAttribute("tsubuyakiForm", new TsubuyakiForm());  //空フォームをセット

  
        return "tsubuyaki_list"; //リスト画面を返す

  
    }

  
    //つぶやきを投稿

  
    @PostMapping("/read")

  
    String postTsubuyaki(@ModelAttribute("tsubuyakiForm") TsubuyakiForm form, Model model) {

  
        //フォームからエンティティに移し替え

  
        Tsubuyaki t = new Tsubuyaki();

  
        t.setName(form.getName());

  
        t.setComment(form.getComment());

  
        //サービスに投稿処理を依頼

  
        ts.postTsubuyaki(t);

  
        return "redirect:/read"; //メイン画面に転送

  
    }

  

  
}