require ${PN}.inc

PV = "${OPIE_CVS_PV}"
FILE_PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/i18n \
	   ${HANDHELDS_CVS};module=opie/etc/dict"
