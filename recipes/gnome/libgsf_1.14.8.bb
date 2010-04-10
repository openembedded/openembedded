LICENSE = "GPL"
SECTION = "libs"
PR = "r0"

DEPENDS= "libxml2 bzip2 glib-2.0 zlib gtk-doc libbonobo gnome-vfs"
RDEPENDS = "gconf gnome-vfs"


PACKAGES =+ "${PN}-gnome ${PN}-gnome-dev "

FILES_${PN}-gnome = "${libdir}/libgsf-gnome-1.so.*"
FILES_${PN}-gnome-dev = "${libdir}/libgsf-gnome-1.* ${includedir}/libgsf-1/gsf-gnome"

inherit autotools pkgconfig gnome gconf

EXTRA_OECONF = "\
		--without-python \
		--with-gnome \
		--with-bz2"

do_stage() {
autotools_stage_all
}

SRC_URI[archive.md5sum] = "09e4b6639be79fa888cabc751f73674f"
SRC_URI[archive.sha256sum] = "d5f635ea86f8417dd777c32bcf7ef86cf3af3912f34ae21db9933a0e48e54748"
