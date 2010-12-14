require ${PN}.inc

PR = "${INC_PR}.3"
TAG = "${@'v' + bb.data.getVar('PV',d,1).replace('.', '_')}"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_library.tar.bz2;name=split_library \
           file://fix-titleheight.patch \
           file://unbreak-logging.patch \
           file://citytime-path-2.patch \
           file://no-include-pro.patch \
           file://unhide_lnkproperties_destructor.patch \
           file://double_name.patch \
          "
SRC_URI[split_library.md5sum] = "3d87eb4c998e41b7de6f9068c55e3b33"
SRC_URI[split_library.sha256sum] = "01df3821333ba654fe91728aa153438330af6a4b66d2a7c5bb01cda53a49c5d3"

