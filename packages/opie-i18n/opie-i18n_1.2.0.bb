include ${PN}.inc
    
TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/i18n \
	   ${HANDHELDS_CVS};tag=${TAG};module=opie/etc/dict"
