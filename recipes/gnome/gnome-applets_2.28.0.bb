DESCRIPTION = "Misc applets for Gnome panel"
LICENSE = "GPL"
SECTION = "x11/gnome"

inherit gnome

DEPENDS = "gtk+ glib-2.0 gconf libgnome libxklavier libnotify dbus-glib gnome-icon-theme libxml2 policykit networkmanager"

EXTRA_OECONF = "--disable-gtk-doc"

do_configure_prepend () {
	for i in $(find . -name "Makefile.am") ; do
		sed -i -e 's:-I$(includedir)::g' $i
	done
}

do_stage() {
        autotools_stage_all
}

FILES_${PN} += " \
                ${datadir}/dbus-1/ \
                ${datadir}/PolicyKit/ \
                ${datadir}/xmodmap/ \
               "

