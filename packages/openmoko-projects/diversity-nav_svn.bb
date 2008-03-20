DESCRIPTION = "Diversity_nav - a GPS location based communicative application"
HOMEPAGE = "http://diversity.projects.openmoko.org/"
SECTION = "openmoko/applications"
LICENSE = "GPL"
DEPENDS = "evas edje ecore edbus"
RDEPENDS_${PN} = "diversity-daemon"
PV = "0.0.1+svnr${SRCREV}"
PR = "r2"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/diversity/trunk;module=diversity-nav;proto=https"

S = "${WORKDIR}/diversity-nav"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"
