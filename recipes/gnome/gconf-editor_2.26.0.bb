DESCRIPTION = "Editor for the gnome registry"
LICENSE = "GPLv2"
DEPENDS = "gnome-doc-utils gconf"

inherit gnome gconf

do_configure_prepend() {
	sed -i -e s:docs::g ${S}/Makefile.am
}

FILES_${PN} += "${datadir}/icons"

SRC_URI[archive.md5sum] = "2dc76415b22d805cfacfcd5fb98f185c"
SRC_URI[archive.sha256sum] = "2801ff7d595039292850d4f7d87b3f7c950e92dbcb39facfe62c6fb184640e1f"
