SECTION = "console/utils"
DESCRIPTION = "A tool for retrieving kernel spinlock metering information."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
DEPENDS = "virtual/kernel"

SRC_URI = "ftp://oss.sgi.com/projects/lockmeter/download/lockstat-${PV}.tar.gz"
S = "${WORKDIR}/lockstat"

export KERNEL_VERSION = ${@base_read_file('${STAGING_KERNEL_DIR}/kernel-abiversion')}
export KERNEL_SOURCE = ${@base_read_file('${STAGING_KERNEL_DIR}/kernel-source')}
CFLAGS += " -I${KERNEL_SOURCE}/include"

python () {
# NOTE: any target machines with kernels supporting spinlock metering should
# check the MACHINE variable here to prevent the SkipPackage.
	raise bb.parse.SkipPackage("The target machine's kernel does not appear able to use spinlock metering.")
}

do_compile () {
	oe_runmake
}

do_install () {
	install -d ${D}${sbindir}
	install -m 0755 lockstat ${D}${sbindir}/
}
