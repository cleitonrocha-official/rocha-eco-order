package br.com.rockha.core.common.adapter.adapter;


public interface CommonUseCase<R,C> {
    R process(C command);
}