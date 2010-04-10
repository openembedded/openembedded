SECTION = "base"
PR = "r1"
HOMEPAGE = "http://www.freedesktop.org/Software/dbus"
DESCRIPTION = "Message bus system for applications to talk to one another"
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

SRC_URI[md5sum] = "0923d825a0aff2e4eb23338b630286fb"
SRC_URI[sha256sum] = "e870d8cd619834eda066e37fe69b441d629f9ad3a871ef2854fbbcd753b3abe2"
