DEPENDS += "sysfsutils virtual/libintl"
DESCRIPTION = "2.6 pcmcia utilities"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
SECTION = "base"
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

EXTRA_OEMAKE = "-e \
		'STRIP=echo' \
		'LIB_OBJS=-lc -lsysfs -lintl'"

do_compile () {
	oe_runmake build/ccdv
	oe_runmake
}

do_install () {
	oe_runmake 'DESTDIR=${D}' install
}

CONFFILES_${PN} += "${sysconfdir}/pcmcia/config.opts"
RCONFLICTS_${PN} += "pcmcia-cs"
