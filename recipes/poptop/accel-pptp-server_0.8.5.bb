DESCRIPTION = "ACCEL-PPTP - The PPTP client and server for Linux"
HOMEPAGE = "http://accel-pptp.sourceforge.net/"
SECTION = "network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=8ca43cbc842c2336e835926c2166c28b"

SRC_URI = "${SOURCEFORGE_MIRROR}/accel-pptp/accel-pptp/accel-pptp-${PV}.tar.bz2 \
           file://0001-configure-remove-pppd-check.patch \
           file://0002-plugins-fix-DESTDIR-and-install-params.patch \
          "

SRC_URI[md5sum] = "061ca3991fb69e0e79cb872b0aaf1d89"
SRC_URI[sha256sum] = "ac27e9834e61bb4c97be232c8c2c342cc91ebf431309079d1014acede805106b"

S = "${WORKDIR}/accel-pptp-${PV}/pptpd-1.3.3"

inherit autotools update-rc.d

EXTRA_OECONF = "--enable-static=no --enable-shared=yes"

RDEPENDS_${PN} = "ppp"
RCONFLICTS_${PN} = "poptop"

CONFFILES_${PN} = "${sysconfdir}/pptpd.conf \
                   ${sysconfdir}/ppp/options.pptpd"

INITSCRIPT_NAME = "pptpd"
INITSCRIPT_PARAMS = "defaults 92 8"

