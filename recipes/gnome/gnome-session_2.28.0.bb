DESCRIPTION = "Gnome session manager"
LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = "devicekit-power libwnck gnome-keyring libgnomeui startup-notification gtk+ gconf gdk-pixbuf-csource-native"

inherit gnome 

EXTRA_OECONF = " ac_cv_path_GCONF_SANITY_CHECK=set "

do_configure_append() {
	for i in $(find ${S} -name "Makefile") ; do
		sed -i -e s:"GCONFTOOL = .*/usr/bin/gconftool-2":"GCONFTOOL = /usr/bin/gconftool-2":g $i
		sed -i -e s:"GCONF_SANITY_CHECK = set":"GCONF_SANITY_CHECK = /usr/libexec/gconf-sanity-check-2":g $i
	done	
}

do_stage () {
	 autotools_stage_all
}

FILES_${PN} += "${datadir}/xsessions ${datadir}/icons ${datadir}/gnome ${libdir}/gnome-session/helpers"
FILES_${PN}-dbg += "${libdir}/gnome-session/helpers/.debug"


SRC_URI[archive.md5sum] = "b1a2307b02e833010d6c5312b9ff9048"
SRC_URI[archive.sha256sum] = "83e89a04fb090f1a1f6b609bdc39f1e69390269b885b7da6b32e980f4e765c0c"
