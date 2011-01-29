SECTION = "console/network"
DESCRIPTION = "Openswan is an Open Source implementation of IPsec for the \
Linux operating system."
HOMEPAGE = "http://www.openswan.org"
LICENSE = "GPLv2"
DEPENDS = "gmp flex-native bison-native"
RRECOMMENDS_${PN} = "kernel-module-ipsec"
RDEPENDS_append_nylon = "perl"
PR = "r3"

SRC_URI = "http://www.openswan.org/download/openswan-${PV}.tar.gz \
           file://fix-parser-build-race.patch \
           file://installcmd.patch"

EXTRA_OEMAKE = "DESTDIR=${D} \
                USERCOMPILE='${CFLAGS}' \
                USERLINK='${LDFLAGS}' \
                FINALCONFDIR=${sysconfdir}/ipsec \
                FINALLIBDIR=${libdir}/ipsec \
                FINALLIBEXECDIR=${libexecdir}/ipsec \
                FINALSBINDIR=${sbindir} \
                INC_RCDEFAULT=${sysconfdir}/init.d \
                INC_USRLOCAL=${prefix} \
                INC_MANDIR=share/man WERROR=''"

do_compile () {
	oe_runmake programs
}

do_install () {
	oe_runmake install
}

PACKAGES =+ "${PN}-examples ${PN}-test ${PN}-klips"

FILES_${PN} = "${sysconfdir} ${libdir}/ipsec/* ${sbindir}/* ${libexecdir}/ipsec/*"
FILES_${PN}-dbg += "${libdir}/ipsec/.debug ${libexecdir}/ipsec/.debug"

CONFFILES_${PN} = "${sysconfdir}/ipsec/ipsec.conf"

FILES_${PN}-examples = "${sysconfdir}/ipsec.d/examples"

# KLIPS requires some binaries and scripts that NETKEY users don't need.
FILES_${PN}-klips = " \
        ${libexecdir}/ipsec/eroute \
        ${libexecdir}/ipsec/klipsdebug \
        ${libexecdir}/ipsec/spi \
        ${libexecdir}/ipsec/spigrp \
        ${libexecdir}/ipsec/tncfg \
        ${libdir}/ipsec/_updown.klips \
"

FILES_${PN}-test = " \
        ${libexecdir}/ipsec/showpolicy \
        ${libexecdir}/ipsec/verify \
"

SRC_URI[md5sum] = "1f508adf9d0be4f34c003b833d8fce4a"
SRC_URI[sha256sum] = "bddd2ca79fec2326a69904b59df15753e59b1bf02882416b19507516e9cfcc21"
