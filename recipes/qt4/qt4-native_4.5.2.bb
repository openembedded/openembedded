require qt4-native.inc

# Older releases have different source archive name, than .inc
SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-embedded-linux-opensource-src-${PV}.tar.bz2 \
           file://configure-lflags.patch \
           file://qt-config.patch \
           file://g++.conf \
           file://linux.conf"

S = "${WORKDIR}/qt-embedded-linux-opensource-src-${PV}"

EXTRA_OECONF += " -fast -qt-freetype"

do_configure() {
   (echo o; echo yes) | LFLAGS="-L${STAGING_LIBDIR_NATIVE}" ./configure ${EXTRA_OECONF} || die "Configuring qt failed. EXTRA_OECONF was ${EXTRA_OECONF}"
}

LICENSE = "LGPLv2.1 GPLv3"
PR = "${INC_PR}.2"

TOBUILD := "src/tools/bootstrap ${TOBUILD}"

SRC_URI[md5sum] = "62186345c609a72b89f16d83bc7a130f"
SRC_URI[sha256sum] = "272301a27e2f7bcd44c8d09f496e1c749c80b86d9489ea9c30bb265bf2dd02fc"
