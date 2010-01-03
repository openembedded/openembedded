DESCRIPTION = "A collection of utilities and DSOs to handle compiled objects."
SECTION = "base"
LICENSE = "OSL"
DEPENDS = "libtool"

inherit autotools

SRC_URI = "https://fedorahosted.org/releases/e/l/elfutils/elfutils-${PV}.tar.bz2 \
           http://ftp.de.debian.org/debian/pool/main/e/elfutils/elfutils_0.143-1.diff.gz;patch=1 \
           file://i386_dis.h \
           file://x86_64_dis.h \
"

# The buildsystem wants to generate 2 .h files from source using a binary it just built, let's work around that

do_configure_prepend() {
    sed -i 's:./i386_gendis:echo\ \#:g' ${S}/libcpu/Makefile.am

    cp ${WORKDIR}/*dis.h ${S}/libcpu
}


