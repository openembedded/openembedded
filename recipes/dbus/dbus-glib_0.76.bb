require dbus-glib.inc

PR = "${INC_PR}.1"

SRC_URI_virtclass-native += "file://run-with-tmp-session-bus.patch"

do_install_virtclass-native_prepend() {
        install -d ${D}${datadir}/dbus
        install -m 0644 tools/dbus-bus-introspect.xml ${D}${datadir}/dbus
}

SRC_URI[md5sum] = "d3b716a7e798faa1c6a867675f00306a"
SRC_URI[sha256sum] = "8bc083faaf3efdd444a8a44bbcbfea501a7b547736fda3c2d83bfdc9b5b672a3"
