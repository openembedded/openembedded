DESCRIPTION = "GPE time tracker"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "libgpewidget gtk+ sqlite libtododb"
RDEPENDS = "gpe-icons"
PR = "r1"
PV = "0.31+svn-${SRCDATE}"

inherit autotools 

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"

DEFAULT_PREFERENCE = "-1"
