DESCRIPTION = "Editor for the gnome registry"
LICENSE = "GPLv2"
DEPENDS = "policykit gnome-doc-utils gconf"

inherit gnome gconf

SRC_URI[archive.md5sum] = "f3f19df4ce47ca27bf69d355f24ac5ba"
SRC_URI[archive.sha256sum] = "35f5256f1a93e872586bb6b8c81f7ebfdd78ab3edcfa508f59f99f0f75a74839"

do_configure_prepend() {
	sed -i -e s:docs::g ${S}/Makefile.am
}

FILES_${PN} += "${datadir}/icons"
