package ApiCarteiraDigital.demo.Domain;

public enum UsuarioRole {

    MAIOR("DE-MAIOR"),

    MENOR("DE_MENOR");

    private String role;

    UsuarioRole(String role){
        this.role = role;
    }

    public String getrole(String role){
       return role;
    }
}
