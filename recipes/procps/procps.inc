DESCRIPTION = "Procps is the package that has a bunch \
of small useful utilities that give information \
about processes using the /proc filesystem. The package \
includes the programs ps, top, vmstat, w, kill, and skill."
HOMEPAGE = "http://procps.sf.net"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "ncurses"
RDEPENDS_${PN} = "ncurses-terminfo"

INC_PR = "r14"

SRC_URI = "http://procps.sourceforge.net/procps-${PV}.tar.gz;name=tarball \
	   file://sysctl.conf \
	   file://procps.init \
           file://install.patch"

inherit autotools update-rc.d

INITSCRIPT_NAME = "procps.sh"
INITSCRIPT_PARAMS = "start 30 S ."

FILES_${PN} += "${base_libdir}/libproc-*.so"

CONFFILES_${PN} = "${sysconfdir}/sysctl.conf"

EXTRA_OEMAKE = "CFLAGS=-I${STAGING_INCDIR} \
                CPPFLAGS=-I${STAGING_INCDIR} \
                LDFLAGS="${LDFLAGS}" \
                CURSES=-lncurses \
                install='install -D' \
                ldconfig=echo \
                usr/bin=${D}${bindir}/ \
                usr/proc/bin=${D}${bindir}/ \
                "

do_install_append () {
	install -d ${D}${sysconfdir}/init.d
	install -m 0644 ${WORKDIR}/sysctl.conf ${D}${sysconfdir}/sysctl.conf
	install -m 0755 ${WORKDIR}/procps.init ${D}${sysconfdir}/init.d/procps.sh

	mv ${D}${bindir}/uptime ${D}${bindir}/uptime.${PN}
	mv ${D}${bindir}/top ${D}${bindir}/top.${PN}
	mv ${D}${base_bindir}/kill ${D}${base_bindir}/kill.${PN}
	mv ${D}${base_bindir}/ps ${D}${base_bindir}/ps.${PN}
	mv ${D}${bindir}/free ${D}${bindir}/free.${PN}
	mv ${D}${base_sbindir}/sysctl ${D}${base_sbindir}/sysctl.${PN}
	mv ${D}${bindir}/pkill ${D}${bindir}/pkill.${PN}
	mv ${D}${bindir}/pgrep ${D}${bindir}/pgrep.${PN}
	mv ${D}${bindir}/pmap ${D}${bindir}/pmap.${PN}
}

pkg_postinst() {
	update-alternatives --install ${bindir}/top top top.${PN} 90
	update-alternatives --install ${bindir}/uptime uptime uptime.${PN} 90
	update-alternatives --install ${base_bindir}/ps ps ps.${PN} 90
	update-alternatives --install ${base_bindir}/kill kill kill.${PN} 90
	update-alternatives --install ${bindir}/free free free.${PN} 90
	update-alternatives --install ${base_sbindir}/sysctl sysctl sysctl.${PN} 90
	update-alternatives --install ${bindir}/pkill pkill pkill.${PN} 90
	update-alternatives --install ${bindir}/pgrep pgrep pgrep.${PN} 90
	update-alternatives --install ${bindir}/pmap pmap pmap.${PN} 90
}

pkg_postrm() {
	update-alternatives --remove top top.${PN}
	update-alternatives --remove ps ps.${PN}
	update-alternatives --remove uptime uptime.${PN}
	update-alternatives --remove kill kill.${PN}
	update-alternatives --remove free free.${PN}
	update-alternatives --remove sysctl sysctl.${PN}
	update-alternatives --remove pkill pkill.${PN}
	update-alternatives --remove pgrep pgrep.${PN}
	update-alternatives --remove pmap pmap.${PN}
}
