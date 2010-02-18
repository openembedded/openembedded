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

LICENSE = "LGPLv2.1 GPLv3"
PR = "${INC_PR}.1"

TOBUILD := "src/tools/bootstrap ${TOBUILD}"
