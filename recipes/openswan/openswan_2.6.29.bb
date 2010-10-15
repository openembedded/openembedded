SECTION = "console/network"
DESCRIPTION = "Openswan is an Open Source implementation of IPsec for the \
Linux operating system."
HOMEPAGE = "http://www.openswan.org"
LICENSE = "GPLv2"
DEPENDS = "gmp flex-native bison-native"
RRECOMMENDS_${PN} = "kernel-module-ipsec"
RDEPENDS_append_nylon = "perl"
PR = "r0"

SRC_URI = "http://www.openswan.org/download/openswan-${PV}.tar.gz"

EXTRA_OEMAKE = "DESTDIR=${D} \
                USERCOMPILE="${CFLAGS}" \
                USERLINK="${LDFLAGS}" \
                FINALCONFDIR=${sysconfdir}/ipsec \
                INC_RCDEFAULT=${sysconfdir}/init.d \
                INC_USRLOCAL=${prefix} \
                INC_MANDIR=share/man WERROR=''"

do_compile () {
	oe_runmake programs
}

do_install () {
	oe_runmake install
}

FILES_${PN} = "${sysconfdir} ${libdir}/ipsec/* ${sbindir}/* ${libexecdir}/ipsec/*"
FILES_${PN}-dbg += "${libdir}/ipsec/.debug ${libexecdir}/ipsec/.debug"

CONFFILES_${PN} = "${sysconfdir}/ipsec/ipsec.conf"

SRC_URI[md5sum] = "cd6c127585ec6db63780e9a40d5387fb"
SRC_URI[sha256sum] = "03345e7090d0e1d4b844b1205c1444db067c6e2f7c423342e052f44cf6fa12e4"
