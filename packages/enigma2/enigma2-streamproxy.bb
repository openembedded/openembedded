DESCRIPTION = "streamproxy manages streaming data to a PC using enigma2"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

SRCDATE = "20080214"
PV = "1.0cvs${SRCDATE}"

SRC_URI = "cvs://anonymous@cvs.schwerkraft.elitedvb.net/cvsroot/streamproxy;module=enigma2-streamproxy;method=pserver"

inherit autotools

S = "${WORKDIR}/enigma2-streamproxy"
