SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "icon-naming-utils-native glib-2.0 intltool-native"

RDEPENDS_${PN} = "hicolor-icon-theme"
RRECOMMENDS_${PN} = "librsvg-gtk"

PR = "r4"

inherit gnome

EXTRA_OECONF = "--disable-hicolor-check"

FILES_${PN} += "${datadir}/*"

SRC_URI[archive.md5sum] = "1b6a782e3f733a5dbb8e62e87a7bdc61"
SRC_URI[archive.sha256sum] = "31ecbd459ae059672793e46c773742897cb95e22ca5900ccdfb2a22aa30f3884"
