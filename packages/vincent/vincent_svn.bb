DESCRIPTION = "Vincent OpenGL-ES library "
HOMEPAGE = "http://sourceforge.net/projects/ogl-es/"
LICENSE = "BSD"

PV = "0.0+svn${SRCDATE}"
PR = "r0"

SRC_URI = "svn://ogl-es.svn.sourceforge.net/svnroot/ogl-es/branches;module=linux_nokia_770;proto=https"

S = "${WORKDIR}/linux_nokia_770/ogles/projects/linux-x11"

TOP = "${WORKDIR}/linux_nokia_770/ogles/"

inherit autotools pkgconfig

# PACKAGES = ${PN}

do_stage() {
        install -d ${STAGING_INCDIR}/GLES

        install -m 0644 ${TOP}/include/ug.h ${STAGING_INCDIR}
        install -m 0644 ${TOP}/include/GLES/* ${STAGING_INCDIR}/GLES/

        oe_libinstall -so libvincent ${STAGING_LIBDIR}
}
