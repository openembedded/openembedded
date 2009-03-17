require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r3"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/settings/networksettings \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps \
	   ${HANDHELDS_CVS};module=opie/root \
	  "
