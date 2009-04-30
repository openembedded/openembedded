DESCRIPTION = "Elf2flt is a wrapper around the linker for uclinux platforms"
DEPENDS = "binutils-cross"

PV = "0.0+svnr${SRCPV}"

inherit autotools cross

SRC_URI = "svn://sources.blackfin.uclinux.org/toolchain/trunk;module=${PN}"

S = "${WORKDIR}/${PN}"

EXTRA_OECONF = " --with-libbfd=${STAGING_LIBDIR}/libbfd.a \
                 --with-libiberty=${STAGING_LIBDIR}/libiberty.a \
                 --with-bfd-include-dir=${STAGING_INCDIR} \
               "
