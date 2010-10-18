SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "icon-naming-utils-native glib-2.0 intltool-native"

inherit gnome

SRC_URI[archive.md5sum] = "8e727703343d4c18c73c79dd2009f8ed"
SRC_URI[archive.sha256sum] = "ea7e05b77ead159379392b3b275ca0c9cbacd7d936014e447cc7c5e27a767982"

EXTRA_OECONF = "--disable-hicolor-check"

# autotools_do_configure doesn't seem to work so override it
# should be safe since this is just a bunch of icons - koen 20101018
do_configure() {
	gnu-configize
	oe_runconf
}

FILES_${PN} += "${datadir}/*"
RDEPENDS_${PN} = "hicolor-icon-theme"
RRECOMMENDS_${PN} = "librsvg-gtk"

