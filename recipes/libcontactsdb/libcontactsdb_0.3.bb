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

SRC_URI[md5sum] = "1398bee49a23bd33bbc3dfd9ac3555f4"
SRC_URI[sha256sum] = "5912c1b64dd09a0cbeaa678772fae00e0eb64ffcad35f5dd80424fa7d4f33f7e"
