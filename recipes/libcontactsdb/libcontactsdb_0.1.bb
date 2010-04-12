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

SRC_URI[md5sum] = "575442be0c61e4b1e05f2188e2ae3141"
SRC_URI[sha256sum] = "33a61a28617e5513e58bde9c16ef21c82c582c1513a0a325735c090ebbd9aefe"
