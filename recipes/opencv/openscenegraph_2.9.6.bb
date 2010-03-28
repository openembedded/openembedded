DESCRIPTION = "The OpenSceneGraph is an open source high performance 3D graphics toolkit"
LICENSE = "OSGPL"

DEPENDS = "gtk+ ffmpeg poppler libxrandr"

inherit cmake

SRC_URI = "http://www.openscenegraph.org/downloads/developer_releases/OpenSceneGraph-2.9.6.zip;name=osg \
           file://gles.diff;patch=1 "

SRC_URI[osg.md5sum] = "f27a69499f3eadf1d8ad2ee22f6d5e85"
SRC_URI[osg.sha256sum] = "9aa8ce2a581d42f8c9bac14dff5069c66633ddf73370a1e7412873048d643e9a"

S = "${WORKDIR}/OpenSceneGraph-${PV}"

EXTRA_OECMAKE = " -DCMAKE_BUILD_TYPE=Release "

FILES_${PN} = " ${bindir}/* ${libdir}/osgPlugins-${PV}/*.so "
FILES_${PN}-dbg += "${libdir}/osgPlugins-${PV}/.debug"

python populate_packages_prepend () {
	glibdir = bb.data.expand('${libdir}', d)

	do_split_packages(d, glibdir, '^lib(.*)\.so\.*', 'lib%s', 'OpenSceneGraph %s library', extra_depends='', allow_links=True)
}

ALLOW_EMPTY = "1"




