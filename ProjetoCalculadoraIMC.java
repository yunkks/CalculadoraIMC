import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class ProjetoCalculadoraIMC extends Application {
	
	@Override
	public void start(Stage palco) {
		//Etiquetas para os campos de entrada
		Label etiquetaPeso = new Label("Peso");
		Label etiquetaAltura = new Label("Altura");

		//Campos de texto para entrada de dados
		TextField campoPeso = new TextField();
		campoPeso.setPromptText("Peso em kg");
		TextField campoAltura = new TextField();
		campoAltura.setPromptText("Altura em metros");

		//Label para mostrar o resultado do IMC
		Label etiquetaResultado = new Label();

		//Botão para calcular o IMC
		Button botaoCalcular = new Button("Calcular IMC");
		botaoCalcular.setOnAction(e -> {
			try {
				double peso = Double.parseDouble(campoPeso.getText().replace(',', '.'));
				double altura = Double.parseDouble(campoAltura.getText().replace(',', '.'));

				double imc = peso / (altura * altura);
				etiquetaResultado.setText(String.format("Seu IMC é: %.2f", imc));
			} catch (NumberFormatException ex) {
				etiquetaResultado.setText("Por favor, insira números válidos para peso e altura.");
			}
		});

		//Layout vertical
		VBox layout = new VBox(10, etiquetaPeso, campoPeso, etiquetaAltura, campoAltura, botaoCalcular, etiquetaResultado);
		layout.setPadding(new Insets(10));
		layout.setAlignment(Pos.CENTER);

		//Cena e palco
		Scene cena = new Scene(layout, 350, 250);
		palco.setTitle("Calculadora de IMC");
		palco.setScene(cena);
		palco.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

/* Observações de melhorias
Tratamento de Exception
		try {
			//Peso
			//Altura
			//Cálculo IMC
			//Resultado
		} catch (NumberFormatException ex) {
			etiquetaResultado.setText("Por favor, insira números válidos para peso e altura.");
		}

Conversão para separação de casa decimais com vírgula:

//double peso = Double.parseDouble(campoPeso.getText().replace(',', '.'));
//double altura = Double.parseDouble(campoAltura.getText().replace(',','.'));
*/