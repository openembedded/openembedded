require libx11.inc
PR = "${INC_PR}.1"

SRC_URI += " file://dolt-fix.patch"
SRC_URI += " file://configure.ac-nios2.patch"
SRC_URI[archive.md5sum] = "8e0a8a466aa78f66e09fe06cb395319f"
SRC_URI[archive.sha256sum] = "599826765c59a98b1e58b4f6c4ad50dca69eeb0e7bd78aea736ca815f45bea40"
