require ${PN}.inc

PR = "${INC_PR}.3"
TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_library.tar.bz2 \
           file://fix-titleheight.patch \
           file://unbreak-logging.patch \
           file://citytime-path-2.patch \
           file://no-include-pro.patch \
           file://unhide_lnkproperties_destructor.patch \
           file://double_name.patch \
          "

