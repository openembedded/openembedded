DESCRIPTION = "Lightweight web browser capable of handling many of the \
web standards in use today."
HOMEPAGE = "http://www.netsurf-browser.org/"
SECTION = "x11/network"
LICENSE = "GPLv2"
SRCREV = "3859"
PV = "1.1+svnr${SRCPV}"
PR = "r0"

SRC_URI = "svn://svn.netsurf-browser.org/trunk;module=netsurf \
           file://netsurf.desktop"
S = "${WORKDIR}/netsurf"

DEPENDS = "gtk+ (>=2.8) lemon-native re2c-native libxml2 librsvg jpeg \
           libmng curl openssl libglade (>=2.0)"

do_compile() {
        make -f Makefile.unix 
}

do_install() {
	install -d ${D}/${bindir}
	install -d ${D}/${libdir}/netsurf
	install -d ${D}/${datadir}/netsurf
	install -d ${D}/${datadir}/applications
	install -d ${D}/${datadir}/pixmaps
        install -m 0755 nsgtk ${D}/${libdir}/netsurf
	install -m 0644 gtk/res/*.css ${D}/${datadir}/netsurf
	install -m 0644 gtk/res/ca-bundle.txt ${D}/${datadir}/netsurf
	install -m 0644 gtk/res/netsurf.glade ${D}/${datadir}/netsurf
	install -m 0644 gtk/res/netsurf-logo.png ${D}/${datadir}/netsurf
	install -m 0644 gtk/res/netsurf.xpm ${D}/${datadir}/netsurf
	install -m 0644 gtk/res/throbber.gif ${D}/${datadir}/netsurf
	install -m 0644 gtk/res/messages ${D}/${datadir}/netsurf
        install -m 0644 gtk/res/netsurf.xpm ${D}/${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/netsurf.desktop ${D}/${datadir}/applications
        cat >${D}/${bindir}/netsurf <<EOF
#!/bin/sh
NETSURFRES=${datadir}/netsurf
export NETSURFRES
exec ${libdir}/netsurf/nsgtk "\$@"
EOF
        chmod 0755 ${D}/${bindir}/netsurf
}
