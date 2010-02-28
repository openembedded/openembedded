LICENSE = "GPLv2"
DESCRIPTION = "To make access to the Linux kernel cpufreq subsystem easier for users and cpufreq userspace tools, a cpufrequtils package was created"

PR = "r1"

SRC_URI = "http://www.kernel.org/pub/linux/utils/kernel/cpufreq/cpufrequtils-${PV}.tar.bz2 \
           file://fix-proc-stat-reading.patch;patch=1 \
"

export CROSS = "${TARGET_PREFIX}"
export LIBTOOL = "${TARGET_PREFIX}libtool --tag cc"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
	oe_runmake -e 
}

do_install() {
	oe_runmake -e install DESTDIR=${D}
}



