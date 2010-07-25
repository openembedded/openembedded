require dbus-glib.inc

PR = "${INC_PR}.1"

SRC_URI_virtclass-native += "file://run-with-tmp-session-bus.patch"

do_install_virtclass-native_prepend() {
        install -d ${D}${datadir}/dbus
        install -m 0644 tools/dbus-bus-introspect.xml ${D}${datadir}/dbus
}

SRC_URI[md5sum] = "d4aa04b9df35b4bd663be38e959941c8"
SRC_URI[sha256sum] = "ca366fed6035f75c6ca038f99b780260a0e19f282067b2dd20243ba54105fc21"
