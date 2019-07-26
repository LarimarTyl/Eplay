package bean;

/**
 * @author Larimar
 * @time 2019/7/24 星期三 15:50
 */
public class GameListBean {
    private int id;//游戏id
    private String gameName;//游戏名称
    private String gameLogo;//游戏logo路径;

    /*空参构造*/
    public GameListBean() {
    }
    /*全参构造*/
    public GameListBean(int id, String gameName, String gameLogo) {
        this.id = id;
        this.gameName = gameName;
        this.gameLogo = gameLogo;
    }
    /*单独获取游戏名的构造*/
    public GameListBean(String gameName) {
        this.gameName = gameName;
    }

    /*获取游戏名和logo路径的构造*/
    public GameListBean(String gameName, String gameLogo) {
        this.gameName = gameName;
        this.gameLogo = gameLogo;
    }
    public GameListBean(String gameName, String gameLogo,int id) {
        this.id=id;
        this.gameName = gameName;
        this.gameLogo = gameLogo;
    }
    public GameListBean(int i) {
        this.id=i;
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

    public String getGameLogo() {
        return gameLogo;
    }

    public void setGameLogo(String gameLogo) {
        this.gameLogo = gameLogo;
    }

    @Override
    public String toString() {
        return "GameListBean{" +
                "id=" + id +
                ", gameName='" + gameName + '\'' +
                ", gameLogo='" + gameLogo + '\'' +
                '}';
    }
}
