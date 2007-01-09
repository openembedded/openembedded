LICENSE = "LGPL"

SRC_URI = "http://repository.maemo.org/pool/bora/free/source/${PN}_${PV}.tar.gz"

inherit autotools pkgconfig

do_compile() {
        sed -i 's:@$(DOXYGEN):echo:g' Makefile
       	sed -i 's:-o\ root\ -g\ root::' Makefile
}

do_stage() {
	autotools_stage_includes
}	

