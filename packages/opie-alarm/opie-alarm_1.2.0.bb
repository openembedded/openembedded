include ${PN}.inc
    
 
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/opiealarm \
           file://01opiealarm "
