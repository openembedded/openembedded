DESCRIPTION = "GNOME Python miscellaneous bindings"
LICENSE = "LGPL"
DEPENDS = "libgnomeui pyorbit python-pygtk"
RDEPENDS = "pyorbit"

inherit gnome distutils-base pkgconfig

SRC_URI[archive.md5sum] = "a17ad952813ed86f520de8e07194a2bf"
SRC_URI[archive.sha256sum] = "759ce9344cbf89cf7f8449d945822a0c9f317a494f56787782a901e4119b96d8"

do_configure_prepend() {
    export HOST_SYS=${HOST_SYS}
    export BUILD_SYS=${BUILD_SYS}
    sed -i \
        -e s:'`$PKG_CONFIG --variable defsdir pygobject-2.0`':\"${STAGING_DATADIR}/pygobject/2.0/defs\":g \
        -e s:'`$PKG_CONFIG --variable=defsdir pygtk-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/defs\":g \
        -e s:'`$PKG_CONFIG --variable=pygtkincludedir pygobject-2.0`':\"${STAGING_INCDIR}/pygtk-2.0\":g \
        -e s:'`$PKG_CONFIG --variable=datadir pygobject-2.0`':\"${STAGING_DATADIR}\":g \
        -e s:'`$PKG_CONFIG --variable codegendir pygobject-2.0`':\"${STAGING_DATADIR}/pygobject/2.0/codegen\":g \
        -e s:'`$PKG_CONFIG --variable=codegendir pygtk-2.0`':\"${STAGING_DATADIR}/pygobject/2.0/codegen\":g \
        -e s:'`$PKG_CONFIG --variable=fixxref pygobject-2.0`':\"${STAGING_DATADIR}/pygobject/xsl/fixxref.py\":g \
        -e 's:PYTHON_CFLAGS="-I$PY_PREFIX/include/python$PYTHON_VERSION":PYTHON_CFLAGS="-I${STAGING_INCDIR}/python$PYTHON_VERSION":g' \
        -e s:'`$PKG_CONFIG --variable=defsdir gnome-python-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/defs\":g \
        -e s:'`$PKG_CONFIG --variable=argtypesdir gnome-python-2.0`':\"${STAGING_DATADIR}/pygtk/2.0/argtypes/\":g \
        ${S}/configure.ac
}

EXTRA_OECONF = " ac_cv_path_PYGOBJECT_CODEGEN=${STAGING_DATADIR}/pygobject/2.0/codegen/codegen.py "

FILES_${PN} += "${datadir}"
FILES_${PN}-dbg += "${libdir}/gnome-vfs-2.0/modules/.debug"


