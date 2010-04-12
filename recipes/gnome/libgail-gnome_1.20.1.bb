DESCRIPTION="Gnome Accessibility library"
LICENSE="GPLv2"

PR ="r0"

DEPENDS="atk gtk+ libbonobo libbonoboui gnome-panel at-spi"

inherit gnome

do_stage() {
	autotools_stage_all
}

FILES_${PN} += "${libdir}/gtk-2.0/modules/*.so"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/modules/.debug"


SRC_URI[archive.md5sum] = "5c5b71af5a8ab2a9403bdae52b20e46c"
SRC_URI[archive.sha256sum] = "848485971628ff9be294e2b3ad5410b184e4bf99c1112a767f7ac78bdc0b5d5d"
