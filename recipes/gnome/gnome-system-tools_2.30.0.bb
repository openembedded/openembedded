DESCRIPTION = "GNOME utilities"
SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "policykit-gnome nautilus gnome-common glib-2.0 gtk+ gconf liboobs system-tools-backends gnome-control-center"
inherit gnome pkgconfig

SRC_URI += "file://remove-docs.patch;patch=1"

SRC_URI[archive.md5sum] = "e3e779c8a31c34993315a6c6c78a5ed5"
SRC_URI[archive.sha256sum] = "7bf41b88566f715ede95fd0e4297b64a95450af7f9d63a6741bb9e65ba361c7d"

EXTRA_OECONF = "--disable-scrollkeeper \
               "
LDFLAGS += "-lgthread-2.0"

FILES_${PN} += "${libdir}/nautilus/extensions-2.0"

FILES_${PN}-dbg += "${libdir}/nautilus/extensions-2.0/.debug"

