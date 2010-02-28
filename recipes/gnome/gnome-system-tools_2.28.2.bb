DESCRIPTION = "GNOME utilities"
SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "nautilus gnome-common glib-2.0 gtk+ gconf liboobs system-tools-backends gnome-control-center"
inherit gnome pkgconfig

SRC_URI += "file://remove-docs.patch;patch=1"
SRC_URI[archive.md5sum] = "6947cd83c8f83af54e76a36ab3bb6cf0"
SRC_URI[archive.sha256sum] = "806dd14792149b7f01e84a214b8d6debda53965e1eb74d189c66498adeb2af29"

EXTRA_OECONF = "--disable-scrollkeeper \
               "
LDFLAGS += "-lgthread-2.0"

FILES_${PN} += "${libdir}/nautilus/extensions-2.0"

FILES_${PN}-dbg += "${libdir}/nautilus/extensions-2.0/.debug"

