DESCRIPTION = "Diversity_nav - a GPS location based communicative application"
LICENSE = "GPL"
DEPENDS = "evas edje ecore edbus"
RDEPENDS = "libevas-engine-buffer libevas-engine-software-16 libevas-engine-software-16-x11 libevas-engine-software-generic libevas-engine-software-x11 libevas-loader-eet libevas-loader-jpeg libevas-loader-png"
SECTION = "openmoko/applications"

SRCREV = "${AUTOREV}"
PV = "0.0.1+svnr${SRCREV}"
PR = "r1"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"
SRC_URI = "svn://svn.internal.openmoko.org/trunk/diversity/ui/modules;module=diversity_nav;proto=https"

S = "${WORKDIR}/diversity_nav"

inherit autotools pkgconfig
