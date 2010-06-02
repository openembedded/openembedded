require findutils.inc

PR = "${INC_PR}.0"

# newer version is not available on GNU_MIRROR from .inc file, and old 4.2.29 is not available on alpha.gnu.org
SRC_URI = "ftp://alpha.gnu.org/gnu/${BPN}/${BPN}-${PV}.tar.gz \
           file://gettext-0.18-update.patch \
          "

SRC_URI[md5sum] = "f0276639a824f57e78916d3c207ee618"
SRC_URI[sha256sum] = "ee7fad47a8ee62f335f8415e48d3836052b2d00c4df568cac808e25cd42653cc"

