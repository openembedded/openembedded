DESCRIPTION = "Linknx is an automation platform providing high level functionalities to EIB/KNX installation. \
The rules engine allows execution of actions based on complex logical conditions and timers"
HOMEPAGE = "http://linknx.sourceforge.net/"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r1"

DEPENDS = " pthsem lua5.1 curl libesmtp"
DEPENDS_append_libc-uclibc = " argp-standalone"

SRC_URI += "file://configure-libcurl.patch \
            file://linknx.start "

inherit autotools update-rc.d

EXTRA_OECONF = " --with-pth=yes --without-pth-test --without-mysql --without-log4cpp \
                 --disable-nls --disable-static \
#                 --with-mysql=${STAGING_BINDIR_CROSS} \
                 --enable-smtp --with-lua"

do_install_prepend() {
        install -d ${D}${sysconfdir}/default/
        install -d ${D}${sysconfdir}/init.d/
        install -m 0755 ${WORKDIR}/linknx.start ${D}${sysconfdir}/init.d/linknx
}

INITSCRIPT_NAME = "linknx"
INITSCRIPT_PARAMS = "defaults 22"
