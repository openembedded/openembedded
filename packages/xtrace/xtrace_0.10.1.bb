DESCRIPTION = "Xtrace fakes an X server and forwards all connections to a \
real X server, displaying the communication between the clients and the \
server in an (well, thoretically) human readable form."
HOMEPAGE = "http://xtrace.alioth.debian.org/"
SECTION = "x11"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "glib-2.0"

SRC_URI = "${DEBIAN_MIRROR}/main/x/${PN}/${PN}_${PV}.orig.tar.gz"

inherit autotools pkgconfig

do_install_append() {
	mv ${D}${bindir}/xtrace ${D}${bindir}/x11trace
}

