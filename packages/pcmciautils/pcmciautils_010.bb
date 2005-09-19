DESCRIPTION = "Linux Kernel 2.6 Userland Utilities for the PCMCIA Subsystem"
DEPENDS = "sysfsutils"
HOMEPAGE = "http://kernel.org/pub/linux/utils/kernel/pcmcia/pcmcia.html"
SECTION = "kernel/userland"
PRIORITY = "optional"

SRC_URI = "http://kernel.org/pub/linux/utils/kernel/pcmcia/pcmciautils-${PV}.tar.bz2"
S = "${WORKDIR}/pcmciautils-${PV}"

inherit update-rc.d

INITSCRIPT_NAME = "coldplug"
INITSCRIPT_PARAMS = "defaults"

export HOSTCC = "${BUILD_CC}"
export etcdir = "${sysconfdir}"
export hotplugdir = "${sysconfdir}/hotplug"
export pcmciaconfdir = "${sysconfdir}/pcmcia"
LD = "${CC}"
CFLAGS =+ "-I${S}/src"
CFLAGS =+ '-DPCMCIAUTILS_VERSION=010'

PARALLEL_MAKE = ""
EXTRA_OEMAKE = "-e 'STRIP=echo' 'LIB_OBJS=-lc -lsysfs'"

do_install () {
	oe_runmake 'DESTDIR=${D}' install
}

CONFFILES_${PN} += "${sysconfdir}/pcmcia/config.opts"
RCONFLICTS_${PN} += "pcmcia-cs"
