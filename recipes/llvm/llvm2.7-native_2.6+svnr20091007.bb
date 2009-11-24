require llvm-native.inc

SRCREV = "83459"

PV = "2.6+svnr${SRCPV}"

PR = "r0"

SRC_URI = "\
  svn://llvm.org/svn/llvm-project/llvm/;proto=http;module=trunk \
  file://llvm-debugonly-zeroormore.patch;patch=1 \
"

S = "${WORKDIR}/trunk"

LLVM_RELEASE = "2.7"
