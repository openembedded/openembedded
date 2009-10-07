DESCRIPTION = "HTB.init is a shell script derived from CBQ.init that allows for easy setup of HTB-based traffic control on Linux"
SECTION = "init"
PRIORITY = "optional"
RDEPENDS = "iproute2"

SRC_URI = "${SOURCEFORGE_MIRROR}/htbinit/files/HTB.init/${PV}/htb.init-v${PV};name=tar"
SRC_URI[tar.md5sum] = "1713d9a4941120235cb0721ceba6493b"
SRC_URI[tar.sha256sum] = "acfda369dff72b9073a8b70f2b05b1397a61a1cdb23970e5ed216d632ff33586"

S="${WORKDIR}"

inherit update-rc.d

INITSCRIPT_NAME = "htb"

do_install() {
	install -d ${D}/etc/init.d
	install -d ${D}/etc/sysconfig/htb
	install -m 0755 htb.init-v${PV} ${D}/etc/init.d/htb
	sed -r -i "s,IP=/sbin/ip,IP=/bin/ip," ${D}/etc/init.d/htb
}