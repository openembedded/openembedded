DESCRIPTION = "The OpenSceneGraph is an open source high performance 3D graphics toolkit"
LICENSE = "OSGPL"

DEPENDS = "libxml2 gtk+ ffmpeg poppler libxrandr"

PR = "r2"

inherit cmake

SRC_URI = "http://www.openscenegraph.org/downloads/developer_releases/OpenSceneGraph-2.9.6.zip;name=osg \
           file://gles.diff "

SRC_URI[osg.md5sum] = "f27a69499f3eadf1d8ad2ee22f6d5e85"
SRC_URI[osg.sha256sum] = "9aa8ce2a581d42f8c9bac14dff5069c66633ddf73370a1e7412873048d643e9a"

S = "${WORKDIR}/OpenSceneGraph-${PV}"

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
                "

TARGET_CC_ARCH += "-D__STDC_CONSTANT_MACROS"

FILES_${PN} = " ${bindir}/* ${libdir}/osgPlugins-${PV}/*.so "
FILES_${PN}-dbg += "${libdir}/osgPlugins-${PV}/.debug"

python populate_packages_prepend () {
	glibdir = bb.data.expand('${libdir}', d)

	do_split_packages(d, glibdir, '^lib(.*)\.so\.*', 'lib%s', 'OpenSceneGraph %s library', extra_depends='', allow_links=True)
}

ALLOW_EMPTY = "1"




