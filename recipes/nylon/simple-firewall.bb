DESCRIPTION = "simple firewall configuratiopn script"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Bruno Randolf <br1@einfach.org>"
LICENSE = "GPL"
DEPENDS = "virtual/kernel"
# these kernel modules are needed if the functionality is not hard-built into the kernel:
# kernel-module-ip-tables kernel-module-iptable-filter kernel-module-iptable-nat kernel-module-ipt-state kernel-module-ipt-reject kernel-module-ipt-masquerade 
RDEPENDS = "kernel-module-ipt-limit kernel-module-ipt-tcpmss"
PV = "cvs20051022"

SRC_URI = "http://br1.einfach.org/nylon/stable/sources/simple-firewall_gruen.4g__20051022.tar.gz \
	file://simple-firewall-bash.diff;patch=1"
S = "${WORKDIR}/${PN}"

do_install() {
	(cd ${S}; tar -c --exclude .svn -f - . ) | tar -C ${D} -xpf -
}

SRC_URI[md5sum] = "33e1d83fc7418e7f28b03f5cb7b38605"
SRC_URI[sha256sum] = "c67b2def184fb2506c7370472df1bcd7cd966bc769d5456db9bbea43731a4e67"
