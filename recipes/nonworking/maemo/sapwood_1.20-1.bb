PR = "r1"
LICENSE = "GPL"
SECTION = "x11/base"
DESCRIPTION = "GTK theme engine Sapwood"
DEPENDS = "gtk+-2.6.4-1.osso7"

FILES_${PN} += "${libdir}/gtk-2.0/2.4.0/engines/"

SRC_URI = "http://stage.maemo.org/pool/maemo/ossw/source/s/${PN}/${PN}_${PV}.tar.gz \
           file://cflags.patch;patch=1;pnum=0 \
           file://sockets.patch;patch=1;pnum=0"

S = "${WORKDIR}/${PN}-1.20"
EXTRA_OECONF = "--enable-abstract-sockets=no"

inherit autotools pkgconfig

do_install_append () {
	install -d ${D}${sysconfdir}/osso-af-init
	install -m755 ${S}/debian/sapwood-server.sh  ${D}${sysconfdir}/osso-af-init/sapwood-server.sh
}



SRC_URI[md5sum] = "92dbb7fbcf468030662d4a103ecaca58"
SRC_URI[sha256sum] = "d0baabff2a5dba4ad8dfc79f15f0d3110ab88564a451c835b56618cf808ba870"
