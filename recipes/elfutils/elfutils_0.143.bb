DESCRIPTION = "A collection of utilities and DSOs to handle compiled objects."
SECTION = "base"
LICENSE = "OSL"
DEPENDS = "libtool"

inherit autotools

SRC_URI = "https://fedorahosted.org/releases/e/l/elfutils/elfutils-${PV}.tar.bz2;name=archive \
           http://ftp.de.debian.org/debian/pool/main/e/elfutils/elfutils_0.143-1.diff.gz;patch=1;name=patch \
           file://i386_dis.h \
           file://x86_64_dis.h \
"

# The buildsystem wants to generate 2 .h files from source using a binary it just built, let's work around that

do_configure_prepend() {
    sed -i 's:./i386_gendis:echo\ \#:g' ${S}/libcpu/Makefile.am

    cp ${WORKDIR}/*dis.h ${S}/libcpu
}



SRC_URI[archive.md5sum] = "06e35c348e78dec58f6aeb51bd397760"
SRC_URI[archive.sha256sum] = "435c0c8a7ed5ca34ea5ac985041faedf56b21a6cdd24058e3c2f3b5347d238ff"
SRC_URI[patch.md5sum] = "c211d10508e3494cfce77f5807bbfff2"
SRC_URI[patch.sha256sum] = "d69dd1c9885752c2b1a00403d1ac2a876268701654a31723123e26ab72be4258"
