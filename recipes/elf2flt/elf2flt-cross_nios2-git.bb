DESCRIPTION = "Elf2flt is a wrapper around the linker for uclinux platforms"
PV = "0.1"
DEPENDS = "binutils-cross"

inherit autotools cross

SRC_URI = "git://sopc.et.ntust.edu.tw/git/elf2flt.git;protocol=git;branch=nios2;tag=7f2f6c6b107fb18b6b6d3692b273a00315948da4"

S = "${WORKDIR}/git"

EXTRA_OECONF = " --with-libbfd=/home/walter//nios2-linux/toolchain-build/build/binutils-build/bfd/libbfd.a \
                 --with-libiberty=/home/walter/nios2-linux/toolchain-build/build/binutils-build/libiberty/libiberty.a \
                 --with-bfd-include-dir=${STAGING_INCDIR} \
		 --disable-emit-relocs \
               "
