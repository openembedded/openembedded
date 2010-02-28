DESCRIPTION = "Commands for Manipulating POSIX Access Control Lists"
LICENSE = "GPLv2"

PR = "r1" 

DEPENDS = "attr"

SRC_URI = "http://mirror.its.uidaho.edu/pub/savannah/acl/acl-${PV}.src.tar.gz"

inherit autotools lib_package

EXTRA_OECONF = " --enable-gettext=yes ac_cv_path_XGETTEXT=${STAGING_BINDIR_NATIVE}/xgettext"

do_configure_append() {
    # gettext hack
    echo "#define _(str) str" >> ${S}/include/config.h
}

do_install() {
    export PKG_BIN_DIR=${D}${bindir}
    export PKG_SBIN_DIR=${D}${sbindir}
    export PKG_LIB_DIR=${D}${libdir}
    export PKG_DEVLIB_DIR=${D}${libexecdir}
    export PKG_INC_DIR=${D}${includedir}
    export PKG_MAN_DIR=${D}${mandir}
    export PKG_DOC_DIR=${D}${datadir}/doc/acl
    export PKG_LOCALE_DIR=${D}${datadir}/locale

    oe_runmake -e install install-dev install-lib

	sed -i -e s:installed=yes:installed=no: -e s:${STAGING_LIBDIR}:${libdir}:g ${D}${libdir}/libacl.la

    # Move .a and .la into libdir and remove symlinks pointing to ${S}
    for file in ${D}${libexecdir}/*a ; do
        rm ${D}${libdir}/$(basename $file)
        mv $file ${D}${libdir}
    done
    rm -rf ${D}${libexecdir}
}


