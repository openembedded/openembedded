require ${PN}.inc

PR = "${INC_PR}.0"
TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/library \
	file://save-windows-pos-dynamic.patch \
	file://fix-titleheight.patch"
