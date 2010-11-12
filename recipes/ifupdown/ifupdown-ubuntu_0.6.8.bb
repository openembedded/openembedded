DESCRIPTION = "High level tools to configure network interfaces \
This package provides the tools ifup and ifdown which may be used to \
configure (or, respectively, deconfigure) network interfaces, based on \
the file /etc/network/interfaces."
LICENSE = "GPL"

SECTION = "base"

PROVIDES = "ifupdown"

PR = "r3"

inherit update-rc.d

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/main/i/ifupdown/ifupdown_0.6.8ubuntu19.tar.gz;name=ifupdown \
	file://init"

SRC_URI[ifupdown.md5sum] = "9c4533a289bd55316a9981b1fe41fad4"
SRC_URI[ifupdown.sha256sum] = "4c86cc0534061896c1f825766a29fe5282607123b8978b623f5c6f1fa5458b4d"

EXTRA_OEMAKE = ""

S = "${WORKDIR}/ifupdown-${PV}ubuntu15"

do_compile () {
	chmod a+rx *.pl *.sh
	oe_runmake 'CC=${CC}' "CFLAGS=${CFLAGS} -Wall -W -D'IFUPDOWN_VERSION=\"${PV}\"'"
}

do_install () {
	install -d ${D}${sysconfdir}/init.d \
		   ${D}${sysconfdir}/network \
		   ${D}${mandir}/man8 \
		   ${D}${mandir}/man5 \
		   ${D}${base_sbindir}
	install -m 0755 ifup ${D}${base_sbindir}/
	ln ${D}${base_sbindir}/ifup ${D}${base_sbindir}/ifdown
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/ifup
	install -m 0644 ifup.8 ${D}${mandir}/man8
	install -m 0644 interfaces.5 ${D}${mandir}/man5
	cd ${D}${mandir}/man8 && ln -s ifup.8 ifdown.8
	mv ${D}${base_sbindir}/ifup ${D}${base_sbindir}/ifup.${PN}
	mv ${D}${base_sbindir}/ifdown ${D}${base_sbindir}/ifdown.${PN}
}

pkg_postinst_${PN} () {
	update-alternatives --install ${base_sbindir}/ifup ifup ifup.${PN} 100
	update-alternatives --install ${base_sbindir}/ifdown ifdown ifdown.${PN} 100
}

pkg_prerm_${PN} () {
	update-alternatives --remove ifup ifup.${PN}
	update-alternatives --remove ifdown ifdown.${PN}
}

INITSCRIPT_NAME = "ifup"
INITSCRIPT_PARAMS = "start 39 S . stop 39 0 6 1 ."
