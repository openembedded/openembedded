DESCRIPTION = "Utility to dump IrDA traffic."
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "glib-2.0 pkgconfig"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/irda/irda-utils-${PV}.tar.gz \
	   file://glib2.patch;patch=1"

S="${WORKDIR}/irda-utils-${PV}/irdadump"

EXTRA_CFLAGS += "`pkg-config --cflags glib-2.0`"
EXTRA_LDFLAGS += "`pkg-config --libs glib-2.0`"

inherit autotools

do_compile() {
    oe_runmake CFLAGS="${CFLAGS} ${EXTRA_CFLAGS}" LDFLAGS="${LDFLAGS} ${EXTRA_LDFLAGS}"
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${S}/shell/.libs/irdadump ${D}${bindir}
}

SRC_URI[md5sum] = "2ff18f0571b5a331be7cd22fc3decd41"
SRC_URI[sha256sum] = "09a30fa12d81014b2877e8b5c36f5a341788579669d72f2dec0e29d22efe11e9"
