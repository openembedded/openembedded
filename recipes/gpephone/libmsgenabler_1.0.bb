LICENSE     = "LiPS"
DESCRIPTION = "LiPS message backend library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0 dbus-glib librecord sqlite3"
PR          = "r2"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpephone pkgconfig autotools

FILES_${PN} += "$(datadir)/libmsgenabler"

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "32f04482d3905f05a4f36ac946e7f95d"
SRC_URI[sha256sum] = "c8568dbd5d3ffa200bf81ffbc7baf94902b41998d5c65455a1fbadce15db9953"
