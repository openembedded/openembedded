SECTION = "base"
DESCRIPTION = "Gives a fake root environment which can support chroot"
LICENSE = "GPL"

SRC_URI = "${DEBIAN_MIRROR}/main/f/fakechroot/fakechroot_${PV}.orig.tar.gz \
           file://fix-readlink.patch;patch=1"

inherit autotools

SRC_URI[md5sum] = "b885951b98f4316f9686699e9853513d"
SRC_URI[sha256sum] = "990cd830ea362ba2cb88ca7b59cd3f4d115a054621450b5cf211cadebed23ee0"
