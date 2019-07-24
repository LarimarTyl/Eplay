package bean;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 15:51
 */
public class LevelBean {
    private int id;//游戏等级id
    private String gameName;//游戏名称
    private String gameLeve;//游戏段位

    /*空参构造*/
    public LevelBean() {
    }
    /*获取单个游戏等级的构造*/
    public LevelBean(String gameLeve) {
        this.gameLeve = gameLeve;
    }
    /*获取游戏名和对应等级的构造*/
    public LevelBean(String gameName, String gameLeve) {
        this.gameName = gameName;
        this.gameLeve = gameLeve;
    }

    /*全参构造*/
    public LevelBean(int id, String gameName, String gameLeve) {
        this.id = id;
        this.gameName = gameName;
        this.gameLeve = gameLeve;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameLeve() {
        return gameLeve;
    }

    public void setGameLeve(String gameLeve) {
        this.gameLeve = gameLeve;
    }

    @Override
    public String toString() {
        return "LevelBean{" +
                "id=" + id +
                ", gameName='" + gameName + '\'' +
                ", gameLeve='" + gameLeve + '\'' +
                '}';
    }
}
