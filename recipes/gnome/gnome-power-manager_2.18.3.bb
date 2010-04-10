LICENSE = "GPLv2"
DEPENDS = "libnotify libgnomeui gnome-panel gnome-doc-utils libwnck gtk+ gnome-keyring libglade hal dbus-glib " 

PR = "r1"

inherit gnome

EXTRA_OECONF = " --disable-scrollkeeper \
                 --disable-keyring \
		 "

do_configure_append() {
        rm config.log
}

PACKAGES =+ "${PN}-applets"

FILES_${PN}-applets = "${bindir}/*applet* \
                       ${libdir}/bonobo/servers \
		       ${datadir}/gnome-2.0/ui"

FILES_${PN} += "${datadir}/icons \
                ${datadir}/dbus-1 \
		${datadir}/gnome/autostart \
		"

FILE_{PN}-doc += "${datadir}/omf \
                  ${datadir}/gnome/help "


SRC_URI[archive.md5sum] = "3341092fc87ced400631c3d635979426"
SRC_URI[archive.sha256sum] = "0bcc8a35d52279cd24de93e957bf0f8b3359d096cd891e5bed07cb4b912f920b"
