@Data

  
@Entity

  
public class Tsubuyaki {

  
    @Id

  
    @GeneratedValue(strategy = GenerationType.IDENTITY)

  
    Long id; //つぶやきエンティティの識別子

  
    String name;    //名前

  
    String comment; //コメント

  
    @Temporal(TemporalType.TIMESTAMP)

  
    Date createdAt; //作成日時

  
}