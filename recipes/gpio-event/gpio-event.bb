# FIXME, consider using kernel staging directory instead of KERNEL_SOURCE which is
# located in the work directory. see module.bbclass

DESCRIPTION = "gpio-event driver and userspace program"
PRIORITY = "optional"
SECTION = "base"
LICENSE = "GPL"
RDEPENDS = "kernel (${KERNEL_VERSION})"
DEPENDS = "virtual/kernel"

PR = "r4"

SRC_URI = "http://davehylands.com/gumstix-wiki/gpio-event/gpio-event-2.6.21-1444-select.tar.gz \
   file://makefile.patch;patch=1 \
   "

S = "${WORKDIR}/gpio-event"

inherit module-base

addtask builddir after do_fetch before do_unpack
addtask movesrc after do_unpack before do_patch

EXTRA_OEMAKE = 'CROSS_COMPILE="${CROSS_COMPILE}" \
                KERNELDIR="${KERNEL_SOURCE}" \
                CC="${CC}" \
                '

PARALLEL_MAKE = ""

do_builddir () {
   mkdir -p ${S}
}

do_movesrc () {
   cd ${WORKDIR}
   mv gpio-event*.c gpio-event*.h Makefile ${S}
}

do_configure () {
	echo "Nothing to configure for gpio-event"
}

do_compile () {
   unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
   cd ${S}
	oe_runmake   
}

do_install () {
   # install programs to bindir
   install -m 0755 -d ${D}${bindir}
	install -m 0755  ${S}/gpio-event ${D}${bindir}

   # kernel module installs with other modules
   install -m 0755 -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
   # use cp instead of install so the driver doesn't get stripped
   cp ${S}/gpio-event-drv.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
}

PACKAGES = "${PN}"
FILES_${PN} = "${bindir}/gpio-event"
FILES_${PN} += "${base_libdir}/modules/${KERNEL_VERSION}/extra/gpio-event-drv.ko"


SRC_URI[md5sum] = "b5cc96cba5a70e19d58534c250de67e2"
SRC_URI[sha256sum] = "a937f4ba6b450b1330049c90e5e787490eff5bb376dbfe9099abbcdc7a8f6b6c"
