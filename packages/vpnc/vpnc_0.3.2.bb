DESCRIPTION = "A client for the Cisco3000 VPN Concentrator"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "libgcrypt"

SRC_URI = "http://www.unix-ag.uni-kl.de/~massar/vpnc/vpnc-${PV}.tar.gz"

CFLAGS_append = ' -DVERSION=\\"${PV}\\"'
LDFLAGS_append = " -lgcrypt -lgpg-error"

do_install () {
        install -d ${D}${sbindir}
	install -m 0755 vpnc ${D}${sbindir}
}
