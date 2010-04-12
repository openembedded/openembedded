DESCRIPTION = "HPA's tftp server"
DEPENDS = "tcp-wrappers readline"
SECTION = "network"
LICENSE = "BSD"
PR = "r1"

SRC_URI = "${KERNELORG_MIRROR}/pub/software/network/tftp/tftp-hpa-${PV}.tar.bz2 \
           file://default \
	   file://init"

inherit autotools update-alternatives

# configure.in has errors
do_configure() {
	oe_runconf
}

do_install() {
	oe_runmake install INSTALLROOT=${D}

	mv ${D}${bindir}/tftp ${D}${bindir}/tftp.${PN}

	install -d ${D}${sysconfdir}/default
	install -d ${D}${sysconfdir}/init.d

	install -m 0644 ${WORKDIR}/default ${D}${sysconfdir}/default/tftpd-hpa
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/tftp-hpa
}


INITSCRIPT_NAME = "${PN}"
INITSCRIPT_PARAMS = "start 20 2 3 4 5 . stop 20 1 ."

PACKAGES += "tftpd-hpa"

FILES_${PN} = "${bindir}"
FILES_tftpd-hpa = "${sbindir} ${sysconfdir}"
CONFFILES_tftpd-hpa = "${sysconfdir}/default/tftpd-hpa"

ALTERNATIVE_NAME = "tftp"
ALTERNATIVE_LINK = "${bindir}/tftp"
ALTERNATIVE_PATH = "${bindir}/tftp.${PN}"
ALTERNATIVE_PRIORITY = "50"


# This is taken from update-rc.d.bbclass which works only for $PN package
# so I had to do that way

postinst_tftpd-hpa() {
if test "x$D" != "x"; then
	OPT="-r $D"
else
	OPT="-s"
fi
update-rc.d $OPT ${INITSCRIPT_NAME} ${INITSCRIPT_PARAMS}
}

prerm_tftpd-hpa() {
if test "x$D" = "x"; then
	${sysconfdir}/init.d/${INITSCRIPT_NAME} stop
fi
}

postrm_tftpd-hpa() {
if test "x$D" != "x"; then
	OPT="-r $D"
else
	OPT=""
fi
update-rc.d $OPT ${INITSCRIPT_NAME} remove
}


SRC_URI[md5sum] = "28beef704a4ef62bc2dead005198ef4c"
SRC_URI[sha256sum] = "96309871519efcab829fdfcc1cca546d772ed6a0e214c9e99e77ca7aea29f734"
