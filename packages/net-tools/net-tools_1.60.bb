SUMMARY="Basic networking tools"
LICENSE="GPL"
PR = "r1"

#
# NOTE:
#   This code currently disbles gettext/i18n! This can be fixed by rerunning
#   make config and say NO to gettext. I will leave this excercise for someone
#   else.
#   Change/generate net-tools-1.60-config.{h,make} to enable/disable features
#   and gettext
#
#

SRC_URI = "http://download.berlios.de/${PN}/${PN}-${PV}.tar.bz2;md5sum=888774accab40217dde927e21979c165 \
           file://net-tools-${PV}-config.h \
           file://net-tools-${PV}-config.make \
           file://ether-wake.c \
           file://ether-wake.8 \
           file://mii-diag.c   \
           file://mii-diag.8   \
           file://net-tools-1.57-bug22040.patch;patch=1 \
           file://net-tools-1.60-miiioctl.patch;patch=1 \
           file://net-tools-1.60-manydevs.patch;patch=1;pnum=0 \
           file://net-tools-1.60-virtualname.patch;patch=1 \
           file://net-tools-1.60-cycle.patch;patch=1 \
           file://net-tools-1.60-nameif.patch;patch=1 \
           file://net-tools-1.60-ipx.patch;patch=1 \
           file://net-tools-1.60-inet6-lookup.patch;patch=1 \
           file://net-tools-1.60-man.patch;patch=1 \
           file://net-tools-1.60-gcc33.patch;patch=1 \
           file://net-tools-1.60-trailingblank.patch;patch=1 \
           file://net-tools-1.60-interface.patch;patch=1 \
           file://net-tools-1.60-gcc34.patch;patch=1 \
           file://net-tools-1.60-overflow.patch;patch=1 \
           file://net-tools-1.60-siunits.patch;patch=1 \
           file://net-tools-1.60-trunc.patch;patch=1 \
           file://net-tools-1.60-return.patch;patch=1 \
           file://net-tools-1.60-parse.patch;patch=1 \
           file://net-tools-1.60-netmask.patch;patch=1 \
           file://net-tools-1.60-ulong.patch;patch=1 \
           file://net-tools-1.60-bcast.patch;patch=1 \
           file://net-tools-1.60-mii-tool-obsolete.patch;patch=1 \
           file://net-tools-1.60-netstat_ulong.patch;patch=1 \
           file://net-tools-1.60-note.patch;patch=1 \
           file://net-tools-1.60-num-ports.patch;patch=1 \
           file://net-tools-1.60-duplicate-tcp.patch;patch=1 \
           file://net-tools-1.60-statalias.patch;patch=1 \
           file://net-tools-1.60-isofix.patch;patch=1 \
           file://net-tools-1.60-ifconfig_ib.patch;patch=1 \
           file://net-tools-1.60-de.patch;patch=1 \
           file://net-tools-1.60-pie.patch;patch=1 \
           file://net-tools-1.60-ifaceopt.patch;patch=1 \
           file://net-tools-1.60-trim_iface.patch;patch=1 \
           file://net-tools-1.60-stdo.patch;patch=1 \
           file://net-tools-1.60-statistics.patch;patch=1 \
           file://net-tools-1.60-ifconfig.patch;patch=1 \
           file://net-tools-1.60-arp_overflow.patch;patch=1 \
           file://net-tools-1.60-hostname_man.patch;patch=1 \
           file://net-tools-1.60-interface_stack.patch;patch=1;pnum=0 \
           file://net-tools-1.60-selinux.patch;patch=1 \
           file://net-tools-1.60-netstat_stop_trim.patch;patch=1 "


# Copy config and source over to the source directory
do_configure() {
    cp ${WORKDIR}/net-tools-${PV}-config.h    ${S}/config.h
    cp ${WORKDIR}/net-tools-${PV}-config.make ${S}/config.make
    cp ${WORKDIR}/ether-wake.c ${S}
    cp ${WORKDIR}/ether-wake.8 ${S}/man/en_US
    cp ${WORKDIR}/mii-diag.c   ${S}
    cp ${WORKDIR}/mii-diag.8   ${S}/man/en_US
}

do_compile() {
    export COPTS="$CFLAGS"
    export LOPTS="$LDFLAGS"
    unset CFLAGS
    unset LDFLAGS

    oe_runmake
    $CC $CFLAGS -o ether-wake ether-wake.c
    $CC $CFLAGS -o mii-diag   mii-diag.c
}

do_install() {
    oe_runmake 'BASEDIR=${D}' -n install
    oe_runmake 'BASEDIR=${D}' install
}
