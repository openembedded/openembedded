# recipe to build GLES gfxdriver

FILESPATHPKG =. "qt4-x11-free-${PV}:qt4-x11-free:"

QT_GLFLAGS = "-opengl es1" 

require qt4-x11-free_${PV}.bb

DEPENDS += "virtual/egl"
SRC_URI += "file://sgx-hack.patch;patch=1"

export EXTRA_QMAKE_MUNGE = " glmunge "

glmunge() {
sed -e /QMAKE_INCDIR_OPENGL/d -e /QMAKE_LIBDIR_OPENGL/d -e /QMAKE_LIBS_OPENGL/d -e /QMAKE_LIBS_OPENGL_QT/d -i mkspecs/${OE_QMAKE_PLATFORM}/qmake.conf
echo "QMAKE_INCDIR_OPENGL = ${STAGING_INCDIR}/GLES/" >> mkspecs/${OE_QMAKE_PLATFORM}/qmake.conf
echo "QMAKE_LIBDIR_OPENGL  = ${STAGING_LIBDIR}" >> mkspecs/${OE_QMAKE_PLATFORM}/qmake.conf
echo "QMAKE_LIBS_OPENGL = -lEGL -lGLES_CM -lIMGegl -lsrv_um" >> mkspecs/${OE_QMAKE_PLATFORM}/qmake.conf
echo "QMAKE_LIBS_OPENGL_QT = -lEGL -lGLES_CM -lIMGegl -lsrv_um" >> mkspecs/${OE_QMAKE_PLATFORM}/qmake.conf
}



