# dnsmasq with support for DBus interface

require dnsmasq.inc

PR = "r1"
DEPENDS = "dbus"
EXTRA_OEMAKE = "COPTS=-DHAVE_DBUS"

SRC_URI += "file://dbus_introspection.patch;patch=1"

do_install_append () {
        install -d ${D}${sysconfdir}/dbus-1/system.d
        install -m 644 dbus/dnsmasq.conf ${D}${sysconfdir}/dbus-1/system.d/
}
