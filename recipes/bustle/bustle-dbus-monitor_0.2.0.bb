DESCRIPTION = "The monitoring utilitiy for the Bustle D-Bus diagram application."
HOMEPAGE = "http://www.willthompson.co.uk/bustle"
DEPENDS = "dbus glib-2.0"
LICENSE = "LGPL"
SECTION = "console/network"

SRC_URI = "http://www.willthompson.co.uk/bustle/releases/bustle-${PV}.tar.gz"
SRC_URI[md5sum] = "23d6467bcadd7cbc7a3d1ffe0614f7f6"
SRC_URI[sha256sum] = "995a4f02604d28adbb3e8bd3045cd774834b244c42039032e5d3d0ab11949d87"

S = "${WORKDIR}/bustle-${PV}"

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} `pkg-config --cflags --libs dbus-1 glib-2.0` -o bustle-dbus-monitor bustle-dbus-monitor.c
}

do_install() {
	install -d ${D}${sbindir}
	install -m 0755 bustle-dbus-monitor ${D}${sbindir}
}

FILES_${PN} += "${sbindir}"
