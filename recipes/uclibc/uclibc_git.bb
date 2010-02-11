# UCLIBC_BASE should be the latest released version of uclibc (that way
# the config files will typically be correct!)  uclibc-svn takes precedence
# over uclibc-${UCLIBC_BASE}, if a config file in uclibc-snv is out of date
# try removing it
#
# UCLIBC_BASE can be set in a distro file, but whether this works depends
# on whether the base patches apply to the selected (SRCDATE) svn release.
#
UCLIBC_BASE ?= "0.9.30"
SRCREV="63859f89f327e48037a4cdba982cd6afa3007da7"
PV = "${UCLIBC_BASE}+gitr${SRCREV}"
DEFAULT_PREFERENCE = "-1"
#DEFAULT_PREFERENCE is 0 (empty), releases have a preference of 1 so take
# precedence.

require uclibc.inc
PR = "${INC_PR}.0"
PROVIDES += "virtual/${TARGET_PREFIX}libc-for-gcc"

#recent versions uclibc require real kernel headers
PACKAGE_ARCH = "${MACHINE_ARCH}"
FILESPATHPKG =. "uclibc-git:uclibc-${UCLIBC_BASE}:"

#as stated above, uclibc needs real kernel-headers
#however: we can't depend on virtual/kernel when nptl hits due to depends deadlocking ....
KERNEL_SOURCE = "${CROSS_DIR}/${TARGET_SYS}"

SRC_URI = "git://uclibc.org/uClibc.git;branch=master;protocol=git \
	${@['${UCLIBC_LOCALE_URI}', ''][bb.data.getVar('USE_NLS', d, 1) != 'yes']} \
	file://uClibc.config \
	file://uClibc.machine \
	file://uClibc.distro \
	file://uclibc-arm-ftruncate64.patch;patch=1 \
	file://uclibc_enable_log2_test.patch;patch=1 \
	file://ldso_use_arm_dl_linux_resolve_in_thumb_mode.patch;patch=1 \
	"
S = "${WORKDIR}/git"
