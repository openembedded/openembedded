DESCRIPTION = "Editor for the gnome registry"
LICENSE = "GPLv2"
DEPENDS = "policykit gnome-doc-utils gconf"

inherit gnome gconf

SRC_URI[archive.md5sum] = "2a941e3c64843be69190f38891470580"
SRC_URI[archive.sha256sum] = "955d8eb6ff39f72002a7cfb0bed5e4b6eaad45410441e4a5a767767ec6db26d4"

do_configure_prepend() {
	sed -i -e s:docs::g ${S}/Makefile.am
}

FILES_${PN} += "${datadir}/icons"
