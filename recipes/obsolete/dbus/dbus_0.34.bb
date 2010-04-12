require dbus_${PV}.inc


DEPENDS = "expat glib-2.0 virtual/libintl dbus-native"
DEFAULT_PREFERENCE = "-1"
SRC_URI_EXTRA = "file://no-introspect.patch;patch=1 file://no-bindings.patch;patch=1"

FILES_${PN} += "${bindir}/dbus-daemon"
FILES_${PN}-dev += "${bindir}/dbus-binding-tool"

do_configure_prepend() {
	install -m 0644 ${STAGING_DATADIR_NATIVE}/dbus/dbus-bus-introspect.xml ${S}/tools/
	install -m 0644 ${STAGING_DATADIR_NATIVE}/dbus/dbus-glib-bindings.h ${S}/tools/
}

SRC_URI[md5sum] = "fd25c4ee2374f6c3ef9e236290667242"
SRC_URI[sha256sum] = "e33885c2e2d4172764627121c2401efb8b6a6d60eb9d9c076eca1c1da0e82a9f"
