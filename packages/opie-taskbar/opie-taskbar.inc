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

inherit opie

do_configure_prepend() {
	ln -s ${WORKDIR}/calibrate ${S}/calibrate
	ln -s ${WORKDIR}/mediummount ${S}/mediummount
	install -m 0644 ${WORKDIR}/server.pro ${S}/server.pro
}

do_stage() {
    install obexinterface.h ${STAGING_INCDIR}/

}

SECTIONS = "1Pim Applications Examples Games Opie-SH Python Settings"
PICS = "opielogo32x32.png start_button.png new_wait.png opielogo16x16.png sidebar.png"

do_install() {
	install -d ${D}${bindir}
	for i in ${SECTIONS}
	do
		install -d ${D}${palmtopdir}/apps/$i/
		install -m 0644 ${WORKDIR}/apps/$i/.directory ${D}${palmtopdir}/apps/$i/
	done
	install -d ${D}${palmtopdir}/pics/launcher
	install -d ${D}${palmtopdir}/pics/logo
	install -d ${D}${palmtopdir}/pics/RoH/star/
	install -d ${D}${palmtopdir}/etc/colors
	install -d ${D}${palmtopdir}/etc/skel
	install -d ${D}${sysconfdir}

	install -m 0755 ${S}/qpe ${D}${bindir}/qpe
	install -m 0644 ${WORKDIR}/apps/Settings/calibrate.desktop ${D}${palmtopdir}/apps/Settings/
	install -m 0644 ${WORKDIR}/apps/Settings/quit.desktop ${D}${palmtopdir}/apps/Settings/

	for p in ${PICS}
	do
		install -m 0644 ${WORKDIR}/pics/launcher/$p ${D}${palmtopdir}/pics/launcher/$p
	done
	install -m 0644 ${WORKDIR}/pics/launcher/firstuse${PIXMAP_SIZE}.jpg ${D}${palmtopdir}/pics/launcher/firstuse.jpg
	install -m 0644 ${WORKDIR}/pics/launcher/opie-background${PIXMAP_SIZE}.jpg ${D}${palmtopdir}/pics/launcher/opie-background.jpg

	install -m 0644 ${WORKDIR}/pics/logo/*.* ${D}${palmtopdir}/pics/logo/
	install -m 0644 ${WORKDIR}/pics/RoH/star/*.png ${D}${palmtopdir}/pics/RoH/star/

	install -m 0644 ${WORKDIR}/etc/colors/*.scheme ${D}${palmtopdir}/etc/colors/
	install -m 0644 ${WORKDIR}/etc/mime.types ${D}${sysconfdir}/

        install -m 0644 ${WORKDIR}/pics/capslock.xpm ${D}${palmtopdir}/pics/
        install -m 0644 ${WORKDIR}/pics/numlock.xpm ${D}${palmtopdir}/pics/
}

FILES_opie-taskbar_append = " ${sysconfdir} ${palmtopdir}/apps ${palmtopdir}/pics"

PACKAGE_ARCH = "${MACHINE_ARCH}"
