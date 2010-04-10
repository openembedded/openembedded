SECTION = "console/network"
DESCRIPTION = "This program is used to forward DHCP and BOOTP messages between two \
 networks with different broadcast domains. \
 It works better with ppp - and especially with ipsec over ppp - than \
 dhcp-relay from ISC and has a smaller foot print."
HOMEPAGE = "http://www.nongnu.org/dhcp-fwd/"
LICENSE = "GPLv2"

SRC_URI = "http://savannah.nongnu.org/download/dhcp-fwd/dhcp-forwarder-${PV}.tar.bz2 \
	file://init \
	file://dhcp-fwd.cfg"

inherit autotools update-rc.d

EXTRA_OECONF="--disable-dietlibc"

INITSCRIPT_NAME="dhcp-forwarder"
INITSCRIPT_PARAMS="defaults"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/dhcp-forwarder
	install -m 0644 ${WORKDIR}/dhcp-fwd.cfg ${D}${sysconfdir}
}

CONFFILES_${PN}_nylon = "${sysconfdir}/dhcp-fwd.cfg"

SRC_URI[md5sum] = "e7f876e615ebc3f96418f6477b4451e2"
SRC_URI[sha256sum] = "eb20cb028176e52432a2b877b2e292100dc41b384e829bc9e6d4823075ed8188"
