DESCRIPTION = "Opie Launcher and Taskbar"
SECTION = "opie/base"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "opie-libqrsync opie-qss"
APPNAME = "qpe"

S = "${WORKDIR}/launcher"

# Wallpaper and welcome splash
PIXMAP_SIZE 		= ""
PIXMAP_SIZE_c7x0 	= "-640x480"
PIXMAP_SIZE_spitz	= "-640x480"
PIXMAP_SIZE_akita	= "-640x480"
PIXMAP_SIZE_tosa 	= "-480x640"
PIXMAP_SIZE_simpad 	= "-800x600"
PIXMAP_SIZE_asus730     = "-480x640"
PIXMAP_SIZE_htcuniversal= "-480x640"
PIXMAP_SIZE_hx4700      = "-480x640"

#inherit opie

do_install() {
	install -d ${D}${palmtopdir}/pics/launcher

	install -m 0644 ${WORKDIR}/pics/launcher/firstuse${PIXMAP_SIZE}.jpg ${D}${palmtopdir}/pics/launcher/firstuse.jpg
	install -m 0644 ${WORKDIR}/pics/launcher/opie-background${PIXMAP_SIZE}.jpg ${D}${palmtopdir}/pics/launcher/opie-background.jpg
}

FILES_${PN} += " ${palmtopdir}/pics"

PACKAGE_ARCH = "${MACHINE_ARCH}"
