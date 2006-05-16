LICENSE = "GPL"
inherit gpe

DEPENDS = "gtk+ libgpewidget gpe-icons"
RDEPENDS = "gpe-icons"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"
SECTION = "gpe"
DESCRIPTION = "This is a small GTK based multi-tab text editor."
AUTHOR = "Vladimir Martinek <vm@sykora.cz>"

SRC_URI="http://194.213.43.198/${PN}/${P}.tar.gz"

do_install () {
	oe_runmake install-program DESTDIR=${D} PREFIX=${prefix}
}
