package com.cabos.mapper;

import java.util.Collection;

public class VideojuegoDlcMapper extends VideojuegoMapper{
	
	private Collection<DlcMapper> dlcs;

	public VideojuegoDlcMapper() {
	}

	public VideojuegoDlcMapper(Collection<DlcMapper> dlcs) {
		super();
		this.dlcs = dlcs;
	}

	public Collection<DlcMapper> getDlcs() {
		return dlcs;
	}

	public void setDlcs(Collection<DlcMapper> dlcs) {
		this.dlcs = dlcs;
	}
	
}
