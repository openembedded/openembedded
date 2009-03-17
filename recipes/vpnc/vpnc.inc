DESCRIPTION = "A client for the Cisco3000 VPN Concentrator"
HOMEPAGE = "http://www.unix-ag.uni-kl.de/~massar/vpnc/"
AUTHOR = "Maurice Massar vpnc@unix-ag.uni-kl.de"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "libgcrypt"
RDEPENDS = "kernel-module-tun"

CFLAGS_append = ' -DVERSION=\\"${PV}\\"'
LDFLAGS_append = " -lgcrypt -lgpg-error"

do_install () {
	sed -i s:m600:m\ 600:g Makefile	
	oe_runmake 'DESTDIR=${D}' 'PREFIX=/usr' install
	rm -f ${D}${sysconfdir}/vpnc/vpnc.conf #This file is useless
	install ${WORKDIR}/default.conf ${D}${sysconfdir}/vpnc/default.conf
}

CONFFILES_${PN} = "${sysconfdir}/vpnc/default.conf"
