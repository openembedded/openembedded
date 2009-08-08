DESCRIPTION = "Editor for the gnome registry"
LICENSE = "GPLv2"
DEPENDS = "gnome-doc-utils gconf"

inherit gnome gconf

do_configure_prepend() {
	sed -i -e s:docs::g ${S}/Makefile.am
}

FILES_${PN} += "${datadir}/icons"
