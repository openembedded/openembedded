DESCRIPTION = "Misc applets for Gnome panel"
LICENSE = "GPL"
SECTION = "x11/gnome"

inherit gnome

SRC_URI[archive.md5sum] = "2afcbedc10b1a0e8072ac4eefdc8d770"
SRC_URI[archive.sha256sum] = "41489fbb1f8352a306cde6676dfaf1e497bfbca960454f7251c4fd92920bba5d"

DEPENDS = "gtk+ glib-2.0 gconf libgnome libxklavier libnotify dbus-glib gnome-icon-theme libxml2 policykit networkmanager"

EXTRA_OECONF = "--disable-gtk-doc"

do_configure_prepend () {
	for i in $(find . -name "Makefile.am") ; do
		sed -i -e 's:-I$(includedir)::g' $i
	done
}

FILES_${PN} += " \
                ${datadir}/dbus-1/ \
                ${datadir}/PolicyKit/ \
                ${datadir}/xmodmap/ \
               "

