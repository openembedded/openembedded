# FIXME, consider using kernel staging directory instead of KERNEL_SOURCE which is
# located in the work directory. see module.bbclass

DESCRIPTION = "char-driver and userspace program"
PRIORITY = "optional"
SECTION = "base"
LICENSE = "GPL"
RDEPENDS = "kernel (${KERNEL_VERSION})"
DEPENDS = "virtual/kernel"

PR = "r3"

SRC_URI = "http://www.davehylands.com/gumstix-wiki/char-driver/char-driver-2.6.21.tar.gz \
   file://makefile.patch;patch=1 \
#   file://sysctl.patch;patch=1 \
   "

S = "${WORKDIR}/char-driver"

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
   mv char-driver*.c sample.c char-driver*.h Makefile ${S}
}

do_configure () {
	echo "Nothing to configure for char-driver"
}

do_compile () {
   unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
   cd ${S}   
	oe_runmake
}

do_install () {
   # install programs to bindir
   install -m 0755 -d ${D}${bindir}
	install -m 0755  ${S}/sample ${D}${bindir}

   # kernel module installs with other modules
   install -m 0755 -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
   # use cp instead of install so the driver doesn't get stripped
   cp ${S}/char-driver.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
}

PACKAGES = "${PN}"
FILES_${PN} = "${bindir}/sample"
FILES_${PN} += "${base_libdir}/modules/${KERNEL_VERSION}/extra/char-driver.ko"


SRC_URI[md5sum] = "70113b86db5dea86c282053e15f36cb7"
SRC_URI[sha256sum] = "9a87282052a8c0807bbcb46367102f97896a1cf4fcc0d35cfe34b2e5a1456a31"
