include ${PN}.inc
    
PV = "${OPIE_CVS_PV}"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/apps/calibrate \
           ${HANDHELDS_CVS};module=opie/noncore/settings/mediummount \
           ${HANDHELDS_CVS};module=opie/core/launcher \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps \
           ${HANDHELDS_CVS};module=opie/root \
           ${HANDHELDS_CVS};module=opie/etc \
           file://nomax.patch;patch=1;pnum=3 \
           file://server.pro \
           file://opie-reorgfiles \
           file://opie \
           file://qpe.conf \
           file://locale.conf \
           file://opie_defaults"
