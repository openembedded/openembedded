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
