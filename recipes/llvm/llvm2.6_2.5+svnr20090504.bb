require llvm.inc

SRCREV = "70854"

PV = "2.5+svnr${SRCREV}"

PR = "r0"

DEPENDS = "llvm-common llvm2.6-native"

SRC_URI = "\
  svn://llvm.org/svn/llvm-project/llvm/;proto=http;module=trunk \
  file://fix-build.patch;patch=1 \
  file://llvm-debugonly-zeroormore.patch;patch=1;pnum=0 \
  file://llvm-fix-pthreads_h.patch;patch=1;pnum=0 \
  file://llvm-fix-have_libpthread.patch;patch=1 \
"

S = "${WORKDIR}/trunk"

LLVM_RELEASE = "2.6"
