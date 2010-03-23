DESCRIPTION = "Open Source Search Engine Library python bindings"
HOMEPAGE = "http://xapian.org"
SECTION = "devel/libs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "xapian-core xapian-core-native"
PR = "r0"

SRC_URI = "http://www.oligarchy.co.uk/xapian/${PV}/xapian-bindings-${PV}.tar.gz"

S = "${WORKDIR}/xapian-bindings-${PV}"

inherit autotools pkgconfig distutils-base

export XAPIAN_CONFIG = "${STAGING_BINDIR_NATIVE}/xapian-config"

EXTRA_OECONF = "--with-python --without-php --without-ruby --without-tcl \
                --without-csharp --without-java"

do_configure () {
        BUILD_SYS=${BUILD_SYS} HOST_SYS=${MULTIMACH_HOST_SYS} \
        autotools_do_configure
}

# we don't want make to generate pyc and pyo files, but make install
# expects them later
do_compile() {
        oe_runmake PYTHON=true
        touch ${S}/python/xapian.pyc
        touch ${S}/python/xapian.pyo
}

# workaround for bad installation destination and removal of fake .py? files
do_install_append() {
        mv ${D}/${STAGING_DIR_HOST}/usr/* ${D}/usr/
        rm ${D}/${PYTHON_SITEPACKAGES_DIR}/xapian.py?
}

do_stage () {
     autotools_stage_all
}

