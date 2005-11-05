BROKEN = "1" 
# Debian moved to 0.6.7

DESCRIPTION = "High level tools to configure network interfaces \
This package provides the tools ifup and ifdown which may be used to \
configure (or, respectively, deconfigure) network interfaces, based on \
the file /etc/network/interfaces."
LICENSE = "GPL"

SECTION = "base"

SRC_URI = "${DEBIAN_MIRROR}/main/i/ifupdown/ifupdown_${PV}.orig.tar.gz \
           ${DEBIAN_MIRROR}/main/i/ifupdown/ifupdown_${PV}-4.8.diff.gz;patch=1 \
           file://busybox.patch;patch=1 \
           file://udhcpc.patch;patch=1 \
           file://zeroconf.patch;patch=1 \
           file://gcc34-fix.patch;patch=1 \
           file://init \
           file://interfaces"

EXTRA_OEMAKE = ""

do_compile () {
	chmod a+rx *.pl *.sh
	oe_runmake 'CC=${CC}' "CFLAGS=${CFLAGS} -Wall -W -D'IFUPDOWN_VERSION=\"${PV}\"'"
}

do_install () {
	install -d ${D}${sysconfdir}/init.d \
		   ${D}${sysconfdir}/network \
		   ${D}${base_sbindir}
	install -m 0755 ifup ${D}${base_sbindir}/
	ln ${D}${base_sbindir}/ifup ${D}${base_sbindir}/ifdown
	install -m 0644 ${WORKDIR}/init ${D}${sysconfdir}/init.d/networking
	install -m 0644 ${WORKDIR}/interfaces ${D}${sysconfdir}/network/interfaces
}
