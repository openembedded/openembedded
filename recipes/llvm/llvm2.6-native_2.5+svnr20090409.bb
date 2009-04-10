require llvm-native.inc

SRCREV = "68706"

PV = "2.5+svnr${SRCREV}"

PR = "r1"

SRC_URI = "svn://llvm.org/svn/llvm-project/llvm/;proto=http;module=trunk \
           file://fix-build.patch;patch=1"

S = "${WORKDIR}/trunk"

