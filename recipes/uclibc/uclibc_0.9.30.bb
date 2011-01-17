# UCLIBC_BASE should be the latest released revision of uclibc (that way
# the config files will typically be correct!)  uclibc-cvs takes precedence
# over uclibc-${UCLIBC_BASE}, if a config file in uclibc-cvs is out of date
# try removing it
#
# UCLIBC_BASE can be set in a distro file, but whether this works depends
# on whether the base patches apply to the selected (SRCDATE) svn release.
#
UCLIBC_BASE ?= "0.9.30"

require uclibc-old.inc
PR = "${INC_PR}.2"

PROVIDES += "virtual/${TARGET_PREFIX}libc-for-gcc"

SRC_URI += "file://uClibc.machine file://uClibc.distro \
            file://arm-linuxthreads.patch \
            file://linuxthreads-changes.patch \
	    file://pthread_atfork.patch \
	    file://uclibc_ldso_use_O0.patch \
	    file://ldso_use_arm_dl_linux_resolve_in_thumb_mode.patch \
            file://unifdef-fix.patch \
	    file://Use-__always_inline-instead-of-__inline__.patch \
	   "
#recent versions uclibc require real kernel headers
PACKAGE_ARCH = "${MACHINE_ARCH}"

#as stated above, uclibc needs real kernel-headers
#however: we can't depend on virtual/kernel when nptl hits due to depends deadlocking ....
KERNEL_SOURCE = "${STAGING_DIR_HOST}/${exec_prefix}"

S = "${WORKDIR}/uClibc-${UCLIBC_BASE}"

SRC_URI[uClibc-0.9.30.md5sum] = "e5766e2566e0297adebebbcc0aba1f2d"
SRC_URI[uClibc-0.9.30.sha256sum] = "67e7e6b983cd2caa163f177d5196282434ae1e18b7270495cd6c65f5c1549555"
