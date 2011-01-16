# UCLIBC_BASE should be the latest released version of uclibc (that way
# the config files will typically be correct!)  uclibc-svn takes precedence
# over uclibc-${UCLIBC_BASE}, if a config file in uclibc-snv is out of date
# try removing it
#
# UCLIBC_BASE can be set in a distro file, but whether this works depends
# on whether the base patches apply to the selected (SRCDATE) svn release.
#
UCLIBC_BASE ?= "0.9.32"
SRCREV="8fdc17c2ba1322712604d88dca48157068e6aadb"
PR_append = "+gitr${SRCPV}"
DEFAULT_PREFERENCE = "-1"
#DEFAULT_PREFERENCE is 0 (empty), releases have a preference of 1 so take
# precedence.

require uclibc.inc
PR = "${INC_PR}.5"
PROVIDES += "virtual/${TARGET_PREFIX}libc-for-gcc"

#recent versions uclibc require real kernel headers
PACKAGE_ARCH = "${MACHINE_ARCH}"
FILESPATHPKG =. "uclibc-git:uclibc-${UCLIBC_BASE}:"

#as stated above, uclibc needs real kernel-headers
#however: we can't depend on virtual/kernel when nptl hits due to depends deadlocking ....
KERNEL_SOURCE = "${STAGING_DIR_HOST}/${exec_prefix}"
SRC_URI = "git://uclibc.org/uClibc.git;branch=master;protocol=git \
	file://uClibc.config \
	file://uClibc.machine \
	file://uClibc.distro \
	file://uclibc-arm-ftruncate64.patch \
	file://uclibc_enable_log2_test.patch \
	file://ldso_use_arm_dl_linux_resolve_in_thumb_mode.patch \
	file://reorder-use-BX.patch \
	file://select-force-thumb.patch \
	file://remove-sub-arch-variants.patch \
	file://transform-eabi-oabi-choice.patch \
	file://include-arm-asm.h.patch \
	file://detect-bx-availibility.patch \
	file://remove-eabi-oabi-selection.patch \
	file://0001-Revert-ldso-i386-support-protected-symbols.patch \
	file://0002-Revert-ldso_sh-add-support-for-protected-symbols-to-.patch \
	file://0003-Revert-ldso-arm-Correct-protected-symbol-resolution.patch \
	file://0004-Add-protected-symbols-support-for-all-architectures.patch \
	file://0005-ldso-get-rid-of-_dl_lookup_hash.patch \
	file://pro-sym-mips-fix.patch \
	"
S = "${WORKDIR}/git"
