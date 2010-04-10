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

SRC_URI[md5sum] = "a9e90187c1dc183f497bcae34718e415"
SRC_URI[sha256sum] = "6fb70d0b8f410f05988e1f3a3e8c86990c3e84c9958041803e6d0658faae91ea"
