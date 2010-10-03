require quilt-native.inc

PR = "${INC_PR}.1"

SRC_URI_append = " file://fix_new_GNU_patch_detection.patch"

SRC_URI[md5sum] = "f77adda60039ffa753f3c584a286f12b"
SRC_URI[sha256sum] = "73fd760d3b5cbf06417576591dc37d67380d189392db9000c21b7cbebee49ffc"
