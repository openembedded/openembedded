SECTION = "x11/utils"
DESCRIPTION = "GKrellM is a GTK-based stacked monitor program."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "gtk+ glib-2.0 libsm libice"

SRC_URI = "http://members.dslextreme.com/users/billw/gkrellm/gkrellm-${PV}.tar.bz2"

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
