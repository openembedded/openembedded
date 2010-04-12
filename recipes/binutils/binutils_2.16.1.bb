PR = "r1"

CROSSTOOL_PATCH_URL = "http://www.kegel.com/crosstool/crosstool-0.43/patches/binutils-2.16.1/"
SRC_URI = \
    "${GNU_MIRROR}/binutils/binutils-${PV}.tar.bz2;name=archive \
     ${CROSSTOOL_PATCH_URL}bfd-hash-tweak.patch;patch=1;name=patch1 \
     ${CROSSTOOL_PATCH_URL}binutils-2.15-psignal.patch;patch=1;name=patch2 \
     ${CROSSTOOL_PATCH_URL}binutils-skip-comments.patch;patch=1;name=patch3 \
     ${CROSSTOOL_PATCH_URL}callahan.patch;patch=1;name=patch4 \
     ${CROSSTOOL_PATCH_URL}cross-gprof.patch;patch=1;name=patch5 \
     ${CROSSTOOL_PATCH_URL}stabs-tweak.patch;patch=1;name=patch6 \
     file://binutils-2.16.91.0.6-objcopy-rename-errorcode.patch;patch=1"


require binutils.inc

SRC_URI[archive.md5sum] = "6a9d529efb285071dad10e1f3d2b2967"
SRC_URI[archive.sha256sum] = "351a6846ee179a37ed87a487971547159a7f4f92a1dec598c727f184a0de61ae"
SRC_URI[patch1.md5sum] = "b12426fd72bedf00c389a7fb458275a8"
SRC_URI[patch1.sha256sum] = "5a4a5b82dd8f485b4fef941cc216eb052184cf138f72b512eb62d836b460acdb"
SRC_URI[patch2.md5sum] = "c59d06f1874732814eef3371e2dee72b"
SRC_URI[patch2.sha256sum] = "e8df35e97d6789fd34268e8c2e4daba8aa17e7bf6f0432f6ea8123a2e344363c"
SRC_URI[patch3.md5sum] = "73e76bdd997fa945d71edcfbdd356c15"
SRC_URI[patch3.sha256sum] = "18f72b922a9a346f6c43b20fd86eba76cfd27a8d118ea32fa879050ddebe0267"
SRC_URI[patch4.md5sum] = "455b0813f42723b1bd6c4b9f10964f7b"
SRC_URI[patch4.sha256sum] = "31dbaa878b8e2d51109042c533f371c50aace927b45eda6c282fc632f3662620"
SRC_URI[patch5.md5sum] = "9e5f053de38f3342a426dd580d7ec331"
SRC_URI[patch5.sha256sum] = "7f8105cf71d2a5c7efa0f9e4b9cc61ac5f68a5b57f0daefb4b51b657f0eeac92"
SRC_URI[patch6.md5sum] = "404d3f5e5adfd757dd91e58bd66ed10e"
SRC_URI[patch6.sha256sum] = "393d1f60ee4e3b4ce8138481e17da02ca2f23e06887a0650be2f5ecf85628844"
