DESCRIPTION = "The monitoring utilitiy for the Bustle D-Bus diagram application."
HOMEPAGE = "http://www.willthompson.co.uk/bustle"
DEPENDS = "dbus glib-2.0"
LICENSE = "LGPL"
SECTION = "console/network"

SRC_URI = "http://www.willthompson.co.uk/bustle/releases/bustle-${PV}.tar.gz"
S = "${WORKDIR}/bustle-${PV}"

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} `pkg-config --cflags --libs dbus-1 glib-2.0` -o bustle-dbus-monitor bustle-dbus-monitor.c
}

do_install() {
	install -d ${D}${sbindir}
	install -m 0755 bustle-dbus-monitor ${D}${sbindir}
}

FILES_${PN} += "${sbindir}"
