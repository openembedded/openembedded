SECTION = "base"
PR = "r1"
HOMEPAGE = "http://www.freedesktop.org/Software/dbus"
DESCRIPTION = "message bus system for applications to talk to one another"
LICENSE = "GPL"

SRC_URI = "http://dbus.freedesktop.org/releases/dbus-glib/dbus-glib-${PV}.tar.gz \
	   file://run-with-tmp-session-bus.patch;patch=1"

inherit autotools pkgconfig gettext native

S = "${WORKDIR}/dbus-glib-${PV}"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/dbus-glib-${PV}"
DEPENDS = "glib-2.0-native dbus-native"

do_stage() {
        oe_runmake install
        install -d ${STAGING_DATADIR}/dbus
        install -m 0644 tools/dbus-bus-introspect.xml ${STAGING_DATADIR}/dbus
        install -m 0644 tools/dbus-glib-bindings.h ${STAGING_DATADIR}/dbus
}

SRC_URI[md5sum] = "d3b716a7e798faa1c6a867675f00306a"
SRC_URI[sha256sum] = "8bc083faaf3efdd444a8a44bbcbfea501a7b547736fda3c2d83bfdc9b5b672a3"
