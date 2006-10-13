LICENSE = "GPL"
inherit autotools gpe

DESCRIPTION = "GPE time tracker"
GPE_TARBALL_SUFFIX = "bz2"
DEPENDS = "libgpewidget gtk+ sqlite libtododb"
SECTION = "gpe"
RDEPENDS = "gpe-icons"
PR = "r1"
