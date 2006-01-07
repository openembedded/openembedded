include ${PN}.inc

PV = "1.2.1+cvs${SRCDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/i18n \
	   ${HANDHELDS_CVS};module=opie/etc/dict"
