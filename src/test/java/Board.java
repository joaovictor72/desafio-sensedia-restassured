import org.junit.Test;

import static io.restassured.RestAssured.*;


public class Board {
    private final static String KEY_TRELLO = "637b63b32f4cd8d2a5cde2b12cfb7259";
    private final static String TOKEN_TRELLO = "15d79302b5b1a541642cc1ad41615f1cea59fa156ecec24ce5fdca6210ffd7ae";
    private final static String JSON = "application/json";
    private final static String API_CARD = "https://api.trello.com/1/cards/";
    private final static String ID_BOARD = "62293cfae92fa935034c8de2";
    private final static String ID_LIST = "62293cfae92fa935034c8de5";

    @Test
    public void deveAdicionarCartao() {
        given()
                    .log().all()
                    .contentType(JSON)
                    .header("Accept", JSON)
                    .queryParam("key", KEY_TRELLO)
                    .queryParam("token", TOKEN_TRELLO)
                    .queryParam("name", "Cartão Criado Com Sucesso!")
                    .queryParam("idBoard", ID_BOARD)
                    .queryParam("idList", ID_LIST)
                .when()
                    .post(API_CARD)
                .then()
                    .log().all()
                    .statusCode(200);
    }

    @Test
    public void deveAlterarCartao() {
        given()
                    .log().all()
                    .contentType(JSON)
                    .header("Accept", JSON)
                    .queryParam("key", KEY_TRELLO)
                    .queryParam("token", TOKEN_TRELLO)
                    .queryParam("name", "Cartão Alterado Com Sucesso :D!")
                    .queryParam("idBoard", ID_BOARD)
                    .queryParam("idList", ID_LIST)
                .when()
                    .put(API_CARD + "622ab497e882634ecae7df0f")
                .then()
                    .log().all()
                    .statusCode(200);
    }

    @Test
    public void deveDeletarCartao() {
        given()
                    .log().all()
                    .contentType(JSON)
                    .header("Accept", JSON)
                    .queryParam("key", KEY_TRELLO)
                    .queryParam("token", TOKEN_TRELLO)
                    .queryParam("idBoard", ID_BOARD)
                    .queryParam("idList", ID_LIST)
                .when()
                    .delete(API_CARD + "622ab497e882634ecae7df0f")
                .then()
                    .log().all()
                    .statusCode(200);

    }
}