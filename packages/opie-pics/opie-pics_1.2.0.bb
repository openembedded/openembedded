include ${PN}.inc
    
TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics-hires"
