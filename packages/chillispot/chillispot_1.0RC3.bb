DESCRIPTION = "ChilliSpot is an open source captive portal or wireless LAN access point controller. It is used for authenticating users of a wireless LAN."
HOMEPAGE = "http://www.chillispot.org/"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE = "GPL"
SRC_URI = "http://www.chillispot.org/download/chillispot-${PV}.tar.gz \
	file://no-ansi.patch;patch=1 \
	file://init"
RDEPENDS = "kernel-module-tun"

inherit autotools

do_install_append() {
	install -d ${D}/${sysconfdir} ${D}/${sysconfdir}/init.d
	install ${S}/doc/chilli.conf ${D}/${sysconfdir}
	install -m 755 ${WORKDIR}/init ${D}/${sysconfdir}/init.d/chillispot
}

CONFFILES_${PN}_nylon = "${sysconfdir}/chilli.conf"
