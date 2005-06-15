DESCRIPTION = "Opie Launcher and Taskbar"
SECTION = "opie/base"
PRIORITY = "optional"
LICENSE = "GPL"
MAINTAINER = "Team Opie <opie@handhelds.org>"
DEPENDS = "opie-libqrsync opie-qss"
APPNAME = "qpe"

S = "${WORKDIR}/launcher"

# Caps/Numlock icons for devices with keyboard
EXTRA_QMAKEVARS_POST_append_collie 	= "DEFINES+=OPIE_TASKBAR_LOCK_KEY_STATE"
EXTRA_QMAKEVARS_POST_append_poodle 	= "DEFINES+=OPIE_TASKBAR_LOCK_KEY_STATE"
EXTRA_QMAKEVARS_POST_append_c7x0 	= "DEFINES+=OPIE_TASKBAR_LOCK_KEY_STATE"
EXTRA_QMAKEVARS_POST_append_tosa 	= "DEFINES+=OPIE_TASKBAR_LOCK_KEY_STATE"
EXTRA_QMAKEVARS_POST_append_spitz	= "DEFINES+=OPIE_TASKBAR_LOCK_KEY_STATE"
EXTRA_QMAKEVARS_POST_append_akita	= "DEFINES+=OPIE_TASKBAR_LOCK_KEY_STATE"

# Wallpaper and welcome splash
PIXMAP_SIZE 		= ""
PIXMAP_SIZE_c7x0 	= "-640x480"
PIXMAP_SIZE_spitz	= "-640x480"
PIXMAP_SIZE_akita	= "-640x480"
# PIXMAP_SIZE_tosa 	= "-640x480"
PIXMAP_SIZE_simpad 	= "-800x600"

inherit opie update-rc.d

INITSCRIPT_NAME = "opie"
INITSCRIPT_PARAMS = "start 99 5 . stop 20 0 1 6 ."

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
	install -d ${D}${palmtopdir}/bin
	for i in ${SECTIONS}
	do
		install -d ${D}${palmtopdir}/apps/$i/
		install -m 0644 ${WORKDIR}/apps/$i/.directory ${D}${palmtopdir}/apps/$i/
	done
	install -d ${D}${palmtopdir}/pics/launcher
	install -d ${D}${palmtopdir}/pics/logo
	install -d ${D}${palmtopdir}/pics/RoH/star/
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/profile.d	
	install -d ${D}${palmtopdir}/etc/colors
	install -d ${D}${palmtopdir}/etc/skel

	install -m 0755 ${S}/qpe ${D}${palmtopdir}/bin/qpe
	install -m 0755 ${WORKDIR}/opie-reorgfiles ${D}${palmtopdir}/bin/
	install -m 0644 ${WORKDIR}/apps/Settings/calibrate.desktop ${D}${palmtopdir}/apps/Settings/
	install -m 0644 ${WORKDIR}/apps/Settings/quit.desktop ${D}${palmtopdir}/apps/Settings/
	install -m 0644 ${WORKDIR}/opie_defaults ${D}${sysconfdir}/profile.d/

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

	install -m 0755 ${WORKDIR}/opie ${D}${sysconfdir}/init.d/opie
	install -m 0644 ${WORKDIR}/qpe.conf ${D}${palmtopdir}/etc/skel/

	if [ -s ${WORKDIR}/locale.conf ]; then
	    install -m 0644 ${WORKDIR}/locale.conf ${D}${palmtopdir}/etc/skel/
	fi

        install -m 0644 ${WORKDIR}/pics/capslock.xpm ${D}${palmtopdir}/pics/
        install -m 0644 ${WORKDIR}/pics/numlock.xpm ${D}${palmtopdir}/pics/
}

updatercd_postinst_mnci() {
if test "x$D" != "x"; then
        D="-r $D"
else
        D=""	# do not autostart at installation time
fi
update-rc.d $D ${INITSCRIPT_NAME} ${INITSCRIPT_PARAMS}
}

FILES_opie-taskbar_append = " /etc ${palmtopdir}/apps ${palmtopdir}/pics"

PACKAGE_ARCH = "${MACHINE_ARCH}"
