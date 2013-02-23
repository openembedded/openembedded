DESCRIPTION = "Gives a fake root environment"
HOMEPAGE = "http://fakeroot.alioth.debian.org"
SECTION = "base"
LICENSE = "GPL"

SRC_URI = "\
  http://www.the-little-red-haired-girl.org/pub/nylon/thirdparty/fakeroot_${PV}.tar.gz \
  file://configure-libtool.patch;patch=1 \
"
	    
inherit autotools

do_stage() {
        install -d ${STAGING_INCDIR}/fakeroot
        install -m 644 *.h ${STAGING_INCDIR}/fakeroot
        autotools_stage_all
}

# fakeroot needs getopt which is provided by the util-linux package
RDEPENDS = "util-linux"

