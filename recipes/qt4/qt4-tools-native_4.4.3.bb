require qt4-tools-native.inc

# Older releases have different source archive name, than .inc
SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-embedded-linux-opensource-src-${PV}.tar.bz2 \
           file://configure-lflags.patch;patch=1 \
           file://qt-config.patch;patch=1 \
           file://g++.conf \
           file://linux.conf"

S = "${WORKDIR}/qt-embedded-linux-opensource-src-${PV}"

EXTRA_OECONF += " -fast"

do_configure() {
   (echo o; echo yes) | LFLAGS="-L${STAGING_LIBDIR_NATIVE}" ./configure ${EXTRA_OECONF} || die "Configuring qt failed. EXTRA_OECONF was ${EXTRA_OECONF}"
}

PR = "${INC_PR}.1"

SRC_URI[md5sum] = "9a639aec44a1e4c70040117183d247a3"
SRC_URI[sha256sum] = "05d06b93f95092f1318634fca24f0c2d0a1252c9f1dc2fbb427b07e8ecbb4f39"
