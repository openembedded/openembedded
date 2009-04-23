DESCRIPTION = "Easy To Use GNOME CD/DVD Burning Application"
LICENSE = "LGPL GPL"
SECTION = "x11/gnome"
inherit gnome

DEPENDS="dbus-glib eel glib-2.0 gtk+ hal libglade libgnomeui nautilus"
# recipe does not exist yet:
#DEPENDS += "gnome-mount"
# FIXME: recipes are missing
#RDEPENDS = "genisoimage growisofs wodim"

PACKAGES += "nautilus-extension-nautilus-cd-burner"
FILES_nautilus-extension-nautilus-cd-burner = "${libdir}/nautilus"
FILES_${PN}-dbg += "${libdir}/nautilus/extensions-*/.debug"

do_install_append() {
	rm ${D}${libdir}/nautilus/extensions-*/*.la
}

do_stage() {
	autotools_stage_all
}
