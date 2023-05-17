package Modele;

/**
 * Enumération représentant les différentes valeurs des cartes du jeu de mémoire.
 */
public enum ValeurDeCarte {
    AU("australia.png"),
    CA("canada.png"),
    FR("france.png"),
    DE("germany.png"),
    IT("italy.png"),
    PT("portugal.png"),
    RU("russia.png"),
    CH("switzerland.png"),
    UK("uk.png"),
    US("us.png");


    private String imgName;

    /**
     * Constructeur pour l'énumération ValeurDeCarte.
     *
     * @param imgName Le nom de l'image associée à la valeur de la carte.
     */
    private ValeurDeCarte(String imgName) {
        this.imgName = imgName;
    }


    /**
     * Getter pour obtenir le nom de l'image associée à la valeur de la carte.
     *
     * @return Le nom de l'image.
     */
    public String getImgName() {
        return imgName;
    }


}
