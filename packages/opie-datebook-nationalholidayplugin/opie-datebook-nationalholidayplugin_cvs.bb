include ${PN}.inc
    
PV = "1.2.1+cvs-${CVSDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/pim/datebook/holiday/national \
           ${HANDHELDS_CVS};module=opie/etc/nationaldays "
