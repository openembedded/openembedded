# UCLIBC_BASE should be the latest released revision of uclibc (that way
# the config files will typically be correct!)  uclibc-cvs takes precedence
# over uclibc-${UCLIBC_BASE}, if a config file in uclibc-cvs is out of date
# try removing it
#
# UCLIBC_BASE can be set in a distro file, but whether this works depends
# on whether the base patches apply to the selected (SRCDATE) svn release.
#
UCLIBC_BASE ?= "0.9.31"

require uclibc.inc
PR = "${INC_PR}.1"

PROVIDES += "virtual/${TARGET_PREFIX}libc-for-gcc"

SRC_URI += "file://uClibc.machine file://uClibc.distro \
	    file://ldso_use_arm_dl_linux_resolve_in_thumb_mode.patch \
	   "

#recent versions uclibc require real kernel headers
PACKAGE_ARCH = "${MACHINE_ARCH}"

#as stated above, uclibc needs real kernel-headers
#however: we can't depend on virtual/kernel when nptl hits due to depends deadlocking ....
KERNEL_SOURCE = "${STAGING_DIR_HOST}/${exec_prefix}"

S = "${WORKDIR}/uClibc-${UCLIBC_BASE}"

SRC_URI[uClibc-0.9.31.md5sum] = "52fb8a494758630c8d3ddd7f1e0daafd"
SRC_URI[uClibc-0.9.31.sha256sum] = "80d33549d2a5d7ddc95b10dd964fead34d568c47268bba057c4b816f1d1263fa"
