DESCRIPTION = "A collection of utilities and DSOs to handle compiled objects."
SECTION = "base"
LICENSE = "OSL"
DEPENDS = "libtool"
PR = "r0"

inherit autotools

SRC_URI = "https://fedorahosted.org/releases/e/l/elfutils/${PV}/elfutils-${PV}.tar.bz2;name=archive \
           file://redhat-portability.diff \
           file://redhat-robustify.diff \
           file://hppa_backend.diff \
           file://arm_backend.diff \
           file://mips_backend.diff \
           file://m68k_backend.diff \
           file://testsuite-ignore-elflint.diff \
           file://elf_additions.diff \
           file://alldts.patch \
           file://scanf-format.patch \
           file://elf_end_unlock.patch \
           file://strip_sh_type.patch \
           file://mips_readelf_w.patch \
           file://i386_dis.h \
           file://x86_64_dis.h \
"

# The buildsystem wants to generate 2 .h files from source using a binary it just built, let's work around that

do_configure_prepend() {
    sed -i 's:./i386_gendis:echo\ \#:g' ${S}/libcpu/Makefile.am

    cp ${WORKDIR}/*dis.h ${S}/libcpu
}

SRC_URI[archive.md5sum] = "289a146182bc29f0236eaa15d8ebdf98"
SRC_URI[archive.sha256sum] = "b6cd7d1fe81d5f874061b7d753f5b5a0546ccc5fd83af843201330479332bef0"

FILES_${PN} += "${libdir}/libasm-${PV}.so ${libdir}/libdw-${PV}.so ${libdir}/libelf-${PV}.so"
