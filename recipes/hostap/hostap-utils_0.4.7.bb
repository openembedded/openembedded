DESCRIPTION = "User mode helpers for the hostap driver"
HOMEPAGE = "http://hostap.epitest.fi"
SECTION = "kernel/userland"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r6"

SRC_URI = "http://hostap.epitest.fi/releases/hostap-utils-${PV}.tar.gz \
	   file://hostap-fw-load.patch;patch=1 \
	   file://ldflags.patch;patch=1"

S = "${WORKDIR}/hostap-utils-${PV}"

BINARIES = "hostap_crypt_conf hostap_diag hostap_fw_load hostap_io_debug \
	    hostap_rid prism2_param prism2_srec split_combined_hex"

do_install() {
	install -d ${D}${sbindir}/
	for f in ${BINARIES}
	do
		install -m 0755 $f ${D}${sbindir}/
	done
}

SRC_URI[md5sum] = "afe041581b8f01666e353bec20917c85"
SRC_URI[sha256sum] = "c6f598d8e356c1620fa009eca0a700bf1105e16817eefd77d891994261009355"
