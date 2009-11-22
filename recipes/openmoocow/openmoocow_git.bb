DESCRIPTION = "OpenMooCow makes your phone (nearly) become a cow!"
HOMEPAGE = "http://www.srcf.ucam.org/~taw27/openmoko/openmoocow/"
AUTHOR = "Thomas White"
LICENSE = "GPLv3"
SECTION = "applications/games"
PV = "0.0.3+gitr${SRCREV}"
PR = "r1"

SRC_URI = "git://git.bitwiz.org.uk/openmoocow.git;protocol=git;branch=master"
S = "${WORKDIR}/git"
inherit autotools


