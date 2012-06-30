DESCRIPTION = "Commands for Manipulating POSIX Access Control Lists"
LICENSE = "GPLv2"
PR = "r5"
DEPENDS = "attr"

SRC_URI = "http://download.savannah.gnu.org/releases/acl/acl-${PV}.src.tar.gz \
		file://nolargefile.patch"

inherit autotools lib_package

TOPDIR[unexport] = "1"

EXTRA_OECONF = " --enable-gettext=yes \
                ac_cv_path_XGETTEXT=${STAGING_BINDIR_NATIVE}/xgettext \
                ac_cv_path_MSGFMT=${STAGING_BINDIR_NATIVE}/msgfmt \
                ac_cv_path_MSGMERGE=${STAGING_BINDIR_NATIVE}/msgmerge "

do_configure_append() {
    # Fix RPATH issues.
    sed -i ${S}/config.status -e s,^\\\(hardcode_into_libs=\\\).*$,\\1\'no\',
    ${S}/config.status

    # gettext hack
    echo "#define _(str) str" >> ${S}/include/config.h
}

do_configure_prepend() {
    ${@base_contains('DISTRO_FEATURES', 'largefile', '', 'sed -i -e "s/-D_FILE_OFFSET_BITS=64//" ${S}/include/builddefs.in', d)}
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
    # ensure the subdir Makefile do not use the (wrong) variable overrides from the include file
    export MAKE="${MAKE} -e"

    oe_runmake -e install install-dev install-lib

	sed -i -e s:installed=yes:installed=no: -e s:${STAGING_LIBDIR}:${libdir}:g ${D}${libdir}/libacl.la

    # Move .a and .la into libdir and remove symlinks pointing to ${S}
    for file in ${D}${libexecdir}/*a ; do
        rm ${D}${libdir}/$(basename $file)
        mv $file ${D}${libdir}
    done
    rm -rf ${D}${libexecdir}
}



SRC_URI[md5sum] = "181445894cca986da9ae0099d5ce2d08"
SRC_URI[sha256sum] = "b9c7f4752e4ef4930a62fa5aa0d7efe1cba2b5a3a2d6ee2b45c0a70c72b7e5d5"
