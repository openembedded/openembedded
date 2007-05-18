require gpe-bluetooth.inc

PV = "0.54+svn${SRCDATE}" 
PR = "r0"

SRC_URI = "${GPE_SVN}"

S = ${WORKDIR}/${PN}