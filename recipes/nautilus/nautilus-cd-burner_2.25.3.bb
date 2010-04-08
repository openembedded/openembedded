DESCRIPTION = "Easy To Use GNOME CD/DVD Burning Application"
LICENSE = "LGPL GPL"
SECTION = "x11/gnome"

inherit gnome

SRC_URI += " file://eject1.diff;patch=1 \
             file://eject2.diff;patch=1 \
"

SRC_URI[archive.md5sum] = "02324246d8e4804e15e41ef7b62836a7"
SRC_URI[archive.sha256sum] = "ac61757df5d0f8f75f05cf9921b0d5638b0a96b68507475b7034739b9afbc93e"

DEPENDS="dbus-glib glib-2.0 gtk+ hal libglade libgnomeui nautilus"
# FIXME: recipes are missing
#RDEPENDS_${PN} = "genisoimage growisofs wodim"

PACKAGES += "nautilus-extension-nautilus-cd-burner"
FILES_nautilus-extension-nautilus-cd-burner = "${libdir}/nautilus"
FILES_${PN}-dbg += "${libdir}/nautilus/extensions-*/.debug"

do_install_append() {
	rm ${D}${libdir}/nautilus/extensions-*/*.la
}

