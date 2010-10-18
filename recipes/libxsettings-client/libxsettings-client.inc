SECTION = "gpe/libs"
LICENSE = "BSD-X"
PRIORITY = "optional"
DEPENDS = "libxsettings virtual/libx11 libxt"
RDEPENDS_${PN}-dev += " libxsettings-dev"
# libxt is required to stop configure breaking builds by
# including system paths to find it if it isn't present.

GPE_TARBALL_SUFFIX = "bz2"
inherit autotools pkgconfig gpe

INC_PR = "r5"

SRC_URI = "${GPE_MIRROR}/libxsettings-client-${PV}.tar.bz2"

do_install_append () {
        rm ${D}/${includedir}/xsettings-common.h
}
