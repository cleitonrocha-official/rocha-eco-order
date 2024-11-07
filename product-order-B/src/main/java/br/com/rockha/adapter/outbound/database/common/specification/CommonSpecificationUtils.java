package br.com.rockha.adapter.outbound.database.common.specification;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CommonSpecificationUtils {

    public static <T> void addLikePredicateIfPresent(List<Predicate> predicates, Root<T> root, CriteriaBuilder criteriaBuilder, String fieldName, String value) {
        Optional.ofNullable(value)
                .filter(v -> !v.isEmpty())
                .ifPresent(v -> predicates.add(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get(fieldName)), "%" + v.toLowerCase() + "%")
                ));
    }

    // Método genérico para adicionar um LIKE em um campo de uma entidade relacionada (usando Join)
    public static <T> void addLikePredicateIfPresent(List<Predicate> predicates, Path<T> path, CriteriaBuilder criteriaBuilder, String fieldName, String value) {
        Optional.ofNullable(value)
                .filter(v -> !v.isEmpty())
                .ifPresent(v -> predicates.add(
                        criteriaBuilder.like(criteriaBuilder.lower(path.get(fieldName)), "%" + v.toLowerCase() + "%")
                ));
    }

    // Método genérico para adicionar um EQUAL em um campo de uma entidade relacionada (usando Join)
    public static <T> void addEqualPredicateIfPresent(List<Predicate> predicates, Path<T> path, CriteriaBuilder criteriaBuilder, String fieldName, Object value) {
        Optional.ofNullable(value)
                .ifPresent(v -> predicates.add(criteriaBuilder.equal(path.get(fieldName), v)));
    }

    public static <T> void addRangePredicateIfPresent(List<Predicate> predicates, Root<T> root, CriteriaBuilder criteriaBuilder, String fieldName, BigDecimal valorMinimo, BigDecimal valorMaximo) {
        if (valorMinimo != null && valorMaximo != null) {
            // Adiciona um predicate para valores entre valorMinimo e valorMaximo
            predicates.add(criteriaBuilder.between(root.get(fieldName), valorMinimo, valorMaximo));
        } else if (valorMinimo != null) {
            // Adiciona um predicate para valores maiores ou iguais a valorMinimo
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(fieldName), valorMinimo));
        } else if (valorMaximo != null) {
            // Adiciona um predicate para valores menores ou iguais a valorMaximo
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(fieldName), valorMaximo));
        }
    }


    public static <T> void addEqualPredicateIfPresent(List<Predicate> predicates, Root<T> root, CriteriaBuilder criteriaBuilder, String fieldName, String value) {
        Optional.ofNullable(value)
                .filter(v -> !v.isEmpty())
                .ifPresent(v -> predicates.add(
                        criteriaBuilder.equal(root.get(fieldName), v)
                ));
    }

    public static <T> void addEqualPredicateIfPresent(List<Predicate> predicates, Root<T> root, CriteriaBuilder criteriaBuilder, String fieldName, Object value) {
        Optional.ofNullable(value)
                .ifPresent(v -> predicates.add(criteriaBuilder.equal(root.get(fieldName), v)));
    }


    public static <T> void addDateRangePredicateIfPresent(List<Predicate> predicates, Root<T> root, CriteriaBuilder criteriaBuilder, String fieldName, LocalDateTime dataInicio, LocalDateTime dataFim) {
        if (dataInicio != null && dataFim != null) {
            predicates.add(criteriaBuilder.between(root.get(fieldName), dataInicio, dataFim));
        } else if (dataInicio != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(fieldName), dataInicio));
        } else if (dataFim != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(fieldName), dataFim));
        }
    }

    // Método genérico para adicionar um BETWEEN em um campo de uma entidade relacionada (usando Join)
    public static <T> void addRangePredicateIfPresent(List<Predicate> predicates, Path<T> path, CriteriaBuilder criteriaBuilder, String fieldName, BigDecimal valorMinimo, BigDecimal valorMaximo) {
        if (valorMinimo != null && valorMaximo != null) {
            predicates.add(criteriaBuilder.between(path.get(fieldName), valorMinimo, valorMaximo));
        } else if (valorMinimo != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(path.get(fieldName), valorMinimo));
        } else if (valorMaximo != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(path.get(fieldName), valorMaximo));
        }
    }


}