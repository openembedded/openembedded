DESCRIPTION = "Diversity_nav - a GPS location based communicative application"
HOMEPAGE = "http://diversity.projects.openmoko.org/"
SECTION = "openmoko/applications"
LICENSE = "GPL"
DEPENDS = "evas edje ecore edbus"
RDEPENDS = "libevas-engine-buffer libevas-engine-software-16 libevas-engine-software-16-x11 libevas-engine-software-generic libevas-engine-software-x11 libevas-loader-eet libevas-loader-jpeg libevas-loader-png"
PV = "0.0.1+svnr${SRCREV}"
PR = "r1"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/diversity/trunk;module=diversity-nav;proto=https"

S = "${WORKDIR}/diversity-nav"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"
