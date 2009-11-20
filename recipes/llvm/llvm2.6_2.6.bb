require llvm.inc

PR = "r1"

DEPENDS = "llvm-common llvm2.6-native"

SRC_URI += "\
  file://fix-build.patch;patch=1 \
  file://llvm-debugonly-zeroormore.patch;patch=1;pnum=0 \
  file://BX_to_BLX.patch;patch=1 \
"

LLVM_RELEASE = "2.6"
