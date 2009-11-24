DESCRIPTION = "Elf2flt is a wrapper around the linker for uclinux platforms"
PV = "0.1"
DEPENDS = "binutils-cross"

inherit autotools cross

SRC_URI = "git://sopc.et.ntust.edu.tw/git/elf2flt.git;protocol=git;branch=nios2;tag=7f2f6c6b107fb18b6b6d3692b273a00315948da4"

S = "${WORKDIR}/git"

EXTRA_OECONF = " --with-libiberty=${CROSS_DIR}/lib/libiberty.a \
                 --with-libbfd=${CROSS_DIR}/${HOST_SYS}/${TARGET_SYS}/lib/libbfd.a \
                 --with-bfd-include-dir=${CROSS_DIR}/${HOST_SYS}/${TARGET_SYS}/include \
                 --with-binutils-include-dir=${CROSS_DIR}/include \
                 --disable-emit-relocs \
               "

