SUMMARY="Basic networking tools"
LICENSE="GPL"
PR = "r3"

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
           file://net-tools-1.57-bug22040.patch \
           file://net-tools-1.60-miiioctl.patch \
           file://net-tools-1.60-manydevs.patch;striplevel=0 \
           file://net-tools-1.60-virtualname.patch \
           file://net-tools-1.60-cycle.patch \
           file://net-tools-1.60-nameif.patch \
           file://net-tools-1.60-ipx.patch \
           file://net-tools-1.60-inet6-lookup.patch \
           file://net-tools-1.60-man.patch \
           file://net-tools-1.60-gcc33.patch \
           file://net-tools-1.60-trailingblank.patch \
           file://net-tools-1.60-interface.patch \
           file://net-tools-1.60-gcc34.patch \
           file://net-tools-1.60-overflow.patch \
           file://net-tools-1.60-siunits.patch \
           file://net-tools-1.60-trunc.patch \
           file://net-tools-1.60-return.patch \
           file://net-tools-1.60-parse.patch \
           file://net-tools-1.60-netmask.patch \
           file://net-tools-1.60-ulong.patch \
           file://net-tools-1.60-bcast.patch \
           file://net-tools-1.60-mii-tool-obsolete.patch \
           file://net-tools-1.60-netstat_ulong.patch \
           file://net-tools-1.60-note.patch \
           file://net-tools-1.60-num-ports.patch \
           file://net-tools-1.60-duplicate-tcp.patch \
           file://net-tools-1.60-statalias.patch \
           file://net-tools-1.60-isofix.patch \
           file://net-tools-1.60-ifconfig_ib.patch \
           file://net-tools-1.60-de.patch \
           file://net-tools-1.60-pie.patch \
           file://net-tools-1.60-ifaceopt.patch \
           file://net-tools-1.60-trim_iface.patch \
           file://net-tools-1.60-stdo.patch \
           file://net-tools-1.60-statistics.patch \
           file://net-tools-1.60-ifconfig.patch \
           file://net-tools-1.60-arp_overflow.patch \
           file://net-tools-1.60-hostname_man.patch \
           file://net-tools-1.60-interface_stack.patch;striplevel=0 \
           file://net-tools-1.60-selinux.patch \
           file://net-tools-1.60-netstat_stop_trim.patch "

TOPDIR[unexport] = "1"

# The Makefile is lame, no parallel build
PARALLEL_MAKE = ""

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
    ${CC} ${CFLAGS} ${LDFLAGS} -o ether-wake ether-wake.c
    ${CC} ${CFLAGS} ${LDFLAGS} -o mii-diag   mii-diag.c
}

do_install() {
    oe_runmake 'BASEDIR=${D}' -n install
    oe_runmake 'BASEDIR=${D}' install

	for app in ${D}/${base_sbindir}/* ${D}/${base_bindir}/*; do
		mv $app $app.net-tools 
	done
}

pkg_postinst_${PN} () {
#!/bin/sh
for app in arp ifconfig ipmaddr iptunnel mii-tool nameif plipconfig rarp route slattach ; do
    update-alternatives --install ${base_sbindir}/$app $app $app.${PN} 100
done

for app in dnsdomainname domainname hostname netstat nisdomainname ypdomainname ; do
    update-alternatives --install ${base_bindir}/$app $app $app.${PN} 100
done
}

pkg_prerm_${PN} () {
 #!/bin/sh

for app in arp ifconfig ipmaddr iptunnel mii-tool nameif plipconfig rarp route slattach dnsdomainname domainname hostname netstat nisdomainname ypdomainname ; do
   update-alternatives --remove $app $app.${PN}
done
}

SRC_URI[md5sum] = "888774accab40217dde927e21979c165"
SRC_URI[sha256sum] = "7ae4dd6d44d6715f18e10559ffd270511b6e55a8900ca54fbebafe0ae6cf7d7b"
