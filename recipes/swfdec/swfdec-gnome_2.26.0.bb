DESCRIPTION = "flash plugin"
LICENSE = "GPL"

DEPENDS = "gtk+ gconf swfdec"
PR = "r1"

inherit gnome pkgconfig

do_configure_prepend() {
	sed -i -e 's/^SWFDEC_MAJORMINOR=0\.8/SWFDEC_MAJORMINOR=0.9/' configure.ac
}


SRC_URI[archive.md5sum] = "53d611d9a76a06a703650c4b73fd44cc"
SRC_URI[archive.sha256sum] = "bf48dcadd9ca015f40a9aaa9cc94d402e9daf7c88b747789c79fcc921e9e1626"
