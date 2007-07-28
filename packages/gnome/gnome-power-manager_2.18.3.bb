LICENSE = "GPLv2"
DEPENDS = "libnotify libgnomeui gnome-panel gnome-doc-utils libwnck gtk+ gnome-keyring libglade hal dbus-glib " 

inherit gnome

EXTRA_OECONF = " --disable-scrollkeeper \
                 --disable-keyring \
		 "

do_configure_append() {
        rm config.log
}

FILES_${PN} += "${datadir}/icons \
                ${datadir}/dbus-1 \
		${datadir}/gnome"

