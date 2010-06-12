DESCRIPTION = "IP set framework"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
DEPENDS += "virtual/libc"

inherit module

PR="r0"

SRC_URI = " \
	http://ipset.netfilter.org/ipset-${PV}.tar.bz2 \
	file://Makefile.patch \
	"

PACKAGES += "${PN}-modules"

FILES_${PN} = "${sbindir} ${libdir}"
FILES_${PN}-doc = "${mandir}"
FILES_${PN}-modules = "${base_libdir}/modules/${KERNEL_VERSION}/extra/ip_set*${KERNEL_OBJECT_SUFFIX} \
	${base_libdir}/modules/${KERNEL_VERSION}/extra/ipt*${KERNEL_OBJECT_SUFFIX}"

EXTRA_OEMAKE = "KERNEL_DIR=${KERNEL_SOURCE} MANDIR=${mandir}"

do_compile () {
	oe_runmake binaries
	module_do_compile MAKE_TARGETS=modules
}

do_install_append () {
	oe_runmake binaries_install PREFIX=${prefix} DESTDIR=${D}
}
