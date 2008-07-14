DESCRIPTION = "Hardware drivers for Dreambox"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

KV_dm7020 = "2.6.9"
PV_dm7020 = "${KV}-20060622"

def get_modules_extension(bb, d):
	if bb.data.getVar('GLIBC_ADDONS', d, 1) in ['nptl']:
		return "-gcc4.1"
	return ""

KV_dm7025 = "2.6.12.6"
PV_dm7025 = "${KV}-20080430${@get_modules_extension(bb, d)}"

KV_dm600pvr = "2.6.12"
PV_dm600pvr = "${KV}-20071026"

KV_dm500plus = "2.6.12"
PV_dm500plus = "${KV}-20071026"

KV_dm800 = "2.6.12-5.1-brcmstb-dm800"
PV_dm800 = "${KV}-20080521"

KV_dm8000 = "2.6.12-5.1-brcmstb-dm8000"
PV_dm8000 = "${KV}-20080712"

RDEPENDS = "kernel (${KV})"
PR = "r0"

SRC_URI = "http://sources.dreamboxupdate.com/snapshots/dreambox-dvb-modules-${MACHINE}-${PV}.tar.bz2 "
SRC_URI_append_dm7025 = "http://sources.dreamboxupdate.com/download/7020/fpupgrade-${MACHINE}-v7"

S = "${WORKDIR}"

do_install_dm600pvr() {
	install -d ${D}/lib/modules/${KV}/extra
	for f in head; do
		install -m 0644 $f.ko ${D}/lib/modules/${KV}/extra/$f.ko;
	done
}

do_install_dm7020() {
	install -d ${D}/lib/modules/${KV}/extra
	for f in head; do
		install -m 0644 $f.ko ${D}/lib/modules/${KV}/extra/$f.ko;
	done
}

do_install_dm500plus() {
	install -d ${D}/lib/modules/${KV}/extra
	for f in head; do
		install -m 0644 $f.ko ${D}/lib/modules/${KV}/extra/$f.ko;
	done
}

do_install_dm7025() {
	install -d ${D}/lib/modules/${KV}/extra
	for f in *.ko LICENSE; do
		install -m 0644 ${WORKDIR}/$f ${D}/lib/modules/${KV}/extra/$f;
	done
	install -d ${D}${sbindir}
	install -m 0755 ${WORKDIR}/fpupgrade-${MACHINE}-v7 ${D}${sbindir}/fpupgrade
}

do_install_dm8000() {
	install -d ${D}/lib/modules/${KV}/extra
	for f in *.ko LICENSE; do
		install -m 0644 ${WORKDIR}/$f ${D}/lib/modules/${KV}/extra/$f;
	done
	install -d ${D}${sbindir}
}

do_install_dm800() {
	install -d ${D}/lib/modules/${KV}/extra
	for f in *.ko LICENSE; do
		install -m 0644 ${WORKDIR}/$f ${D}/lib/modules/${KV}/extra/$f;
	done
	install -d ${D}${sbindir}
}

do_install_dm8000() {
	install -d ${D}/lib/modules/${KV}/extra
	for f in *.ko LICENSE; do
		install -m 0644 ${WORKDIR}/$f ${D}/lib/modules/${KV}/extra/$f;
	done
	install -d ${D}${sbindir}
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/"
