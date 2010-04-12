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

SRC_URI[md5sum] = "1addd5b600a8a4550766005d1f59401b"
SRC_URI[sha256sum] = "3a8375c935f0c7b87cdd25f0408da963836fdce23390bb1b81cc6bd6ee7951c5"
