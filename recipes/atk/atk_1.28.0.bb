DESCRIPTION = "An accessibility toolkit for GNOME."
SECTION = "x11/libs"
PRIORITY = "optional"
LICENSE = "LGPL"

inherit gnome

DEPENDS = "glib-2.0 gtk-doc-native"


EXTRA_OECONF = "--disable-glibtest"

BBCLASSEXTEND = "native"

SRC_URI[archive.md5sum] = "010a85478adc053c016a0a5c9bb52004"
SRC_URI[archive.sha256sum] = "e4da9fe580d2d55f4e77a138c553b4b32654dfb06bf0715592cc9dbd6355fe87"
