LICENSE     = "LiPS"
DESCRIPTION = "LiPS database API."
SECTION = "gpe/libs"
PRIORITY    = "optional"
DEPENDS     = "glib-2.0 util-linux-ng sqlite3"
PR          = "r0"

GPE_TARBALL_SUFFIX = "bz2"
inherit gpephone pkgconfig autotools

LDFLAGS += " -L${STAGING_LIBDIR}"

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "782dc4ea50518d5dfce4b47a7c9b56b6"
SRC_URI[sha256sum] = "7131cf051d6a98d29358ea56a60db3d8e104bf97d9e9473622cc3523391839e5"
