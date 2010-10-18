require gcc-cross.inc

EXTRA_OECONF_append_sh4 = " --with-cpu=${FEED_ARCH} --with-multilib-list= "
