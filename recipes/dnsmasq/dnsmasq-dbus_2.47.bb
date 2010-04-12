# dnsmasq with support for DBus interface

require dnsmasq.inc

S = "${WORKDIR}/dnsmasq-${PV}"

DEPENDS = "dbus"
EXTRA_OEMAKE = "COPTS=-DHAVE_DBUS"

do_install_append () {
        install -d ${D}${sysconfdir}/dbus-1/system.d
        install -m 644 dbus/dnsmasq.conf ${D}${sysconfdir}/dbus-1/system.d/
}

SRC_URI[dnsmasq-2.47.md5sum] = "4524081e56d0b935717d493e8e8d3e11"
SRC_URI[dnsmasq-2.47.sha256sum] = "f2716a43eb05b232c640a4ad647fd0fc21dd0c4f4ad20c9f5303568742399e5d"
