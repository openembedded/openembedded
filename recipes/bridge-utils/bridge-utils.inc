DESCRIPTION = "Tools for ethernet bridging."
HOMEPAGE = "http://bridge.sourceforge.net/"
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "sysfsutils"
RRECOMMENDS = "kernel-module-bridge"

SRC_URI = "${SOURCEFORGE_MIRROR}/bridge/bridge-utils-${PV}.tar.gz file://ifupdown.sh"

inherit autotools

EXTRA_OECONF = "--with-linux-headers=${STAGING_INCDIR}"

do_install_append () {
	mv ${D}${sbindir}/brctl ${D}${sbindir}/brctl.${PN}
	install -d ${D}/${datadir}/bridge-utils
	install -d ${D}/${sysconfdir}/network/if-pre-up.d
	install -d ${D}/${sysconfdir}/network/if-post-down.d
	install -m 0755 ${WORKDIR}/ifupdown.sh  ${D}/${datadir}/bridge-utils/
	ln -s ${datadir}/bridge-utils/ifupdown.sh ${D}/${sysconfdir}/network/if-pre-up.d/bridge
	ln -s ${datadir}/bridge-utils/ifupdown.sh ${D}/${sysconfdir}/network/if-post-down.d/bridge
}

pkg_postinst_${PN} () {
	update-alternatives --install ${sbindir}/brctl brctl brctl.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove brctl brctl.${PN}
}
