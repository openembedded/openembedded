DESCRIPTION = "Machine specific xorg.conf files"
PR = "r2"

SRC_URI = "file://xorg.conf"

do_install() {
	install -d ${D}/${sysconfdir}/X11
	install -m 0644 ${WORKDIR}/xorg.conf ${D}/${sysconfdir}/X11/
}

CONFFILES_${PN} += "${sysconfdir}/X11/xorg.conf"

RDEPENDS_append-om-gta02 += "xf86-video-glamo xf86-input-evdev"
