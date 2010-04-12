require llvm-native.inc

PR = "r0"

SRC_URI += "\
  file://fix-build.patch;patch=1 \
  file://llvm-debugonly-zeroormore.patch;patch=1;pnum=0 \
"

LLVM_RELEASE = "2.6"

SRC_URI[md5sum] = "34a11e807add0f4555f691944e1a404a"
SRC_URI[sha256sum] = "4cd9257350c5ff8b9b139d19497e2396c0604eef0e5d6504f5c1463b09bf2d84"
