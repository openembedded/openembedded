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

FILES_${PN} += "${datadir}/xsessions ${datadir}/icons ${datadir}/gnome ${libdir}/gnome-session/helpers"
FILES_${PN}-dbg += "${libexecdir}/gnome-session/helpers/.debug"

SRC_URI[archive.md5sum] = "d93a2da931ac0b9c0d98f6b68a17a730"
SRC_URI[archive.sha256sum] = "ea7b5d8b254eba0f4ee5f737ed3686fca4fa734ad54a20f206534241f6aef4ec"

