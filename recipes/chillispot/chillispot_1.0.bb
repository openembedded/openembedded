DESCRIPTION = "ChilliSpot is an open source captive portal or wireless LAN access point controller. It is used for authenticating users of a wireless LAN."
HOMEPAGE = "http://www.chillispot.org/"
LICENSE = "GPL"
SRC_URI = "http://www.geeklan.co.uk/files/chillispot-${PV}.tar.gz \
	file://no-ansi.patch \
	file://init"
RDEPENDS_${PN} = "kernel-module-tun"
PR = "r0"

inherit autotools

do_install_append() {
	install -d ${D}/${sysconfdir} ${D}/${sysconfdir}/init.d
	install ${S}/doc/chilli.conf ${D}/${sysconfdir}
	install -m 755 ${WORKDIR}/init ${D}/${sysconfdir}/init.d/chillispot
}

CONFFILES_${PN}_nylon = "${sysconfdir}/chilli.conf"

SRC_URI[md5sum] = "997827a9302a85920cfbc1334092ac0c"
SRC_URI[sha256sum] = "ea00bf63d420f515b9ec034eff6ca04c517459232899b7582f8435b7c097eebf"
