DESCRIPTION = "GNOME utilities"
SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "nautilus gnome-common glib-2.0 gtk+ gconf liboobs system-tools-backends gnome-control-center"
inherit gnome pkgconfig

PR = "r2"

SRC_URI += "file://remove-docs.patch;patch=1"

EXTRA_OECONF = "--disable-scrollkeeper \
               "
LDFLAGS += "-lgthread-2.0"

FILES_${PN} += "${libdir}/nautilus/extensions-2.0"

FILES_${PN}-dbg += "${libdir}/nautilus/extensions-2.0/.debug"


SRC_URI[archive.md5sum] = "1c44b84966fda9eb7a09bfdd27d191dd"
SRC_URI[archive.sha256sum] = "6ae2d4c7f649fe17fdae4d5e4c6a08437d708ab17b28cef8a088a9f1b57b4e70"
