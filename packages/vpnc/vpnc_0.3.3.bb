DESCRIPTION = "A client for the Cisco3000 VPN Concentrator"
SECTION = "console/network"
PRIORITY = "optional"
HOMEPAGE = "http://www.unix-ag.uni-kl.de/~massar/vpnc/"
MAINTAINER = "Matthias Goebl <matthias.goebl@goebl.net>"
LICENSE = "GPL"
DEPENDS = "libgcrypt"
RDEPENDS = "kernel-module-tun"
PR = "r1"

SRC_URI = "http://www.unix-ag.uni-kl.de/~massar/vpnc/vpnc-${PV}.tar.gz \
           file://vpnc-script.patch;patch=1 \
           file://default.conf"

CFLAGS_append = ' -DVERSION=\\"${PV}\\"'
LDFLAGS_append = " -lgcrypt -lgpg-error"

do_install () {
	oe_runmake 'DESTDIR=${D}' 'PREFIX=/usr' install
	rm -f ${D}${sysconfdir}/vpnc/vpnc.conf #This file is useless
	install ${WORKDIR}/default.conf ${D}${sysconfdir}/vpnc/default.conf
}

CONFFILES_${PN} = "${sysconfdir}/vpnc/default.conf"
