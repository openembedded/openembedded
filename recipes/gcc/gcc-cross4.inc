require gcc-cross.inc

EXTRA_OECONF_append_sh4 = " --with-multilib-list=m4,m4-nofpu "
