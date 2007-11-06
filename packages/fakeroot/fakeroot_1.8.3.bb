DESCRIPTION = "Gives a fake root environment"
SECTION = "base"
LICENSE = "GPL"
# fakeroot needs getopt which is provided by the util-linux package
RDEPENDS = "util-linux"
PR = "r1"

SRC_URI = "ftp://ftp.debian.org/debian/pool/main/f/fakeroot/fakeroot_${PV}.tar.gz \
           file://configure-libtool.patch;patch=1"
	    
inherit autotools

do_stage() {
        install -d ${STAGING_INCDIR}/fakeroot
        install -m 644 *.h ${STAGING_INCDIR}/fakeroot
        autotools_stage_all
}
