package om.changgou.goods.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author : Gordon Zhang
 * @Date: 4/24/2020 10:04 AM
 * @Version 1.0
 */
@Table(name = "tb_brand")
public class Brand implements Serializable {
    @Id
    private Integer id;
    private String name;
    private String image;
    private String letter;
    private String seq;


    public Brand(Integer id, String name, String image, String letter, String seq) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.letter = letter;
        this.seq = seq;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getLetter() {
        return letter;
    }

    public String getSeq() {
        return seq;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }
}
