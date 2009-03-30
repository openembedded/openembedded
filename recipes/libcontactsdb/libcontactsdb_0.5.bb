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
