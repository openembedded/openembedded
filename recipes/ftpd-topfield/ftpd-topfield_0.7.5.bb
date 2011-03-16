# This package builds the ftpd-topfield program
DESCRIPTION = "ftpd-topfield - FTP access to TopField PVR"
HOMEPAGE = "http://sourceforge.net/projects/puppy"
SECTION = "net"
LICENSE = "MIT"
PR = "r3"

SRC_URI = "cvs://anonymous@puppy.cvs.sourceforge.net/cvsroot/puppy;method=pserver;module=ftpd-topfield;tag=FTPD_TOPFIELD_0_7_5 \
	   cvs://anonymous@puppy.cvs.sourceforge.net/cvsroot/puppy;method=pserver;module=libtopfield;tag=FTPD_TOPFIELD_0_7_5 \
	   file://syslog.patch \
	   file://usb-header-name-2-6-23.patch;striplevel=0 \
	   file://init"

# The source will end up in the subdirectory 'ftpd-topfield' - no release name
S = "${WORKDIR}/ftpd-topfield"

inherit update-rc.d

INITSCRIPT_NAME = "ftpd-topfield"
INITSCRIPT_PARAMS = "defaults"

do_unpack2() {
	cd ${WORKDIR}
	mv libtopfield ${S}/
}

addtask unpack2 after do_unpack before do_patch

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}${sbindir}
	install -m 0755 ${S}/ftpd ${D}${sbindir}/ftpd-topfield
        install -d ${D}${sysconfdir}/ ${D}${sysconfdir}/init.d
        install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/ftpd-topfield
}
