LICENSE     = "LiPS"
DESCRIPTION = "LiPS calendar database backend library."
SECTION = "gpe/libs"
PRIORITY    = "optional"
PR          = "r1"
DEPENDS     = "glib-2.0 util-linux-ng sqlite3"

GPE_TARBALL_SUFFIX = "gz"

inherit gpephone pkgconfig autotools

LDFLAGS += " -L${STAGING_LIBDIR}"

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "7f815fa70e9c3085897f755e124155f2"
SRC_URI[sha256sum] = "97f63ed9c2d685a25306bd5ffa4bdf0a5e296c9ad28fd7210e6e53f75cf6dcc4"
