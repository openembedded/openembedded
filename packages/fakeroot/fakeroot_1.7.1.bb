DESCRIPTION = "Gives a fake root environment"
SECTION = "base"
LICENSE = "GPL"
# fakeroot needs getopt which is provided by the util-linux package
RDEPENDS = "util-linux"
PR = "r2"

SRC_URI = "\
  ftp://ftp.gentoo.mesh-solutions.com/mirrors/gentoo/distfiles/fakeroot_1.7.1.tar.gz \
  file://work-with-older-libtool.patch;patch=1 \
"

inherit autotools

do_stage() {
        install -d ${STAGING_INCDIR}/fakeroot
        install -m 644 *.h ${STAGING_INCDIR}/fakeroot
        autotools_stage_all
}
