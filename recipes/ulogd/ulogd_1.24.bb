DESCRIPTION = "Userspace logging daemon for netfilter/iptables related logging"
LICENSE = "GPL"
DEPENDS = "libpcap"

SRC_URI = " \
	http://www.netfilter.org/projects/ulogd/files/ulogd-${PV}.tar.bz2;name=tar \
	file://ulogd-kill-uname-in-rules.patch;patch=1 \
	file://ulogd-hash-style-gnu.patch;patch=1 \
	file://init \
	"
SRC_URI[tar.md5sum] = "05b4ed2926b9a22aaeaf642917bbf8ff"
SRC_URI[tar.sha256sum] = "63a6069d9b537d8a6d6a4d99beeb4ccc0a853717414da3a6e0ce230a34d0e057"

PARALLEL_MAKE = ""

inherit autotools update-rc.d

INITSCRIPT_NAME = "ulogd"

do_install_append() {
	install -d ${D}/${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}/${sysconfdir}/init.d/ulogd
}