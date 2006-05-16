DESCRIPTION = "Pipepanic is a pipe connecting game using libSDL. \
Connect as many different shaped pipes together as possible within the time given."
HOMEPAGE = "http://www.users.waitrose.com/~thunor/pipepanic/"
LICENSE = "GPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"

SRC_URI = "http://www.users.waitrose.com/~thunor/pipepanic/dload/pipepanic-${PV}-source.tar.gz"
S = "${WORKDIR}/pipepanic-0.1.1-source"

APPIMAGE = "zaurus/pipepanic.png"
APPDESKTOP = "zaurus/pipenaic.desktop"

inherit sdl

do_configure() {
}

do_compile() {
	oe_runmake CC="${CC}" CFLAGS="${CFLAGS}" LINK="${CCLD}" LDFLAGS="${LDFLAGS} -Wl,-rpath-link,${STAGING_LIBDIR}/../qt2/lib"
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 pipepanic ${D}${bindir}
}

