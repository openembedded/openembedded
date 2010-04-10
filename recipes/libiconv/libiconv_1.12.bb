require libiconv.inc
LICENSE = "GPLv3 LGPLv2"

PROVIDES = "virtual/libiconv"
PR = "r1"

#gettext.class cant be inherit here so use this hack
DEPENDS = "${@['','gettext-native'][bb.data.getVar('USE_NLS', d, 1) == 'yes']}"

EXTRA_OECONF +=  "${@['--disable-nls','--enable-nls'][bb.data.getVar('USE_NLS', d, 1) == 'yes']}"

LEAD_SONAME = "libiconv.so"

SRC_URI[md5sum] = "c2be282595751535a618ae0edeb8f648"
SRC_URI[sha256sum] = "a99e244fd78babb95ea3c9a5c88b964994edaa1d15fd8dde5b4067801e23f0cd"
