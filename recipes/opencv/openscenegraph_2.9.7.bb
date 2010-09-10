DESCRIPTION = "The OpenSceneGraph is an open source high performance 3D graphics toolkit"
LICENSE = "OSGPL"

DEPENDS = "libxml2 gtk+ ffmpeg poppler libxrandr"

PR = "r2"

inherit cmake

SRC_URI = "http://www.openscenegraph.org/downloads/developer_releases/OpenSceneGraph-${PV}.zip;name=osg \
           file://gles.diff "

SRC_URI[osg.md5sum] = "b5118ed07ec2945e23ad5e880f3f0f6d"
SRC_URI[osg.sha256sum] = "ae0436a854b97a9efb7fe2c8a38630dab5182b1ea23b984ea0ea17fc789a5dd2"

S = "${WORKDIR}/OpenSceneGraph-${PV}"

# choose between
# _OPENTHREADS_ATOMIC_USE_GCC_BUILTINS
# _OPENTHREADS_ATOMIC_USE_MUTEX

# From http://www.openscenegraph.org/projects/osg/wiki/Community/OpenGL-ES
EXTRA_OECMAKE = " -DCMAKE_BUILD_TYPE=Release \
                  -DOSG_GLU_AVAILABLE=OFF \
                  -DOSG_GL1_AVAILABLE=OFF \
                  -DOSG_GL2_AVAILABLE=OFF \
                  -DOSG_GL3_AVAILABLE=OFF \
                  -DOSG_GLES1_AVAILABLE=OFF \
                  -DOSG_GLES2_AVAILABLE=ON \
                  -DOPENGL_egl_LIBRARY='-lEGL -lGLESv2 -lGLES_CM -lIMGegl -lsrv_um' \
                  -DOPENGL_LIBRARY='-lGLESv2 -lGLES_CM -lIMGegl -lsrv_um' \
                  -DOSG_GL_DISPLAYLISTS_AVAILABLE=OFF \
                  -DOSG_GL_MATRICES_AVAILABLE=OFF \
                  -DOSG_GL_VERTEX_FUNCS_AVAILABLE=OFF \
                  -DOSG_GL_VERTEX_ARRAY_FUNCS_AVAILABLE=OFF \
                  -DOSG_GL_FIXED_FUNCTION_AVAILABLE=OFF \
                  -DOSG_CPP_EXCEPTIONS_AVAILABLE=OFF \
                  -DPOPPLER_HAS_CAIRO_EXITCODE=0 \
                  -D_OPENTHREADS_ATOMIC_USE_GCC_BUILTINS=1 \
                "

TARGET_CC_ARCH += "-D__STDC_CONSTANT_MACROS"

FILES_${PN} = " ${bindir}/* ${libdir}/osgPlugins-${PV}/*.so "
FILES_${PN}-dbg += "${libdir}/osgPlugins-${PV}/.debug"

python populate_packages_prepend () {
	glibdir = bb.data.expand('${libdir}', d)

	do_split_packages(d, glibdir, '^lib(.*)\.so\.*', 'lib%s', 'OpenSceneGraph %s library', extra_depends='', allow_links=True)
}

ALLOW_EMPTY = "1"




