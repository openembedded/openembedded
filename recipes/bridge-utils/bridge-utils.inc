DESCRIPTION = "Tools for ethernet bridging."
HOMEPAGE = "http://bridge.sourceforge.net/"
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "sysfsutils"
RRECOMMENDS = "kernel-module-bridge"

SRC_URI = "${SOURCEFORGE_MIRROR}/bridge/bridge-utils-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--with-linux-headers=${STAGING_INCDIR}"

do_install_append () {
	mv ${D}${sbindir}/brctl ${D}${sbindir}/brctl.${PN}
}

pkg_postinst_${PN} () {
	update-alternatives --install ${sbindir}/brctl brctl brctl.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove brctl brctl.${PN}
}
