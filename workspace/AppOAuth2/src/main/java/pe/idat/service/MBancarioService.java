package pe.idat.service;

import java.util.Collection;

import pe.idat.model.MBancario;

public interface MBancarioService 
{
	public abstract Collection<MBancario> findAll(Integer userId);
}
