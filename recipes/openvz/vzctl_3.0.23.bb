DESCRIPTION = "An utility to manage OpenVZ containers"
LICENSE = "GPLv2"

RDEPENDS = "bash gawk sed grep coreutils tar"

SRC_URI = "http://download.openvz.org/utils/vzctl/${PV}/src/vzctl-${PV}.tar.bz2 \
           file://vzctl-add-arm-syscalls.patch;patch=1 \
          "

inherit autotools

FILES_${PN} += " ${libdir}/${PN}/lib*.so*"
