require dbus-glib.inc

PR = "${INC_PR}.1"

SRC_URI_virtclass-native += "file://run-with-tmp-session-bus.patch"

do_install_virtclass-native_prepend() {
        install -d ${D}${datadir}/dbus
        install -m 0644 dbus-bus-introspect.xml ${D}${datadir}/dbus
}

SRC_URI[md5sum] = "aa2a4517de0e9144be3bce2cf8cdd924"
SRC_URI[sha256sum] = "ddfb062797341b5c5a22555ffe80138953cc61a67ba805647b2746f519bfbde1"
