DESCRIPTION = "A text mode OSS soundmixer"
SECTION = "console/multimedia"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "ncurses"
LICENSE = "GPL"
SRC_URI = "http://www.stack.nl/~brama/projects/nmixer/src/nmixer-${PV}.tar.gz"

inherit autotools 

do_compile() {
	oe_runmake nmixer INCLUDES=-I${STAGING_INCDIR}/
}

