package br.com.rockha.adapter.outbound.database.common;

public interface CommonEnumDatabaseMapper<EntityEnum extends Enum<EntityEnum>, DTOEnum extends Enum<DTOEnum>> {

    // Converte de DTOEnum para EntityEnum
    EntityEnum toEntity(DTOEnum dtoEnum);

    // Converte de EntityEnum para DTOEnum
    DTOEnum toDTO(EntityEnum entityEnum);
}