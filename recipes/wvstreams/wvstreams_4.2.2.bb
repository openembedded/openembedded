HOMEPAGE = "http://alumnit.ca/wiki/index.php?page=WvStreams"
LICENSE = "LGPL"
DESCRIPTION = "WvStreams is a network programming library in C++"
DEPENDS = "zlib openssl (>= 0.9.8)"

PR = "r1"

SRC_URI = "http://ftp.de.debian.org/debian/pool/main/w/wvstreams/${PN}_${PV}.orig.tar.gz;name=archive \
           http://ftp.de.debian.org/debian/pool/main/w/wvstreams/wvstreams_4.2.2-2.2.diff.gz;patch=1;name=patch22 \
           file://wvstreams-debian.patch;patch=1 \
           file://build-fixes-and-sanity.patch;patch=1 "

inherit autotools pkgconfig

LDFLAGS_append = " -Wl,-rpath-link,${CROSS_DIR}/${TARGET_SYS}/lib"

EXTRA_AUTORECONF += " -I${S}/gnulib/m4"
EXTRA_OECONF = " --without-tcl --without-qt --without-pam"

PACKAGES_prepend = "libuniconf libuniconf-dbg "
PACKAGES_prepend = "uniconfd uniconfd-dbg "
PACKAGES_prepend = "libwvstreams-base libwvstreams-base-dbg "
PACKAGES_prepend = "libwvstreams-extras libwvstreams-extras-dbg "

FILES_libuniconf     = "${libdir}/libuniconf.so.*"
FILES_libuniconf-dbg = "${libdir}/.debug/libuniconf.so.*"

FILES_uniconfd     = "${sbindir}/uniconfd ${sysconfdir}/uniconf.conf ${localstatedir}/uniconf"
FILES_uniconfd-dbg = "${sbindir}/.debug/uniconfd"

FILES_libwvstreams-base     = "${libdir}/libwvutils.so.*"
FILES_libwvstreams-base-dbg = "${libdir}/.debug/libwvutils.so.*"

FILES_libwvstreams-extras     = "${libdir}/libwvbase.so.* ${libdir}/libwvstreams.so.*"
FILES_libwvstreams-extras-dbg = "${libdir}/.debug/libwvbase.so.* ${libdir}/.debug/libwvstreams.so.*"


do_stage() {
    autotools_stage_all
}

SRC_URI[archive.md5sum] = "103230cb9926cb8f3f4d8dc8584f3b9c"
SRC_URI[archive.sha256sum] = "8fa45a6bfe4d6ac3d9a457543844873090d0c7da817991ac0cd547732f475a14"
SRC_URI[patch22.md5sum] = "58e1df79ce031b256417ba5992cce833"
SRC_URI[patch22.sha256sum] = "f203a843f11d53ed075a03c07a85e2b5d43dec4cff4da791a96265dfdbee1030"
