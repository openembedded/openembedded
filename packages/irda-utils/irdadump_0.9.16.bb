DESCRIPTION = "Utility to dump IrDA traffic."
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "glib-1.2"

SRC_URI = "${SOURCEFORGE_MIRROR}/irda/irda-utils-${PV}.tar.gz"

S="${WORKDIR}/irda-utils-${PV}/irdadump"

EXTRA_CFLAGS += "-I${STAGING_INCDIR}/glib-1.2/"
EXTRA_LDFLAGS += "-lglib"

inherit autotools 

do_compile() {
    oe_runmake CFLAGS="${CFLAGS} ${EXTRA_CFLAGS}" LDFLAGS="${LDFLAGS} ${EXTRA_LDFLAGS}"
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${S}/shell/.libs/irdadump ${D}${bindir}
}
