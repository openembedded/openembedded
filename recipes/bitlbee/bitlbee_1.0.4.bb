DESCRIPTION = "Bitlbee is an IRC to IM gateway that support multiple IM protocols."
HOMEPAGE = "http://www.bitlbee.org/"
SECTION = "console/network"
LICENSE = "GPLv2"
DEPENDS = "glib-2.0 gnutls"
PR = "r0"

SRC_URI = "http://get.bitlbee.org/src/${P}.tar.gz \
           file://configure.patch;patch=1 \
           file://init-script"

S = "${WORKDIR}/bitlbee-${PV}"

EXTRA_OECONF = "--prefix=/usr \
                --datadir=/usr/share/bitlbee \
                --etcdir=/etc/bitlbee \
                --oscar=0 \
                --cpu=${TARGET_ARCH}"

do_configure () {
    # NOTE: bitlbee's configure script is not an autotool creation, 
    # so we do not use the default autotools_do_configure.
    ./configure ${EXTRA_OECONF} || die "./configure failed"
}

do_compile () {
    make CC="${CC}" LD="${LD}" || die "make failed"
    
    # make bitlbeed forking server
    cd ${S}/utils
    ${CC} bitlbeed.c -o bitlbeed || die "bitlbeed failed to compile"
}

do_install () {
    # install bitlbee
    install -d ${D}${localstatedir}/lib/bitlbee
    make install DESTDIR=${D} || die "install failed"
    make install-etc DESTDIR=${D} || die "install failed"

    # copy bitlbee forking server
    install ${S}/utils/bitlbeed ${D}${sbindir}/bitlbeed

    # copy init script
    install -d ${D}${sysconfdir}/init.d
    install ${WORKDIR}/init-script ${D}${sysconfdir}/init.d/bitlbee
    sed -i -e "s:BITLBEED_EXEC:${sbindir}/bitlbeed:" ${D}${sysconfdir}/init.d/bitlbee
    sed -i -e "s:BITLBEED_OPTS::" ${D}${sysconfdir}/init.d/bitlbee

    # copy bitlbee utils
    install -d ${D}${datadir}/bitlbee
    cp ${S}/utils/* ${D}${datadir}/bitlbee/
    rm ${D}${datadir}/bitlbee/bitlbeed*
}

pkg_postinst () {
    chown nobody:nogroup ${localstatedir}/lib/bitlbee
    chmod 700 ${localstatedir}/lib/bitlbee
}

