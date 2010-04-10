DESCRIPTION = "Editor for the gnome registry"
LICENSE = "GPLv2"
DEPENDS = "gnome-doc-utils gconf"

inherit gnome gconf

do_configure_prepend() {
	sed -i -e s:docs::g ${S}/Makefile.am
}

FILES_${PN} += "${datadir}/icons"

SRC_URI[archive.md5sum] = "845321d47b34f6ae19ac7e930c454e3d"
SRC_URI[archive.sha256sum] = "666ba1186b2697c3a99ee943775fbc7a7aa18f3c8cc3d335a2581dea62f812bf"
