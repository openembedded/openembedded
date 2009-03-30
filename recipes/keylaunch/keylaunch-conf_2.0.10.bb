RDEPENDS_append_spitz = " display-brightness"
RDEPENDS_append_akita = " display-brightness"
RDEPENDS_append_c7x0 = " display-brightness"

SECTION = "gpe"
LICENSE = "GPL"
DESCRIPTION = "Device-specific keylaunch configuration"
PACKAGE_ARCH = "${MACHINE_ARCH}"
PR = "r2"

SRC_URI = " file://keylaunchrc"
SRC_URI += " file://80chvt-SUID"

do_install () {
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/X11/Xinit.d
	install -m 0644 ${WORKDIR}/keylaunchrc ${D}${sysconfdir}/keylaunchrc.matchbox
	install ${WORKDIR}/80chvt-SUID ${D}${sysconfdir}/X11/Xinit.d
}

pkg_postinst_${PN}() {
	update-alternatives --install /etc/keylaunchrc keylaunchrc /etc/keylaunchrc.matchbox 10
}

pkg_postrm_${PN}() {
       update-alternatives --remove keylaunchrc /etc/keylaunchrc.matchbox
}
