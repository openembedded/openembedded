require libtool.inc
PR = "${INC_PR}.2"

DEFAULT_PREFERENCE = "-1"

SRC_URI_append = " file://prefix.patch \
                 "
SRC_URI[md5sum] = "b32b04148ecdd7344abc6fe8bd1bb021"
SRC_URI[sha256sum] = "13df57ab63a94e196c5d6e95d64e53262834fe780d5e82c28f177f9f71ddf62e"

DEPENDS += "libtool-native"

do_configure_prepend () {
        # Remove any existing libtool m4 since old stale versions would break
        # any upgrade
        rm -f ${STAGING_DATADIR}/aclocal/libtool.m4
        rm -f ${STAGING_DATADIR}/aclocal/lt*.m4
}

do_install () {
        install -d ${D}${bindir}/
        install -m 0755 ${HOST_SYS}-libtool ${D}${bindir}/${HOST_SYS}-libtool
        install -d ${D}${datadir}/libtool/
        install -d ${D}${datadir}/libtool/config
        install -d ${D}${datadir}/aclocal/
        install -c ${S}/libltdl/config/config.guess ${D}${datadir}/libtool/config/
        install -c ${S}/libltdl/config/config.sub ${D}${datadir}/libtool/config/
        install -c -m 0644 ${S}/libltdl/config/ltmain.sh ${D}${datadir}/libtool/config/
        install -c -m 0644 ${S}/libltdl/m4/libtool.m4 ${D}${datadir}/aclocal/
        install -c -m 0644 ${S}/libltdl/m4/ltdl.m4 ${D}${datadir}/aclocal/
}

SYSROOT_PREPROCESS_FUNCS += "libtoolcross_sysroot_preprocess"

libtoolcross_sysroot_preprocess () {
        install -d ${SYSROOT_DESTDIR}${STAGING_BINDIR_CROSS}/
        install -m 755 ${D}${bindir}/${HOST_SYS}-libtool ${SYSROOT_DESTDIR}${STAGING_BINDIR_CROSS}/${HOST_SYS}-libtool
}
NATIVE_INSTALL_WORKS = "1"
