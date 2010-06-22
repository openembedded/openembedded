DEPENDS += "dri2proto expat libdrm makedepend-native"

FILESPATHPKG =. "mesa-${PV}:mesa:"

# most of our targets do not have DRI so will use mesa-xlib
DEFAULT_PREFERENCE = "-1"

EXTRA_OECONF += " --with-driver=dri --with-dri-drivers=swrast,${MACHINE_DRI_MODULES}"
