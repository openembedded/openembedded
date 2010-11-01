require xorg-app-common.inc
DESCRIPTION = "manual page browser for X"
DEPENDS += " libxaw libxprintutil libxp libxt"
RDEPENDS_${PN} = " man"
PE = "1"
PR = "${INC_PR}.0"

EXTRA_OECONF += "--with-manconfig=${STAGING_ETCDIR}/man.conf"
SRC_URI[archive.md5sum] = "56a00ccb38996c3518f14bb87c03a03e"
SRC_URI[archive.sha256sum] = "79475c6106ad6e97183790f207c9fa420631548d30b7c0983926e1290afa7f0c"

FILES_${PN} += " /usr/share/X11/xman.help"
