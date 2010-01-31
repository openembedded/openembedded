DESCRIPTION = "Machine specific xorg.conf files"
PR = "r19"

SRC_URI = "file://xorg.conf"

do_install() {
	install -d ${D}/${sysconfdir}/X11
	install -m 0644 ${WORKDIR}/xorg.conf ${D}/${sysconfdir}/X11/
}

# Set some dependencies to make the confs actually work
RDEPENDS_omap3 = "xf86-video-omapfb"

CONFFILES_${PN} += "${sysconfdir}/X11/xorg.conf"
PACKAGE_ARCH = "${MACHINE_ARCH}"
