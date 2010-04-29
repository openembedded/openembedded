DESCRIPTION = "dbus forwarding daemon"
LICENSE = "GPL"
DEPENDS = "dbus dbus-glib"
SRCREV = "1226a0a1374628ff191f6d8a56000be5e53e7608"
PV = "0.0.0+gitr${SRCPV}"

SRC_URI = "git://git.collabora.co.uk/git/user/alban/dbus-daemon-proxy;protocol=git"
S = "${WORKDIR}/git"

do_compile() {
	${CC} `pkg-config --cflags --libs dbus-glib-1` -o dbus-daemon-proxy dbus-daemon-proxy.c
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 dbus-daemon-proxy ${D}${bindir}
}

