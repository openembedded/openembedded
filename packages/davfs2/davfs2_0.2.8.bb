DESCRIPTION = "A Linux file system driver that allows you to mount a WebDAV server as a disk drive."
SECTION = "network"
PRIORITY = "optional"
MAINTAINER = "Mustafa Yuecel <yuecelm@ee.ethz.ch>"
HOMEPAGE = "http://dav.sourceforge.net"
DEPENDS = "neon-0.25.5"
RDEPENDS_${PN} = "kernel-module-coda"
LICENSE = "GPL"

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/dav/${P}.tar.gz \
           file://Makefile.in.patch;patch=1 \
           file://volatiles"

inherit autotools

ALTERNATIVE_NAME = "mount.davfs"
ALTERNATIVE_PATH = "${sbindir}/${ALTERNATIVE_NAME}"
ALTERNATIVE_PRIORITY = "90"
ALTERNATIVE_LINK = "${base_sbindir}/${ALTERNATIVE_NAME}" 

EXTRA_OECONF = "--with-neon"

CONFFILES_${PN} = "${sysconfdir}/davfs2/davfs2.conf ${sysconfdir}/davfs2/secrets"

do_configure_prepend () {
        autoconf
}

do_install_append () {
        mkdir -p ${D}${sysconfdir}/default/volatiles
        install -m 644 ${WORKDIR}/volatiles ${D}${sysconfdir}/default/volatiles/10_davfs2
}

pkg_postinst () {
	update-alternatives --install ${ALTERNATIVE_LINK} ${ALTERNATIVE_NAME} \
		${ALTERNATIVE_PATH} ${ALTERNATIVE_PRIORITY}
	/etc/init.d/populate-volatile.sh
}

pkg_prerm () {
	update-alternatives --remove ${ALTERNATIVE_NAME} ${ALTERNATIVE_PATH}
}
