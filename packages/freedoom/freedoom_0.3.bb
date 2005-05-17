SECTION = "games"
DESCRIPTION = "The Freedoom project aims at collaboratively creating a Free IWAD file.\
	       Combined with the Free source code, this results in a complete game \
	       based on the Doom engine which is Free Software."
HOMEPAGE = "http://freedoom.sourceforge.net/"
PRIORITY = "optional"
MAINTAINER = "Matthias 'CoreDump' Hentges  <oe@hentges.net>"
LICENSE = "GPL"

SRC_URI = "http://ovh.dl.sourceforge.net/sourceforge/freedoom/freedoom-iwad-0.3.zip"

PR = "r1"

FILES_${PN} = "/usr/share/games/doom/*"
FILES_${PN}-doc = "/usr/share/doc/freedoom/*"
			       
do_install() {		
	install -d ${D}/usr/share/games/doom
	install -d ${D}/usr/share/doc/freedoom
	
	install -m 0644 ${WORKDIR}/freedoom-iwad-${PV}/doom2.wad ${D}/usr/share/games/doom/
	install -m 0644 ${WORKDIR}/freedoom-iwad-${PV}/* ${D}/usr/share/doc/freedoom
	rm ${D}/usr/share/doc/freedoom/*.wad
	
	
	
	
}

