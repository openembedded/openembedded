LICENSE     = "LGPL"
DESCRIPTION = "Database access library for GPE calendar"
SECTION  = "gpe/libs"
PRIORITY = "optional"
DEPENDS  = "libgpewidget libgpepimc sqlite"
MAINTAINER  = "Florian Boor <florian.boor@kernelconcepts.de>"

GPE_TARBALL_SUFFIX = "bz2"

inherit pkgconfig gpe autotools


do_stage () {
autotools_stage_all
}
