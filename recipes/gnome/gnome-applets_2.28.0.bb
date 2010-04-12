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


SRC_URI[archive.md5sum] = "9eb00e9dc468d2c5c71b70c9fb2b751c"
SRC_URI[archive.sha256sum] = "73aa1d5b9636ea3293d206986115473f30581dd4a937267873573880eb1bec7b"
