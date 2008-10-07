require ${PN}.inc

PR = "r0"
SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/pics"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"
