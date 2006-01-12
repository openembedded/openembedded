include ${PN}.inc
    
PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/applets/brightnessapplet \
           ${HANDHELDS_CVS};module=opie/pics"
