require dbus-glib.inc

PR = "${INC_PR}.1"

SRC_URI_virtclass-native += "file://run-with-tmp-session-bus.patch"

do_install_virtclass-native_prepend() {
        install -d ${D}${datadir}/dbus
        install -m 0644 tools/dbus-bus-introspect.xml ${D}${datadir}/dbus
}

SRC_URI[md5sum] = "0923d825a0aff2e4eb23338b630286fb"
SRC_URI[sha256sum] = "e870d8cd619834eda066e37fe69b441d629f9ad3a871ef2854fbbcd753b3abe2"
