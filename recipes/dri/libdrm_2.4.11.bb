require libdrm.inc

PR = "${INC_PR}.0"

PACKAGES =+ "${PN}-intel"

FILES_${PN}-intel = "${libdir}/libdrm_intel.so.*"

SRC_URI[md5sum] = "e0e66fae165d0b665b61e9516bf33ade"
SRC_URI[sha256sum] = "5e07ec4b644f50160900d4281a74dd1cbf1535cfe4ab24e0c28ae5b038836a8c"
