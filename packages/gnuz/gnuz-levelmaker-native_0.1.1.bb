DESCRIPTION = "Level maker for gnuZ"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "GPL"
AUTHOR = "Lukas Fraser"
HOMEPAGE = "http://gnuz.4cows.net/eraser/gnuz/"
DEPENDS = "qt-x11-free-native"

SRC_URI = "http://gnuz.4cows.net/eraser/gnuz/gnuz-levelmaker_${PV}.tar.gz"

S = "${WORKDIR}/gnuz_levelmaker"

EXTRA_QMAKEVARS_POST += "LIBS+=-ldl CONFIG+=thread"

inherit qmake qt3x11 native

do_configure_prepend() {

	${STAGING_BINDIR}/qmake -project
}

do_compile() {

export OE_QMAKE_LINK="${CXX}"
	oe_runmake
}

do_stage() {
	install -m 0755 gnuz_levelmaker ${STAGING_BINDIR}/
}
