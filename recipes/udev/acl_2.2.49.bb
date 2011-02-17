DESCRIPTION = "Commands for Manipulating POSIX Access Control Lists"
LICENSE = "GPLv2"
PR = "r4"
DEPENDS = "attr"

SRC_URI = "http://mirror.its.uidaho.edu/pub/savannah/acl/acl-${PV}.src.tar.gz \
		file://nolargefile.patch"

inherit autotools lib_package

TOPDIR[unexport] = "1"

EXTRA_OECONF = " --enable-gettext=yes \
                --libdir=${base_libdir} --libexecdir=${libdir} \
                ac_cv_path_XGETTEXT=${STAGING_BINDIR_NATIVE}/xgettext \
                ac_cv_path_MSGFMT=${STAGING_BINDIR_NATIVE}/msgfmt \
                ac_cv_path_MSGMERGE=${STAGING_BINDIR_NATIVE}/msgmerge "

do_configure_prepend() {
    ${@base_contains('DISTRO_FEATURES', 'largefile', '', 'sed -i -e "s/-D_FILE_OFFSET_BITS=64//" ${S}/include/builddefs.in', d)}
}

do_configure_append() {
    # Fix RPATH issues.
    sed -i ${S}/config.status -e s,^\\\(hardcode_into_libs=\\\).*$,\\1\'no\',
    ${S}/config.status

    # gettext hack
    echo "#define _(str) str" >> ${S}/include/config.h
}

do_install() {
    oe_runmake DIST_ROOT='${D}' install install-dev install-lib

    # Remove bogus symlinks
    rm -f ${D}${base_libdir}/libacl.la ${D}${base_libdir}/libacl.a

    # libdir should point to .la
    sed -i ${D}${libdir}/libacl.la -e \
        s,^libdir=\'${base_libdir}\'$,libdir=\'${libdir}\',
}

SRC_URI[md5sum] = "181445894cca986da9ae0099d5ce2d08"
SRC_URI[sha256sum] = "b9c7f4752e4ef4930a62fa5aa0d7efe1cba2b5a3a2d6ee2b45c0a70c72b7e5d5"
