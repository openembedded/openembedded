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

