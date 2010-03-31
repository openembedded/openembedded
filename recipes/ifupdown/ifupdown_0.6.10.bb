DESCRIPTION = "High level tools to configure network interfaces \
This package provides the tools ifup and ifdown which may be used to \
configure (or, respectively, deconfigure) network interfaces, based on \
the file /etc/network/interfaces."
LICENSE = "GPL"
SECTION = "base"
PR = "r2"


SRC_URI = "${DEBIAN_MIRROR}/main/i/ifupdown/ifupdown_${PV}.tar.gz;name=ifupdown \
           file://busybox.patch;patch=1 \
           file://zeroconf.patch;patch=1 \
           file://init "

EXTRA_OEMAKE = ""

inherit update-rc.d

do_compile () {
	chmod a+rx *.pl *.sh
	oe_runmake 'CC=${CC}' "CFLAGS=${CFLAGS} -Wall -W -D'IFUPDOWN_VERSION=\"${PV}\"'"
}

do_install () {
	install -d ${D}${sysconfdir}/init.d \
		   ${D}${sysconfdir}/network/run/ \
		   ${D}${mandir}/man8 \
		   ${D}${mandir}/man5 \
		   ${D}${base_sbindir}
	install -m 0755 ifup ${D}${base_sbindir}/
	ln ${D}${base_sbindir}/ifup ${D}${base_sbindir}/ifdown
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/ifup
	install -m 0644 ifup.8 ${D}${mandir}/man8
	install -m 0644 interfaces.5 ${D}${mandir}/man5
	cd ${D}${mandir}/man8 && ln -s ifup.8 ifdown.8
}

INITSCRIPT_NAME = "ifup"
INITSCRIPT_PARAMS = "start 39 S . stop 39 0 6 1 ."

SRC_URI[ifupdown.md5sum] = "70db0d8caf06a17d65b612fa8919732b"
SRC_URI[ifupdown.sha256sum] = "d4ada5d3f1b1f7c93cb608bfb505605b4765e0d4791ce6a1c435fe924dd67101"
