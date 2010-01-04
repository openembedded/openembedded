# recipe to build GLES gfxdriver

FILESPATHPKG =. "qt4-x11-free-${PV}:qt4-x11-free:"

QT_GLFLAGS = "-opengl es2" 

QT_BASE_NAME = "qt4-gles"
QT_BASE_LIB  = "libqt-gles"

require qt4-x11-free_${PV}.bb
PR = "${INC_PR}.3"

DEPENDS += "virtual/egl"
PROVIDES += "qt4-x11-free"
#SRC_URI += "file://sgx-hack.patch;patch=1"
SRC_URI += "file://hack-out-pg_config.patch;patch=1"

export EXTRA_QMAKE_MUNGE = " glmunge "

glmunge() {
sed -e /QMAKE_INCDIR_OPENGL/d -e /QMAKE_LIBDIR_OPENGL/d -e /QMAKE_LIBS_OPENGL/d -e /QMAKE_LIBS_OPENGL_QT/d -i mkspecs/${OE_QMAKE_PLATFORM}/qmake.conf
echo "QMAKE_INCDIR_OPENGL = ${STAGING_INCDIR}/GLES/" >> mkspecs/${OE_QMAKE_PLATFORM}/qmake.conf
echo "QMAKE_LIBDIR_OPENGL  = ${STAGING_LIBDIR}" >> mkspecs/${OE_QMAKE_PLATFORM}/qmake.conf
echo "QMAKE_LIBS_OPENGL = -lEGL -lGLES_CM -lGLESv2 -lIMGegl -lsrv_um" >> mkspecs/${OE_QMAKE_PLATFORM}/qmake.conf
echo "QMAKE_LIBS_OPENGL_QT = -lEGL -lGLES_CM -lGLESv2 -lIMGegl -lsrv_um" >> mkspecs/${OE_QMAKE_PLATFORM}/qmake.conf
}



