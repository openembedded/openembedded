include ${PN}.inc
    
PV = "1.2.0+cvs-${CVSDATE}"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/library \
           file://fix-titleheight.patch;patch=1"

