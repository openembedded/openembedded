SECTION = "console/network"
DESCRIPTION = "This program is used to forward DHCP and BOOTP messages between two \
 networks with different broadcast domains. \
 It works better with ppp - and especially with ipsec over ppp - than \
 dhcp-relay from ISC and has a smaller foot print."
HOMEPAGE = "http://www-user.tu-chemnitz.de/~ensc/dhcp-fwd/"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE = "GPLv2"
 
SRC_URI = "http://www-user.tu-chemnitz.de/~ensc/dhcp-fwd/files/dhcp-forwarder-0.6.tar.bz2 \
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
