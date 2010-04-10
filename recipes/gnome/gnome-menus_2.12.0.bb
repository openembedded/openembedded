DEPENDS = "python gnome-vfs libxml2 gconf popt gtk+"
LICENSE = "GPL"


inherit gnome pkgconfig

do_stage() {
autotools_stage_all
}

PACKAGES += "${PN}-python"
FILES_${PN} += "${datadir}/desktop-directories/"
FILES_${PN}-python = "${libdir}/python*"


SRC_URI[archive.md5sum] = "615392c4f729f70c03aa3aa7dbe40a95"
SRC_URI[archive.sha256sum] = "f77192ca0b909000f675ad3cd520c313431ee117d554102c7ea486f76f396f6b"
