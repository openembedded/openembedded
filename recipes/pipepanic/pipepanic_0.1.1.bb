DESCRIPTION = "Pipepanic is a pipe connecting game using libSDL. \
Connect as many different shaped pipes together as possible within the time given."
HOMEPAGE = "http://www.users.waitrose.com/~thunor/pipepanic/"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "http://www.users.waitrose.com/~thunor/pipepanic/dload/pipepanic-${PV}-source.tar.gz \
           file://fix-datadir.patch;patch=1"
S = "${WORKDIR}/pipepanic-0.1.1-source"

APPIMAGE = "zaurus/pipepanic.png"
APPDESKTOP = "zaurus/pipenaic.desktop"

inherit sdl

do_compile() {
	oe_runmake CC="${CC}" CFLAGS="${CFLAGS}" LINK="${CCLD}" LDFLAGS="${LDFLAGS} -Wl,-rpath-link,${STAGING_LIBDIR}/../qt2/lib"
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 pipepanic ${D}${bindir}

	install -d ${D}${datadir}/pipepanic
	install -m 0644 *.bmp ${D}${datadir}/pipepanic/
}


SRC_URI[md5sum] = "1d5e267c57b126038689ce3bf26eea24"
SRC_URI[sha256sum] = "468f25a70ef2dac90088caa6599c41ade6768e0cdc328dc3e82ab578903e69d4"
