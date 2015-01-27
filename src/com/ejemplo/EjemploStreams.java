package com.ejemplo;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.function.ToDoubleFunction;

public class EjemploStreams {

	public static void main(String[] args) {

		List<Factura> facturas = Arrays.asList(new Factura("Cliente-1", 1200),
				new Factura("Cliente-2", 1500), new Factura("Cliente-3", 100),
				new Factura("Cliente-4", 12000), new Factura("Cliente-5", 0),
				new Factura("Cliente-6", 120), new Factura("Cliente-7", 5000),
				new Factura("Cliente-8", 1000), new Factura("Cliente-9", 10));

		// A-1)
		// facturas.stream().mapToDouble(new ToDoubleFunction<Factura>() {
		// @Override
		// public double applyAsDouble(Factura p) {
		// return p.getCantidad();
		// }
		// });

		// 2)
		// facturas.stream().mapToDouble(factura -> factura.getCantidad());

		// 3)
		// facturas.stream().mapToDouble(p -> p.getCantidad());

		// 4)
		// Expresión Lambda, sustituye al código anterior comentado
		// facturas.stream().mapToDouble((Factura p) -> {
		// return p.getCantidad();
		// });

		// B)
		// Ahora aplicamos un filtro, en este caso ya no hace falta especificar
		// el tipo de parámetro a diferencia del caso anterior
		// facturas.stream().mapToDouble(new ToDoubleFunction<Factura>() {
		// @Override
		// public double applyAsDouble(Factura p) {
		// return p.getCantidad();
		// }
		// }).filter(new DoublePredicate() {
		//
		// @Override
		// public boolean test(double value) {
		//
		// return value > 500.1;
		// }
		// });

		// C)
		// Ahora , seguimos teniendo un DoubleStream, pudiedno hacer la
		// directiva que desemos (Bucle foreac)
		// facturas.stream().mapToDouble(new ToDoubleFunction<Factura>() {
		// @Override
		// public double applyAsDouble(Factura p) {
		// return p.getCantidad();
		// }
		// }).filter(new DoublePredicate() {
		//
		// @Override
		// public boolean test(double value) {
		//
		// return value > 500.1;
		// }
		// }).forEach(new DoubleConsumer() {
		//
		// @Override
		// public void accept(double value) {
		// // No devuelve nada, es el procesamiento de la directiva
		// System.out.println(value);
		// }
		// });

		// D)
		// Ahora , ejecución en paralelo
		facturas.parallelStream().mapToDouble(new ToDoubleFunction<Factura>() {
			@Override
			public double applyAsDouble(Factura p) {
				return p.getCantidad();
			}
		}).filter(new DoublePredicate() {

			@Override
			public boolean test(double value) {

				return value > 500.1;
			}
		}).forEach(new DoubleConsumer() {

			@Override
			public void accept(double value) {
				// No devuelve nada, es el procesamiento de la directiva
				System.out.println(value);
			}
		});

		// O

		// facturas.stream().parallel().mapToDouble(new
		// ToDoubleFunction<Factura>() {
		// @Override
		// public double applyAsDouble(Factura p) {
		// return p.getCantidad();
		// }
		// }).filter(new DoublePredicate() {
		//
		// @Override
		// public boolean test(double value) {
		//
		// return value > 500.1;
		// }
		// }).forEach(new DoubleConsumer() {
		//
		// @Override
		// public void accept(double value) {
		// // No devuelve nada, es el procesamiento de la directiva
		// System.out.println(value);
		// }
		// });

		// Dos formas de procesar los Stream, paralela o secuencial, por defecto
		// la secuencial
	}

}
