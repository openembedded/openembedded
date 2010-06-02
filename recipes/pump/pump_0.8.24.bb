DESCRIPTION = "BOOTP and DHCP client for automatic IP configuration"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "popt virtual/libiconv"

PR = "r1"

S = "${WORKDIR}/pump-${PV}"

SRC_URI = "http://ftp.de.debian.org/debian/pool/main/p/pump/pump_0.8.24.orig.tar.gz \
	   file://00_00_all_debian.patch \
	   file://00_all_retvals.patch \
	   file://10_all_gentoo.patch \
	   file://20_all_redefinition.patch \
	   file://30_all_Makefile.patch \
	   file://40_all_manpage.patch \
	  "
do_compile() {
        oe_runmake pump 
}

do_install() {
	install -d ${D}${base_sbindir}
	install -m 0755 ${S}/pump ${D}${base_sbindir}/pump
}

SRC_URI[md5sum] = "866fc9f62b8161eb1514a6a06597edc9"
SRC_URI[sha256sum] = "cbb423942a4295a07a23b76a02d645b76b4ac0b58c3a30076ad42c2ab80c2dba"
