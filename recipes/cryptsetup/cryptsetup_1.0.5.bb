# Copyright Matthias Hentges <devel@hentges.net> (c) 2007
# License: MIT (see http://www.opensource.org/licenses/mit-license.php
#               for a copy of the license)

DESCRIPTION = "cryptsetup with luks support creates and manages encrypted containers and partitions"
HOMEPAGE = "http://luks.endorphin.org/"
SECTION = "console"
LICENSE = "GPL"
DEPENDS = "util-linux-ng device-mapper libgcrypt popt"
RRECOMMENDS = "kernel-module-aes \
               kernel-module-dm-crypt \
               kernel-module-md5 \
               kernel-module-cbc \
               kernel-module-sha256 \
              "
PR = "r2"

SRC_URI = "http://luks.endorphin.org/source/cryptsetup-${PV}.tar.bz2"

inherit autotools


SRC_URI[md5sum] = "0aa2f94c39123f1a0352983e5366179c"
SRC_URI[sha256sum] = "4bab529afa00cafde3bc5df2769578c88438f80c5152d4257cd0e86986f95bc4"
