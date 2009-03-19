require gpe-ownerinfo.inc

PR = "r1"
PV = "0.28+svn-${SRCDATE}"

DEFAULT_PREFERENCE = "-1"

SRC_URI += "${GPE_SVN} \
	    file://svn-build.patch;patch=1" 

S = "${WORKDIR}/${PN}"
