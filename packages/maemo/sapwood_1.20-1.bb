PR = "r1"
LICENSE = "GPL"
SECTION = "x11/base"
DESCRIPTION = "GTK theme engine Sapwood"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"
DEPENDS = "gtk+-2.6.4-1.osso7"

FILES_${PN} += "${libdir}/gtk-2.0/2.4.0/engines/"

SRC_URI = "http://stage.maemo.org/pool/maemo/ossw/source/s/${PN}/${PN}_${PV}.tar.gz \
           file://cflags.patch;patch=1;pnum=0 \
           file://sockets.patch;patch=1;pnum=0"

S = ${WORKDIR}/${PN}-1.20 
EXTRA_OECONF = "--enable-abstract-sockets=no"

inherit autotools pkgconfig

do_install_append () {
	install -d ${D}${sysconfdir}/osso-af-init
	install -m755 ${S}/debian/sapwood-server.sh  ${D}${sysconfdir}/osso-af-init/sapwood-server.sh
}


