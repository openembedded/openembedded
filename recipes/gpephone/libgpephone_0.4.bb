LICENSE     = "LGPL"
DESCRIPTION = "Base library for GPE phone environment."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "gtk+ gtk-doc dbus-glib"
PR          = "r0"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpephone pkgconfig autotools

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "fae122bd44d6da9a006f65aedbd6461e"
SRC_URI[sha256sum] = "cd84dc0e4b903871339e5e097a51d09a76ee9e1495783a47bb5ba81d633810da"
