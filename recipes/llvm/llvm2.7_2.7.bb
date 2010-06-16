require llvm.inc

PR = "r2"

DEPENDS = "llvm-common llvm2.7-native"

SRC_URI = "\
  http://llvm.org/releases/${PV}/llvm-${PV}.tgz \
  file://BX_to_BLX.patch \
  "

EXTRA_OECMAKE += "\
        -DLLVM_TARGET_ARCH:STRING=${LLVM_ARCH} \
        -DLLVM_ENABLE_ASSERTIONS:BOOL=ON \
        -DCMAKE_BUILD_TYPE:STRING=RelWithDebInfo \
		-DBUILD_SHARED_LIBS:BOOL=ON \
	"

LLVM_RELEASE = "2.7"

SRC_URI[md5sum] = "ac322661f20e7d6c810b1869f886ad9b"
SRC_URI[sha256sum] = "99664bdc8503a306038166af33f28eb426d99e297575a59d74a1a0dcbddbbca5"
