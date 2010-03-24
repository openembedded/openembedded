DESCRIPTION = "HTB.init is a shell script that allows for easy setup of HTB-based traffic control on Linux."
HOMEPAGE = "http://sourceforge.net/projects/htbinit"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/htbinit/htb.init-v${PV} \
	file://htb.init+ingress+predef+verbose.diff;patch=1;pnum=0 \
	file://htb-basic-verbose.diff;patch=1;pnum=0"
RRECOMMENDS = "kernel-module-sch-ingress kernel-module-cls-route kernel-module-cls-u32 kernel-module-cls-fw kernel-module-sch-sfq kernel-module-sch-htb"
RDEPENDS = "iproute2"

S="${WORKDIR}"

inherit update-rc.d
INITSCRIPT_NAME = "htb"

do_install() {
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/htb
	install -m 755 ${S}/htb.init-v${PV} ${D}${sysconfdir}/init.d/htb
	sed -r -i "s,IP=/sbin/ip,IP=${base_bindir}/ip," ${D}${sysconfdir}/init.d/htb
}

PACKAGE_ARCH = "all"
