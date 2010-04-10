SECTION = "x11/utils"
DESCRIPTION = "GKrellM is a GTK-based stacked monitor program."
LICENSE = "GPL"
DEPENDS = "gtk+ glib-2.0 libsm libice"

SRC_URI = "http://members.dslextreme.com/users/billw/gkrellm/gkrellm-${PV}.tar.bz2 \
           file://destdir.patch;patch=1"

inherit pkgconfig

EXTRA_OEMAKE = "'glib12=0' 'STRIP=/bin/true'"
export LINK_FLAGS = "${LDFLAGS}"
export SMC_LIBS = "-lSM -lICE"

do_install () {
	oe_runmake 'INSTALLDIR=${D}${bindir}' \
		   'SINSTALLDIR=${D}${bindir}' \
		   'MANDIR=${D}${mandir}/man1' \
		   'SMANDIR=${D}${mandir}/man1' \
		   'INCLUDEDIR=${D}${includedir}' \
		   'PKGCONFIGDIR=${D}${libdir}/pkgconfig' \
		   'LOCALEDIR=${D}${datadir}/locale' \
		   install
}

SRC_URI[md5sum] = "57ef0525c0997ac2e7720712811f5a84"
SRC_URI[sha256sum] = "d7676d7734d4821454a840a1ef05020c9c4f4797ab96ec54f2351e26d437c88c"
