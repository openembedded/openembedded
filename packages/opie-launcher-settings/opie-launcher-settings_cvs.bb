include ${PN}.inc
    
PV = "1.2.0+cvs-${CVSDATE}"
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/settings/launcher \
           ${HANDHELDS_CVS};module=opie/apps \
	   cvs://anoncvs:anoncvs@cvs.handhelds.org/Cvs;module=opie/pics"
