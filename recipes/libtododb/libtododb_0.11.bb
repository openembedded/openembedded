LICENSE = "LGPL"
DESCRIPTION = "Database access for GPE to-do list"
SECTION = "gpe/libs"
PRIORITY = "optional"
DEPENDS = "libgpewidget libgpepimc sqlite"

GPE_TARBALL_SUFFIX = "bz2"
inherit pkgconfig gpe autotools


do_stage () {
        autotools_stage_all
}

do_install () {
	gpe_do_install
#	oe_runmake PREFIX=${prefix} DESTDIR=${D} install-devel
}

SRC_URI[md5sum] = "d3fa3b6093eefdb374a78f0fa5d2eb9a"
SRC_URI[sha256sum] = "8841680d9de5b30637719f62cf1c45579700e8eadb5d35b3ece5a637ee85d488"
