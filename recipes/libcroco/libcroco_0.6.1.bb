DESCRIPTION = "The Libcroco project is an effort to build a generic Cascading Style Sheet (CSS) parsing and manipulation toolkit"
SECTION = "x11/utils"
DEPENDS = "glib-2.0 libxml2"
LICENSE = "LGPL"
PR = "r3"

inherit gnome

SRC_URI_append = " file://croco.patch;patch=1 "


SRC_URI[archive.md5sum] = "b0975bd01eb11964f1b3f254f267a43d"
SRC_URI[archive.sha256sum] = "d23619f37fbc175027315ca641adbc51cae8a055fb78f169a35b965d6ebf3059"
