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

SRC_URI[md5sum] = "a487a98a40d64b9f6ee118b10b9cb97a"
SRC_URI[sha256sum] = "7cadb398c106ba8df3b297e345ab1db750ad058c6c2e78b184f18a7f685bf8ef"
