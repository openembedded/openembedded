require llvm-native.inc

SRCREV = "70854"

PV = "2.5+svnr${SRCREV}"

PR = "r0"

SRC_URI = "\
  svn://llvm.org/svn/llvm-project/llvm/;proto=http;module=trunk \
  file://fix-build.patch;patch=1 \
  file://llvm-enable-threads-macro.patch;patch=1;pnum=0 \
  file://llvm-debugonly-zeroormore.patch;patch=1;pnum=0 \
"

S = "${WORKDIR}/trunk"

LLVM_RELEASE = "2.6"
