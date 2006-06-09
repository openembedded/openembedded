include ${PN}.inc

PR = "r1"

TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}" 

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/library \
        file://0905_datebookmonth.patch;patch=1;pnum=0 \
	file://fix-titleheight.patch;patch=1"

