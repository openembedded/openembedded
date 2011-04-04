DESCRIPTION = "GNOME utilities"
SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "policykit-gnome nautilus gnome-common glib-2.0 gtk+ gconf liboobs system-tools-backends gnome-control-center"
inherit gnome pkgconfig

SRC_URI += "file://remove-docs.patch"

SRC_URI[archive.md5sum] = "93e3d21b041c771d4ac12307e4ef3392"
SRC_URI[archive.sha256sum] = "71d52698ccb60bc07d6e4e442b7cb178ebf1152396379500df5ec62da4c4d14a"

LDFLAGS += "-lgthread-2.0"

FILES_${PN} += "${libdir}/nautilus/extensions-2.0 ${datadir}/glib-2.0/schemas/org.gnome.system-tools.gschema.xml"

FILES_${PN}-dbg += "${libdir}/nautilus/extensions-2.0/.debug"

