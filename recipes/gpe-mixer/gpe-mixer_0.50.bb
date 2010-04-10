DESCRIPTION = "GPE audio mixer"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget"
PR = "r0"

inherit gpe autotools pkgconfig
SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2"
SRC_URI[md5sum] = "67765a32def3ee408e84b9814b4e9759"
SRC_URI[sha256sum] = "e7a13c0fd3eb0768034008778cb724aed8fbdf63d460d4df7212c3d2c14325b9"
