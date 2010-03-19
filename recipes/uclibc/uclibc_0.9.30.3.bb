# UCLIBC_BASE should be the latest released revision of uclibc (that way
# the config files will typically be correct!)  uclibc-cvs takes precedence
# over uclibc-${UCLIBC_BASE}, if a config file in uclibc-cvs is out of date
# try removing it
#
# UCLIBC_BASE can be set in a distro file, but whether this works depends
# on whether the base patches apply to the selected (SRCDATE) svn release.
#
UCLIBC_BASE ?= "0.9.30.3"

require uclibc.inc
PR = "${INC_PR}.0"

PROVIDES += "virtual/${TARGET_PREFIX}libc-for-gcc"

SRC_URI += "file://uClibc.machine file://uClibc.distro \
	    file://ldso_use_arm_dl_linux_resolve_in_thumb_mode.patch;patch=1 \
	   "
SRC_URI[uClibc-0.9.30.2.md5sum] = "e759ec855500082ac3e671dd6cacfdb0"
SRC_URI[uClibc-0.9.30.2.sha256sum] = "ab6e92c91e2f8fad182d3b624b87d6cbf53072678d8fc31ad73e6abd3c852473"

#recent versions uclibc require real kernel headers
PACKAGE_ARCH = "${MACHINE_ARCH}"

#as stated above, uclibc needs real kernel-headers
#however: we can't depend on virtual/kernel when nptl hits due to depends deadlocking ....
KERNEL_SOURCE = "${STAGING_DIR_HOST}/${exec_prefix}"

S = "${WORKDIR}/uClibc-${UCLIBC_BASE}"
SRC_URI[uClibc-0.9.30.3.md5sum] = "73a4bf4a0fa508b01a7a3143574e3d21"
SRC_URI[uClibc-0.9.30.3.sha256sum] = "107c3ac914e9a670a9f501519ed89a647e05e48dc4c474dc3d7cddaa78bb2e38"

