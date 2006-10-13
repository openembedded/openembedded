# This package builds the ftpd-topfield program
PR = "r0"
DESCRIPTION = "ftpd-topfield - FTP access to TopField PVR"
HOMEPAGE = "http://sourceforge.net/projects/puppy"
SECTION = "net"
LICENSE = "MIT"

SRC_URI = "cvs://anonymous@puppy.cvs.sourceforge.net/cvsroot/puppy;method=pserver;module=ftpd-topfield;tag=FTPD_TOPFIELD_0_6_10 \
	   cvs://anonymous@puppy.cvs.sourceforge.net/cvsroot/puppy;method=pserver;module=libtopfield;tag=FTPD_TOPFIELD_0_6_10 \
	   file://init"

# The source will end up in the subdirectory 'ftpd-topfield' - no release name
S = "${WORKDIR}/ftpd-topfield"

inherit update-rc.d

INITSCRIPT_NAME = "ftpd-topfield"
INITSCRIPT_PARAMS = "defaults"

# Just the one package at present
PACKAGES = "${PN}"

inherit autotools

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}${sbindir}
	install -m 0755 ${S}/ftpd ${D}${sbindir}/ftpd-topfield
        install -d ${D}${sysconfdir}/ ${D}${sysconfdir}/init.d
        install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/ftpd-topfield
}
