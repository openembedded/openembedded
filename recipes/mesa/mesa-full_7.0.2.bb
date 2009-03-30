include mesa-mesa.inc

SRC_URI = "${SOURCEFORGE_MIRROR}/mesa3d/MesaLib-${PV}.tar.bz2 \
        ${SOURCEFORGE_MIRROR}/mesa3d/MesaGLUT-${PV}.tar.bz2 \
        ${SOURCEFORGE_MIRROR}/mesa3d/MesaDemos-${PV}.tar.bz2 \
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
