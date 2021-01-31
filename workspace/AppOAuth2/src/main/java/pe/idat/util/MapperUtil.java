package pe.idat.util;

import java.util.ArrayList;
import java.util.Collection;

import pe.idat.mapper.MBancarioMapper;
import pe.idat.mapper.UserMapper;
import pe.idat.model.MBancario;
import pe.idat.model.User;

public class MapperUtil 
{
	public static Collection<UserMapper> convertUser(Collection<User> items)
	{
		Collection<UserMapper> collection=new ArrayList<>();
		
		for(User user:items) {
			collection.add(new UserMapper(user));
		}
		
		return collection;				
	}
	
	public static Collection<MBancarioMapper> convertMBancario(Collection<MBancario> items)
	{
		Collection<MBancarioMapper> collection=new ArrayList<>();
		
		for(MBancario mbancario:items) {
			collection.add(new MBancarioMapper(mbancario));
		}
		
		return collection;
	}
}
