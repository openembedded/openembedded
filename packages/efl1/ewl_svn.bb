DESCRIPTION = "The Enlightened Widget Library"
DEPENDS = "evas ecore edje emotion efreet epsilon"
LICENSE = "MIT BSD"
PV = "0.5.2.042+svnr${SRCREV}"
PR = "r3"

inherit efl

EXTRA_OECONF = "\
  --enable-software-x11 \
  --enable-software-16-x11 \
  --enable-xrender-x11 \
  --disable-opengl-x11 \
  --disable-software-xcb \
  --disable-software-sdl \
  --enable-framebuffer \
  --enable-software-buffer \
  --disable-opengl-glew \
"

# TODO package engines more granular
PACKAGES += "${PN}-plugins ${PN}-engines"

FILES_${PN} += "${sysconfdir}/ewl/*"
FILES_${PN}-tests += "${libdir}/ewl/tests/*.so*"
FILES_${PN}-dev += "${libdir}/ewl/*/*.a ${libdir}/ewl/*/*.la"
FILES_${PN}-dbg += "${libdir}/ewl/*/.debug"

FILES_${PN}-engines = "${libdir}/ewl/engines/*.so*"
FILES_${PN}-plugins = "${libdir}/ewl/plugins/*.so*"

RRECOMMENDS_${PN} = "${PN}-engines ${PN}-plugins ewl-themes"
