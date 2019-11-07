import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author gabriela (Izz1x)
 *
 *         Calculo do ângulo dos ponteiros de um relógio. 1. Considerando: •
 *         00:00h possui um ângulo de 0 • 00:15h possui um ângulo de 45 • 00:30h
 *         possui um ângulo de 180
 */

public class Clock {
	int hour_p;
	int min_p;

	public static void main(String[] args) {
		Clock clock = new Clock();
		GregorianCalendar horario = new GregorianCalendar();
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.println("Oi! Irei calcular o ângulo entre o ponteiro das horas e dos minutos de um relógio.");
		System.out.println("Gostaria de informar a hora (1) ou deseja usar o horário atual (2)? SAIR: (quit) ");
		while (true) {
			input = scanner.nextLine();
			if (input.equals("1")) { // caso seja digitado o numero 1
				try {
					System.out.println("Horas? ");
					int h_in = Integer.parseInt(scanner.nextLine());
					while (!(h_in <= 12 && h_in >= 0)) { // enquanto nao houver hora valida, continua solicitando um
															// input
						System.out.println("Erro: Valor deve estar entre 0 e 12! Favor tentar novamente:");
						h_in = Integer.parseInt(scanner.nextLine());
					}
					horario.set(GregorianCalendar.HOUR, h_in); // mudando o valor da hora para o desejado
					System.out.println("Minutos? ");
					int m_in = Integer.parseInt(scanner.nextLine());
					while (!(m_in <= 59 && m_in >= 0)) { // enquanto nao houver minuto valido, continua solicitando um
															// input
						System.out.println("Erro: Valor deve estar entre 0 e 59! Favor tentar novamente:");
						m_in = Integer.parseInt(scanner.nextLine());
					}
					horario.set(GregorianCalendar.MINUTE, m_in); // mudando o valor do minuto para o desejado

					System.out.println("Horario: " + horario.get(GregorianCalendar.HOUR) + "h "
							+ horario.get(GregorianCalendar.MINUTE) + "min");
					System.out.println("Angulo em graus: " + clock.retornaAnguloRelogio(horario));
				} catch (Exception e) { // se o usuario digitar algo que nao seja um numero, como uma letra
					System.out.println("Favor digitar um número");
				}
				;
			}
			if (input.equals("2")) { // caso seja digitado o numero 2
				horario = new GregorianCalendar(); // novo calendario criado com os valores atuais do horario
				System.out.println("Horário: " + horario.get(GregorianCalendar.HOUR) + "h "
						+ horario.get(GregorianCalendar.MINUTE) + "min ");
				System.out.println("Ângulo em graus: " + clock.retornaAnguloRelogio(horario));
			}
			if (input.equals("quit")) { // caso seja digitado quit, o programa fecha
				System.out.println("Fechando.");
				scanner.close();
				System.exit(5);
			} else { // Outras inputs.
				System.out.println("Digite 1, 2 ou quit.");
			}
			;
		}
	}

	public long retornaAnguloRelogio(GregorianCalendar horario) {
		hour_p = horario.get(GregorianCalendar.HOUR);
		min_p = horario.get(GregorianCalendar.MINUTE);
		long ang_h = (360 / 12 * hour_p); // angulo do ponteiro das horas
		long ang_m = (360 / 60 * min_p); // angulo do ponteiro dos minutos
		long ang_abs = Math.abs(ang_h - ang_m); // valor absoluto da diferenca do angulo dos dois ponteiros
		if (ang_abs > 180) { // caso a diferenca entre os angulos calculados seja maior que 180, iremos
								// encontrar o menor dos angulos;
			ang_abs = 360 - ang_abs;
		}
		return ang_abs;
	}

};