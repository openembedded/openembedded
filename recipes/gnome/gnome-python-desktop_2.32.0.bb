LICENSE = "GPL/LGPL"
DEPENDS = "python-pycairo evince librsvg libwnck totem-pl-parser libgtop gnome-panel gnome-desktop eds-dbus python-pygtk gnome-python libgnomeprint libgnomeprintui"

inherit gnome distutils-base

EXTRA_OECONF += " ac_cv_path_PYGOBJECT_CODEGEN=${STAGING_DATADIR}/pygobject/2.0/codegen/codegen.py \
                  ac_cv_path_PYGTK_CODEGEN=${STAGING_DATADIR}/pygobject/2.0/codegen/codegen.py \
                  --with-python-includes=${STAGING_INCDIR}/../"

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

FILES_${PN}-dev += "${datadir}/pygtk"

SRC_URI[archive.md5sum] = "0e73fa80ace5c861777e0b523c6ead9d"
SRC_URI[archive.sha256sum] = "09dbd580bf3b0ef60f91b090eafe6d08ddcc50a609e2b425a7f8eca46d4e0ee9"

