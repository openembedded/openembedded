DESCRIPTION = "Rodent vector icon theme used by XFCE"
PACKAGE_ARCH = "all"

inherit xfce

FILES_${PN} += "${datadir}/xfce4"

SRC_URI[md5sum] = "d3e3e64596a7efa857d2e6bb0cbd09bb"
SRC_URI[sha256sum] = "72178637c479ba848747285e0c7dc53a3abfe26b6517df5e75c7449542017350"
