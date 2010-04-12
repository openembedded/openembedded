require dbus_${PV}.inc

SRC_URI_EXTRA=""

inherit native

S = "${WORKDIR}/dbus-${PV}"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/dbus"
DEPENDS = "glib-2.0-native"

do_stage() {
	install -d ${STAGING_DATADIR}/dbus
	install -m 0644 tools/dbus-bus-introspect.xml ${STAGING_DATADIR}/dbus
	install -m 0644 tools/dbus-glib-bindings.h ${STAGING_DATADIR}/dbus
}


SRC_URI[md5sum] = "fd25c4ee2374f6c3ef9e236290667242"
SRC_URI[sha256sum] = "e33885c2e2d4172764627121c2401efb8b6a6d60eb9d9c076eca1c1da0e82a9f"
