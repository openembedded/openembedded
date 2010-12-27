DESCRIPTION = "Easy To Use GNOME CD/DVD Burning Application"
LICENSE = "LGPLv2 GPLv2"
SECTION = "x11/gnome"

inherit gnome

PR = "r1"

SRC_URI += " file://eject1.diff \
             file://eject2.diff \
             file://03_wodim.patch \
             file://04_readom.patch \
             file://05_genisoimage.patch \
             file://06_fix_warnings_on_build.patch \
"

SRC_URI[archive.md5sum] = "02324246d8e4804e15e41ef7b62836a7"
SRC_URI[archive.sha256sum] = "ac61757df5d0f8f75f05cf9921b0d5638b0a96b68507475b7034739b9afbc93e"

DEPENDS="dbus-glib glib-2.0 gtk+ hal libglade libgnomeui nautilus"

PACKAGES += "nautilus-extension-nautilus-cd-burner"
RDEPENDS_${PN} += "cdrkit"
FILES_nautilus-extension-nautilus-cd-burner = "${libdir}/nautilus"
FILES_${PN}-dbg += "${libdir}/nautilus/extensions-*/.debug"

do_install_append() {
	rm ${D}${libdir}/nautilus/extensions-*/*.la
}

