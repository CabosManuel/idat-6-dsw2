package pe.idat.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.idat.model.MBancario;
import pe.idat.repository.MBancarioRepository;

@Service
public class MBancarioServiceImpl implements MBancarioService
{
	@Autowired
	private MBancarioRepository repository;

	@Override
	@Transactional(readOnly=true)
	public Collection<MBancario> findAll(Integer userId) {
		return repository.findAll(userId);
	}
}
