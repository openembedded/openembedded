LICENSE = "GPL"
SECTION = "libs"

DEPENDS= "gtk+ libxml2 bzip2 glib-2.0 zlib gtk-doc libbonobo gnome-vfs"
RDEPENDS = "gconf gnome-vfs"

PACKAGES =+ "${PN}-gnome ${PN}-gnome-dev "

FILES_${PN}-gnome = "${libdir}/libgsf-gnome-1.so.*"
FILES_${PN}-gnome-dev = "${libdir}/libgsf-gnome-1.* ${includedir}/libgsf-1/gsf-gnome"

inherit gnome

EXTRA_OECONF = "\
		--without-python \
		--with-gnome \
		--with-bz2"

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "8478d83fda0b6e57f36550c11a693ee1"
SRC_URI[archive.sha256sum] = "11fd8fca1bdbcfa426276a124ad083cca9632f03cf766523bcdfb2fca0b08908"
