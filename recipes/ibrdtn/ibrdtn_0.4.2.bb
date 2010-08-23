include ibrdtn.inc
DEPENDS += " ibrcommon "

SRC_URI += "file://remove-problematic-cflags.patch"

SRC_URI[md5sum] = "0835f628a2dc3d436b570c480f2a09fd"
SRC_URI[sha256sum] = "fe80f41084c8d9bbce61a935d42d2549b273880ef578f82fa7b22299b7073937"
