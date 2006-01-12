include ${PN}.inc

PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/i18n \
	   ${HANDHELDS_CVS};module=opie/etc/dict"
