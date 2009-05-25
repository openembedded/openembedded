require libiconv.inc
LICENSE = "GPLv3 LGPLv2"

PROVIDES = "virtual/libiconv"
PR = "r1"

#gettext.class cant be inherit here so use this hack
DEPENDS = "${@['','gettext-native'][bb.data.getVar('USE_NLS', d, 1) == 'yes']}"

EXTRA_OECONF +=  "${@['--disable-nls','--enable-nls'][bb.data.getVar('USE_NLS', d, 1) == 'yes']}"

LEAD_SONAME = "libiconv.so"
