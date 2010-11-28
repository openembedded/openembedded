DESCRIPTION = "an OpenGL 3D viewer library based on Qt4 - development files\
libqglviewer (also known as libQGLViewer) is a free C++ library based on Qt that enables the quick creation of OpenGL 3D viewers. It features a powerful camera trackball and simple applications simply require an implementation of the draw() function. It is a tool of choice for OpenGL beginners and assignements. It provides screenshot saving, mouse manipulated frames, stereo display, interpolated keyFrames, object selection, and much more. It is fully customizable and easy to extend to create complex applications, with a possible Qt GUI."
HOMEPAGE = "http://www.libqglviewer.com/"
SECTION = "devel/libs" #seems to have more recipes than libs/devel
LICENSE = "GPL" #You may use, distribute and copy the QGLViewer library under the terms of GNU General Public License version 2 or version 3, both of which are included in the LICENSE file.
#DEPENDS = "" #requires qt4-x11-free with QT_CONFIG_FLAGS without -no-opengl

INC_PR = "r0"

SRC_URI = "http://www.libqglviewer.com/src/libQGLViewer-${PV}.tar.gz"

S = "${WORKDIR}/libQGLViewer-${PV}/QGLViewer/"

inherit qt4x11

do_install() {
    oe_runmake install INSTALL_ROOT=${D}
}

FILES_${PN}-dev += " ${libdir}/libQGLViewer.prl"
