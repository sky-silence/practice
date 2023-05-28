package designPattern.creational.builder;

/**
 * 最简单的建造者模式，当属性很多，而且有些必填，有些选填的时候，这个模式会使代码清晰很多。
 * 我们可以在 Builder 的构造方法中强制让调用者提供必填字段，还有，在 build() 方法中校验各个参数比在 User 的构造方法中校验，代码要优雅一些。
 *
 * @author chengzeshan
 * @version 1.0, 2023/05/28
 * @since practice 1.0.0
 */
public class User {

    private String name;
    private String nickName;
    private String pwd;
    private Integer age;

    private User(String name, String nickName, String pwd, Integer age){
        this.name = name;
        this.nickName = nickName;
        this.pwd = pwd;
        this.age = age;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String name;
        private String nickName;
        private String pwd;
        private Integer age;

        private UserBuilder(){
        }

        public UserBuilder name(String name){
            this.name = name;
            return this;

        }
        public UserBuilder nickName(String nickName){
            this.nickName = nickName;
            return this;

        }
        public UserBuilder pwd(String pwd){
            this.pwd = pwd;
            return this;

        }
        public UserBuilder age(Integer age){
            this.age = age;
            return this;

        }
        public User build(){
            if (name == null || pwd == null) {
                throw new RuntimeException("用户名和密码必填");
            }
            if (age <= 0 || age >= 150) {
                throw new RuntimeException("年龄不合法");
            }
            // 还可以做赋予”默认值“的功能
            if (nickName == null) {
                nickName = name;
            }
            return new User(name, pwd, nickName, age);
        }

    }

    public static void main(String[] args) {
        User u = User.builder().age(25).name("shan").nickName("jason").build();
    }

}
