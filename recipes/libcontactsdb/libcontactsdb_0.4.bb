LICENSE = "LGPL"
DESCRIPTION = "Database access library for GPE contacts"
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "libgpewidget libgpepimc sqlite"

PR = "r0"
GPE_TARBALL_SUFFIX = "bz2"

inherit autotools gpe pkgconfig

do_stage () {
autotools_stage_all
}

SRC_URI[md5sum] = "a74c72dc7d9acf01109562d9a5f761e6"
SRC_URI[sha256sum] = "8b48efab70ba1322e6f012b78d7614d6012411afe47107a5e2c1f27e1eaef3b7"
