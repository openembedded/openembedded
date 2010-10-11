require libtool_${PV}.bb

SRC_URI_append = " file://prefix.patch \
                   file://cross.patch \
                 "
inherit sdk

do_configure_prepend () {
        # Remove any existing libtool m4 since old stale versions would break
        # any upgrade
        rm -f ${STAGING_DATADIR}/aclocal/libtool.m4
        rm -f ${STAGING_DATADIR}/aclocal/lt*.m4
}

do_install () {
        autotools_do_install
        install -d ${D}${bindir}/
        install -m 0755 ${HOST_SYS}-libtool ${D}${bindir}/
}

NATIVE_INSTALL_WORKS = "1"
