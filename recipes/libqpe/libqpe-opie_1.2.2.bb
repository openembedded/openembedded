require ${PN}.inc

PR = "${INC_PR}.0"
TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/library \
	file://save-windows-pos-dynamic.patch;patch=1 \
	file://fix-titleheight.patch;patch=1"
