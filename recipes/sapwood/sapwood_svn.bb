DESCRIPTION = "GTK theme engine Sapwood"
LICENSE = "LGPL"
DEPENDS = "gtk+"
PV = "2.43+svn${SRCDATE}"
PR = "r1"

SRC_URI = "svn://stage.maemo.org/svn/maemo/projects/haf/trunk/;module=sapwood;proto=https \
	   file://sockets.patch;patch=1 \
	  "

S = "${WORKDIR}/${PN}"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-abstract-sockets=no"

do_install_append () {
        install -d ${D}${sysconfdir}/osso-af-init
        install -m755 ${S}/debian/sapwood-server.sh  ${D}${sysconfdir}/osso-af-init/sapwood-server.sh
}

FILES_${PN} += "${libdir}/gtk-2.0/*/engines/libsapwood.so"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/engines/.debug/libsapwood.so"
