DESCRIPTION = "Database access library for GPE contacts"
LICENSE = "LGPL"
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "libgpewidget libgpepimc sqlite"

GPE_TARBALL_SUFFIX = "bz2"

inherit autotools gpe pkgconfig

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "aba090380cc30c553b2e880382bc788e"
SRC_URI[sha256sum] = "ec8f6bb5c8e0bfbf53cae21c8e5c3cfd3b442aa7ffb4eaa646c81c0449dc0bc9"
