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
