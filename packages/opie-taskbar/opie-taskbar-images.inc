DESCRIPTION = "Opie Launcher and Taskbar"
SECTION = "opie/base"
PRIORITY = "optional"
LICENSE = "GPL"
RPROVIDES = "${PN}"
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

PACKAGES = "${PN}-480x640 ${PN}-640x480 ${PN}-800x600 ${PN}-240x320"

#inherit opie

do_install() {
	install -d ${D}${palmtopdir}/pics/launcher

	install -m 0644 ${WORKDIR}/pics/launcher/firstuse.jpg ${D}${palmtopdir}/pics/launcher/firstuse-240x320.jpg
	install -m 0644 ${WORKDIR}/pics/launcher/opie-background.jpg ${D}${palmtopdir}/pics/launcher/opie-background-240x320.jpg

	install -m 0644 ${WORKDIR}/pics/launcher/firstuse-480x640.jpg ${D}${palmtopdir}/pics/launcher/firstuse-480x640.jpg
	install -m 0644 ${WORKDIR}/pics/launcher/opie-background-480x640.jpg ${D}${palmtopdir}/pics/launcher/opie-background-480x640.jpg

	install -m 0644 ${WORKDIR}/pics/launcher/firstuse-640x480.jpg ${D}${palmtopdir}/pics/launcher/firstuse-640x480.jpg
	install -m 0644 ${WORKDIR}/pics/launcher/opie-background-640x480.jpg ${D}${palmtopdir}/pics/launcher/opie-background-640x480.jpg

	install -m 0644 ${WORKDIR}/pics/launcher/firstuse-800x600.jpg ${D}${palmtopdir}/pics/launcher/firstuse-800x600.jpg
	install -m 0644 ${WORKDIR}/pics/launcher/opie-background-800x600.jpg ${D}${palmtopdir}/pics/launcher/opie-background-800x600.jpg
}

FILES_${PN}-240x320 += " ${palmtopdir}/pics/*/*-240x320.*"
FILES_${PN}-480x640 += " ${palmtopdir}/pics/*/*-480x640.*"
FILES_${PN}-640x480 += " ${palmtopdir}/pics/*/*-640x480.*"
FILES_${PN}-800x600 += " ${palmtopdir}/pics/*/*-800x600.*"

PACKAGE_ARCH = "all"
