include mesa-mesa.inc

SRC_URI = "${SOURCEFORGE_MIRROR}/mesa3d/MesaLib-${PV}.tar.bz2;name=archive \
        ${SOURCEFORGE_MIRROR}/mesa3d/MesaGLUT-${PV}.tar.bz2;name=glut \
        ${SOURCEFORGE_MIRROR}/mesa3d/MesaDemos-${PV}.tar.bz2;name=demos \
        file://mklib-rpath-link.patch;patch=1 \
        file://fix-host-compile.patch;patch=1 \
        file://fix-progs-makefile.patch;patch=1 \
        "

do_install_append = "install -d ${D}${bindir}; \
                     for f in glxgears glxheads glxdemo glxinfo; do \
                     cp progs/xdemos/${f} ${D}${bindir}; \
                     done"

PACKAGES =+ "libglut libglut-dev mesa-utils"

FILES_libglut = "${libdir}/libglut.so.*"
FILES_libglut-dev = "${libdir}/libglut.* ${includedir}/GL/glut*"
FILES_mesa-utils = "${bindir}/*"

SRC_URI[archive.md5sum] = "93e6ed7924ff069a4f883b4fce5349dc"
SRC_URI[archive.sha256sum] = "9d4707b556960f6aef14480f91fcd4f868720f64321947ab1b2fd20e85ce7f9e"
SRC_URI[glut.md5sum] = "3a33f8efc8c58a592a854cfc7a643286"
SRC_URI[glut.sha256sum] = "fa31ca39f00ff92c7da59d9993d0eefb8d901eb8a519743942e523fde120eb6c"
SRC_URI[demos.md5sum] = "11a10410bae7be85cf25bc7119966468"
SRC_URI[demos.sha256sum] = "ce39b26085acd8e5dffa8233618acac2605cc42203bc4f81c6e4504265f0ffaa"
