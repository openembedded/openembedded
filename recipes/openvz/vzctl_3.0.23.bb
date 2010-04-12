DESCRIPTION = "An utility to manage OpenVZ containers"
LICENSE = "GPLv2"

RDEPENDS = "bash gawk sed grep coreutils tar"

SRC_URI = "http://download.openvz.org/utils/vzctl/${PV}/src/vzctl-${PV}.tar.bz2 \
           file://vzctl-add-arm-syscalls.patch;patch=1 \
          "

inherit autotools

FILES_${PN} += " ${libdir}/${PN}/lib*.so*"

SRC_URI[md5sum] = "f44c5721c862546903d6884d79959b70"
SRC_URI[sha256sum] = "3ca7da609ee07b0a8d6b21f05c76b35ba8febc6b5c251b67c759bcbb3bf76eea"
