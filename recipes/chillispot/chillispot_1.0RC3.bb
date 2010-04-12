DESCRIPTION = "ChilliSpot is an open source captive portal or wireless LAN access point controller. It is used for authenticating users of a wireless LAN."
HOMEPAGE = "http://www.chillispot.org/"
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

SRC_URI[md5sum] = "9ad5f4181ae2e9e2d5ccb165c37dfdde"
SRC_URI[sha256sum] = "395d082c2355369f958d8f12583f07bbac6c00f901266592959bfba09b825bb7"
