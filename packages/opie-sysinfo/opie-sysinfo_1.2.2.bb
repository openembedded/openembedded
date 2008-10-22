require ${PN}.inc
PR = "r1"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/settings/sysinfo \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/share"

SRC_URI_append_jlime = "file://jornada-6xx-7xx.patch;patch=1"
