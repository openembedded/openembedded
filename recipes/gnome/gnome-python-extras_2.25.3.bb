LICENSE = "GPL/LGPL"
DEPENDS = "python-pygtk libwnck"

PR = "r1"

inherit distutils-base gnome

SRC_URI += "file://acinclude.m4"

EXTRA_OECONF = "--with-python-includes=${STAGING_INCDIR}/../ ac_cv_path_PYGTK_CODEGEN=${STAGING_DATADIR}/pygobject/2.0/codegen/codegen.py"

do_configure_prepend() {
        install -m 0644 ${WORKDIR}/acinclude.m4 ${S}/
}

do_configure_prepend() {
    export HOST_SYS=${HOST_SYS}
    export BUILD_SYS=${BUILD_SYS}
	export PYGTK_CODEGEN="${STAGING_DATADIR}/pygobject/2.0/codegen/codegen.py"
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

AUTOTOOLS_STAGE_PKGCONFIG = "1"
do_stage() {
	autotools_stage_all
}	

FILES_${PN}-dev += "${datadir}/pygtk"
