DESCRIPTION = "Database access library for GPE calendar"
SECTION = "gpe/libs"
LICENSE = "LGPL"
PRIORITY = "optional"
DEPENDS = "libgpewidget libgpepimc sqlite"

GPE_TARBALL_SUFFIX = "bz2"

inherit pkgconfig gpe autotools

