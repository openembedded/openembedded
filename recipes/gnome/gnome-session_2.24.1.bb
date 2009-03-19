DESCRIPTION = "Gnome session manager"
LICENSE = "GPL"
DEPENDS = "libwnck gnome-keyring libgnomeui startup-notification gtk+ gconf gdk-pixbuf-csource-native"

inherit gnome 

EXTRA_OECONF = " ac_cv_path_GCONF_SANITY_CHECK=set "

FILES_${PN} += "${datadir}/xsessions ${datadir}/icons ${datadir}/gnome"
FILES_${PN}-dbg += "${libdir}/gnome-session/helpers/"

do_stage () {
	 autotools_stage_all
}
