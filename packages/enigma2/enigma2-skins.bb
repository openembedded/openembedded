DESCRIPTION = "Skins for Enigma2"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

SRCDATE = "20080417"

# if you want experimental, use:
#REL_MAJOR="2"
#REL_MINOR="5"
#TAG = ""

# if you want a 2.4-based release, use
REL_MAJOR="2"
REL_MINOR="4"
TAG = ";tag=${PN}_rel${REL_MAJOR}${REL_MINOR}"

PV = "${REL_MAJOR}.${REL_MINOR}cvs${SRCDATE}"

SRC_URI = "cvs://anonymous@cvs.schwerkraft.elitedvb.net/cvsroot/enigma2-skins;module=enigma2-skins;method=pserver${TAG};date=${SRCDATE}"
FILES_${PN} += " /usr/share/enigma2 /usr/share/fonts "

inherit autotools

S = "${WORKDIR}/enigma2-skins"

