# Challenge
Dado um determinado horário, calcular o ângulo entre os 2 ponteiros do relógio.

Considere:

00:00h possui um ângulo de 0

00:15h possui um ângulo de 45

00:30h possui um ângulo de 180

Primeiramente, para referência, escolhemos a marca 12 no relógio como o grau 0 do círculo. Dessa forma, os ângulos dos ponteiros do relógio são calculados em relação ao "início" do movimento. Cada hora divide o relógio em 12 setores circulares de 30 graus e cada minuto o divide como um setor circular de 6 graus. Tomamos o valor absoluto da diferença entre esses ângulo formados com o ponto inicial para obter a distância angular entre os ponteiros do relógio. Se o resultado for maior que 180 graus significa que temos o ângulo reflexo. Portanto retiramos esse resultado de 360 graus para descobrir o ângulo menor.

Você tem a opção de definir a hora ou usar a hora atual para o cálculos.
