# This package builds the ftpd-topfield program
PR = "r0"
DESCRIPTION = "ftpd-topfield - FTP access to TopField PVR"
HOMEPAGE = "http://sourceforge.net/projects/puppy"
MAINTAINER = "NSLU2 Linux <www.nslu2-linux.org>"
SECTION = "net"
LICENSE = "MIT"

DEPENDS = "libusb"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/puppy;method=pserver;module=ftpd-topfield;tag=FTPD_TOPFIELD_0_6_1 \
	   cvs://anonymous@cvs.sourceforge.net/cvsroot/puppy;method=pserver;module=libtopfield;tag=FTPD_TOPFIELD_0_6_1 \
	   file://init"

# The source will end up in the subdirectory 'ftpd-topfield' - no release name
S = "${WORKDIR}/ftpd-topfield"
SL = "${WORKDIR}/libtopfield"

inherit update-rc.d

INITSCRIPT_NAME = "ftpd-topfield"
INITSCRIPT_PARAMS = "defaults"

# Just the one package at present
PACKAGES = "${PN}"

inherit autotools

do_compile() {
	oe_runmake -C ${SL} libtopfield.a
	oe_runmake LDLIBS="${LDFLAGS} -L ../libtopfield -ltopfield -lusb"
}

do_install() {
	install -d ${D}${sbindir}
	install -m 0755 ${S}/ftpd ${D}${sbindir}/ftpd-topfield
        install -d ${D}${sysconfdir}/ ${D}${sysconfdir}/init.d
        install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/ftpd-topfield
}
