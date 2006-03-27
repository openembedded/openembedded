DESCRIPTION = "Tasks applet switcher for matchbox"
LICENSE = "GPLv2"
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"
DEPENDS = "gtk+ libwnck libmatchbox"

PR = "r1"

CFLAGS += "-I${STAGING_INCDIR} \
	   -I${STAGING_INCDIR}/gtk-2.0 \
	   -I${STAGING_INCDIR}/glib-2.0 \
	   -I${STAGING_INCDIR}/freetype2 \
	   -I${STAGING_INCDIR}/atk-1.0 \
	   -I${STAGING_INCDIR}/libwnck-1.0 \	
	   -I${STAGING_LIBDIR}/gtk-2.0/include \
	   -I${STAGING_INCDIR}/cairo \
	   -DWNCK_I_KNOW_THIS_IS_UNSTABLE"

SRC_URI = "http://mail.pdaxrom.org/1.1.0beta1/src/${P}.tar.bz2"

do_install() {
install -d ${D}/${datadir}/applications
install -d ${D}/${bindir}

install -m 755 mb-applet-tasks ${D}/${bindir}
install -m 644 mb-applet-tasks.desktop ${D}/${datadir}/applications
}






