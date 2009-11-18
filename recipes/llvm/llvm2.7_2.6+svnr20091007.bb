require llvm.inc

SRCREV = "83459"

PV = "2.6+svnr${SRCPV}"

PR = "r0"

DEPENDS = "llvm-common llvm2.7-native"

SRC_URI = "\
  svn://llvm.org/svn/llvm-project/llvm/;proto=http;module=trunk \
  file://llvm-debugonly-zeroormore.patch;patch=1 \
  file://BX_to_BLX.patch;patch=1 \
  "

EXTRA_OECMAKE += "\
        -DLLVM_TARGET_ARCH:STRING=${LLVM_ARCH} \
        -DLLVM_ENABLE_ASSERTIONS:BOOL=ON \
        -DCMAKE_BUILD_TYPE:STRING=RelWithDebInfo \
	"

S = "${WORKDIR}/trunk"

LLVM_RELEASE = "2.7"
