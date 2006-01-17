include ${PN}.inc

PR = "r3"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/apps/${APPNAME} \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
	   file://1686-bugfix.patch;patch=1 \
	   file://1647-bugfix.patch;patch=1 \
	   file://0117_opie-console-use-default-fixed.diff;patch=1"
