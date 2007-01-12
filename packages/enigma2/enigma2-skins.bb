DESCRIPTION = "Skins for Enigma2"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

SRCDATE = "20070113"
PV = "1.0cvs${SRCDATE}"

SRC_URI = "cvs://anonymous@cvs.schwerkraft.elitedvb.net/cvsroot/enigma2-skins;module=enigma2-skins;method=pserver"
FILES_${PN} += " /usr/share/enigma2 /usr/share/fonts "

inherit autotools

S = "${WORKDIR}/enigma2-skins"

