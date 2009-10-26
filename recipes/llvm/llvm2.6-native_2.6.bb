require llvm-native.inc

PR = "r0"

SRC_URI += "\
  file://fix-build.patch;patch=1 \
  file://llvm-debugonly-zeroormore.patch;patch=1;pnum=0 \
"

LLVM_RELEASE = "2.6"
