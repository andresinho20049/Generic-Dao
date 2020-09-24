# **************** Generic DAO ******************
### API Rest implementando CRUD (MySQL) 

Intuito desse projeto é desenvolver Generic DAO com uso apenas do javax.persistence  
Tecnologia utilizada: Java 8 + Spring boot + Rest

**Sobre:**

- API Rest simples - implementando um CRUD
- GenericDao criado usando `javax.persistence.EntityManager`
    ```Java
    	private final Class<T> persistentClass;
    
    	@PersistenceContext
    	private EntityManager entityManager;
    
    	public GenericDao() {
    		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    	}
    ```
- Mapeamento Logico/Relacional com JPA
    ```Java
    @Entity
    public class Pessoa implements Serializable {

	    private static final long serialVersionUID = 1L;
	    
        @Id
    	@GeneratedValue(strategy = GenerationType.IDENTITY)
    	private Integer id;
    	
    	@Column(length = 100, nullable = false)
    	private String nome;
    	
    	@Column(length = 11, unique = true, nullable = false)
    	private String cpf;
    	
    	@Temporal(TemporalType.DATE)
    	@Column(nullable = false)
    	private Date data_nascimento;
    	@Embedded
    	private Endereco endereco;
    	
    	@OneToMany(cascade=CascadeType.ALL)
    	@JoinColumn(name="pessoa_id", referencedColumnName="id")
    ```
- Tabela Pessoa  
    ```
    +-----------------+--------------+------+-----+---------+----------------+
    | Field           | Type         | Null | Key | Default | Extra          |
    +-----------------+--------------+------+-----+---------+----------------+
    | id              | int(11)      | NO   | PRI | NULL    | auto_increment |
    | cpf             | varchar(11)  | NO   | UNI | NULL    |                |
    | data_nascimento | date         | NO   |     | NULL    |                |
    | bairro          | varchar(50)  | NO   |     | NULL    |                |
    | cep             | int(11)      | NO   |     | NULL    |                |
    | logradouro      | varchar(50)  | NO   |     | NULL    |                |
    | municipio       | varchar(50)  | NO   |     | NULL    |                |
    | numero          | int(11)      | NO   |     | NULL    |                |
    | uf              | varchar(2)   | NO   |     | NULL    |                |
    | nome            | varchar(100) | NO   |     | NULL    |                |
    +-----------------+--------------+------+-----+---------+----------------+
    ```
- Tabela Telefone  
    ```
    +-----------+------------+------+-----+---------+----------------+
    | Field     | Type       | Null | Key | Default | Extra          |
    +-----------+------------+------+-----+---------+----------------+
    | id        | int(11)    | NO   | PRI | NULL    | auto_increment |
    | numero    | bigint(20) | NO   |     | NULL    |                |
    | pessoa_id | int(11)    | YES  | MUL | NULL    |                |
    +-----------+------------+------+-----+---------+----------------+
    ```

- Json request POST - Example:
    ```Json
    {
        "nome":"Andre Carlos",
        "cpf":12332144466,
        "data_nascimento":"2020-09-24",
        "endereco":{
            "logradouro":"Av Imaginaria",
            "numero":100,
            "bairro":"Jardim example",
            "municipio":"Sao Paulo",
            "uf":"SP",
            "cep":"06000666"
        },
        "telefone":[
            {
              "numero":11911111111
            },
            {
              "numero":1142411424
            }
        ]
    }
    ```
**Para realizar PUT é somente adicionar: `"id":{id},`**

**Métodos:**
- `get api/pessoas`
- `get /api/pessoas/{id}`
- `post api/pessoas`
- `put api/pessoas`
- `delete api/pessoas`


>Foi utilizado como base para o projeto a documentação do [javax.persistence](https://docs.oracle.com/javaee/7/api/javax/persistence/package-summary.html)             


### Mapeamento Objeto Relacional
*Mapeamento Objeto Relacional* é a representação de uma tabela de um banco de dados relacional através de classes Java.

É também conhecido como **ORM** ou **Object Relational Mapping**.

**Java Persistence API (JPA)**
Com intuito de padronizar as implementações de ORM em Java, foi elaborada a especificação JPA.

No JPA, as classes Java que representam os dados a serem armazenados no SGBD são chamadas de Entidades (Entity). O que torna essa classe uma entidade é a presença da anotação (Annotation) `@javax.persistence.Entity`. Tal anotação faz com que o JPA associe a classe Java em questão a uma tabela do banco de dados.

> **Projeto:** API Rest GenericDAO      
> **Autor:** André Carlos [(andresinho20049)](https://github.com/andresinho20049)       
> **Resumo:** Projeto desenvolvido para fins academicos com intuito de estudar sobre *ORM*