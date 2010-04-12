DESCRIPTION = "Window navigation construction toolkit"
LICENSE = "LGPL"
SECTION = "x11/libs"
DEPENDS = "gtk+ gdk-pixbuf-csource-native"

inherit gnome
SRC_URI[archive.md5sum] = "ed79955dabb606ee0e6d112a291005ad"
SRC_URI[archive.sha256sum] = "d35bcc28548945915da4f5cafd0555606f972e236cc5f9dbb0186186dfbf5247"

do_configure() {
	gnu-configize
	oe_runconf
}

