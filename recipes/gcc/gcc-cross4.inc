require gcc-cross.inc

DEPENDS += "gmp-native mpfr-native"

EXTRA_OECONF_append_sh4 = " --with-multilib-list=m4,m4-nofpu "
