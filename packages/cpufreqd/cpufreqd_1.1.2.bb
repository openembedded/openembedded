DESCRIPTION = "cpufreqd is meant to be a replacement of the speedstep \
applet you can find in Windows. It monitors battery level, CPU usage, \
AC state, and running programs and adjusts the frequency governor \
according to a set of rules specified in the config file."
SECTION = "console/utils"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/cpufreqd/cpufreqd-${PV}.tar.gz \
	   file://nonrootinstall.patch;patch=1"

inherit autotools 

FILES_${PN} = "${sbindir} ${sysconfdir} ${libdir}/libsys_*.so"
FILES_${PN}-dev = "${libdir}/*.la ${libdir}/*.a"
