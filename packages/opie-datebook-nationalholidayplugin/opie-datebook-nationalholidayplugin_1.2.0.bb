include ${PN}.inc
    
 
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/pim/datebook/holiday/national \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/etc/nationaldays "
