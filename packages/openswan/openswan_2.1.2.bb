LICENSE = "GPL"
SECTION = "console/network"
DESCRIPTION = "Openswan is an Open Source implementation of IPsec for the \
Linux operating system."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
DEPENDS = "gmp"

SRC_URI = "http://www.openswan.org/code/openswan-${PV}.tar.gz \
	   file://flags.patch;patch=1"
S = "${WORKDIR}/openswan-${PV}"

EXTRA_OEMAKE = "-e DESTDIR=${D} \
                USERCOMPILE="${CFLAGS}" \
                FINALCONFDIR=${sysconfdir}/ipsec \
                INC_RCDEFAULT=${sysconfdir}/init.d \
                INC_USRLOCAL=${prefix} \
                INC_MANDIR=share/man"

do_compile () {
	oe_runmake programs
}

do_install () {
	oe_runmake install
}

FILES_${PN} += "${libdir}/ipsec/"
