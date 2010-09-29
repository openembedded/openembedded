require ${PN}.inc

PR = "${INC_PR}.2"
TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/library \
           file://fix-titleheight.patch \
           file://unbreak-logging.patch \
           file://citytime-path-2.patch \
           file://no-include-pro.patch \
           file://unhide_lnkproperties_destructor.patch \
	   file://double_name.patch \
          "

