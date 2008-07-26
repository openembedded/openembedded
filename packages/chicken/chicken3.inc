DESCRIPTION = "A compiler that translates Scheme source files to C, and an interpreter"
HOMEPAGE = "http://www.call-with-current-continuation.org/"
SECTION = "interpreters"
PRIORITY = "optional"
LICENSE = "BSD"

SRC_URI = "http://chicken.wiki.br/releases/${PV}/chicken-${PV}.tar.gz"

inherit autotools

do_compile() {
    export PLATFORM=linux
    export PREFIX=${prefix}
    export HOST=${TARGET_ARCH}-${DISTRO}-${TARGET_OS}
    export C_COMPILER=${HOST}-gcc 
    export LIBRARIAN=${HOST}-ar
    # ARCH= is weird... but it's not enough to export this variable.
    # If ARCH is not set to empty-string, then the Makefile will try to 
    # use the apply-hack.s file applicable to the machine doing the compiling.
    # There is no such apply-hack assembler code for arm, at least not yet.
    make ARCH=
}

do_install() {
    export PLATFORM=linux
    export PREFIX=${prefix}
    export HOST=${TARGET_ARCH}-${DISTRO}-${TARGET_OS}
    export C_COMPILER=${HOST}-gcc 
    export LIBRARIAN=${HOST}-ar
    make ARCH= DESTDIR=${D} install
}

FILES_${PN} = "${bindir}/csi ${bindir}/chicken-bug"
FILES_${PN} += "${libdir}/lib*.so.* ${libdir}/chicken"
FILES_${PN} += "${datadir}/chicken/*.*"
FILES_${PN}-dev += "${bindir}"
