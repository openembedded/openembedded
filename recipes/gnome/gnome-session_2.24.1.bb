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

SRC_URI[archive.md5sum] = "5bf6f5753eab034638aee80d993801d2"
SRC_URI[archive.sha256sum] = "9fc3f6d0dc7e664ff2b1507369183e5d0f1b17fc9f6643bf5e6a3ff8b6e7c211"
