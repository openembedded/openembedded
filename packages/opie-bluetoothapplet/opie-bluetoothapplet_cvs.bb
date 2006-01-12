include ${PN}.inc
    
PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/net/opietooth/applet \
           ${HANDHELDS_CVS};module=opie/pics/bluetoothapplet"
