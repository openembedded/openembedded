DESCRIPTION = "opkg configuration files"
SECTION = "base"
LICENSE = "MIT"
PR = "r3"

SRC_URI = "file://opkg.conf.comments \
	   file://lists \
	   file://dest \
	   file://tmp_dir \
	   file://src "

do_compile () {
	cat ${WORKDIR}/opkg.conf.comments >${WORKDIR}/opkg.conf
	cat ${WORKDIR}/src	>>${WORKDIR}/opkg.conf
	cat ${WORKDIR}/dest	>>${WORKDIR}/opkg.conf
	cat ${WORKDIR}/lists	>>${WORKDIR}/opkg.conf
}

do_compile_append_shr () {
	cat ${WORKDIR}/tmp_dir	>>${WORKDIR}/opkg.conf
}

do_compile_append_angstrom () {
	cat ${WORKDIR}/tmp_dir  >>${WORKDIR}/opkg.conf
}


do_install () {
	install -d ${D}${sysconfdir}/opkg
	install -m 0644 ${WORKDIR}/opkg.conf ${D}${sysconfdir}/opkg/opkg.conf
}

do_install_append_shr () {
	install -d ${D}/var/lib/opkg/tmp
}

do_install_append_angstrom () {
	install -d ${D}/var/lib/opkg/tmp
}

PACKAGE_ARCH = "all"
CONFFILES_${PN} = "${sysconfdir}/opkg/opkg.conf"
