SECTION = "x11"

DESCRIPTION = "An open source implementation of the OpenGL spec"
HOMEPAGE = "http://mesa3d.org"
LICENSE = "MIT"

SRC_URI = "${SOURCEFORGE_MIRROR}/mesa3d/MesaLib-${PV}.tar.bz2 \
           ${SOURCEFORGE_MIRROR}/mesa3d/MesaDemos-${PV}.tar.bz2 "
S = "${WORKDIR}/Mesa-${PV}"

PROVIDES = "virtual/libgl"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-glu \
                --disable-glw \
                --disable-glut \
                --enable-glx-tls"

PACKAGES =+ "libglu libglu-dev libosmesa libosmesa-dev libgl libgl-dev"
FILES_libgl = "${libdir}/libGL.so.*"
FILES_libglu = "${libdir}/libGLU.so.*"
FILES_libosmesa = "${libdir}/libOSMesa.so.*"

FILES_libgl-dev = "${libdir}/libGL.* ${includedir}/GL"
FILES_libglu-dev = "${libdir}/libGLU.* ${includedir}/GL/glu*.h"
FILES_libosmesa-dev = "${libdir}/libOSMesa.* ${includedir}/osmesa.h"


do_stage() {
        autotools_stage_all
		install -d ${STAGING_INCDIR}/GL/	
		cp -pPr ${S}/include/GL/internal* ${STAGING_INCDIR}/GL/
}


