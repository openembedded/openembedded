# nvidia-display .bb build file
# Copyright (C) 2005-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

HOMEPAGE="http://www.nvidia.com/object/unix.html"
DESCRIPTION="NVidia Graphics Driver Binary"
LICENSE = "NVIDIA"

inherit module
INHIBIT_PACKAGE_STRIP="1"

def nvidia_pkgrun(d):
	import bb, re
	arch = bb.data.getVar('TARGET_ARCH', d, 1)
	pkgrun = "pkg2"
	if re.match("^i.86$", arch):
		pkgrun = "pkg1"
	return pkgrun
	
def nvidia_arch(d):
	import bb, re
	arch = bb.data.getVar('TARGET_ARCH', d, 1)
	if re.match("^i.86$", arch):
		arch = "x86"
	return arch

def get_kernelpatchlevel(p):
	import re
	r = re.compile("[0-9]+\.([0-9]+).*")
	m = r.match(p);
	if m:
		return m.group(1)
	return None
									
NVIDIA_ARCH := "${@nvidia_arch(d)}"
NVIDIA_PKGRUN := "${@nvidia_pkgrun(d)}"

COMPATIBLE_HOST = '.*86.*-linux'

KERNEL_PATCHLEVEL = "${@get_kernelpatchlevel('${KERNEL_VERSION}')}"
EXTRA_OEMAKE=" KERNEL_SOURCES=${STAGING_KERNEL_DIR} KERNEL_MODLIB=${STAGING_KERNEL_DIR} KERNEL_UNAME=${KERNEL_VERSION} PATCHLEVEL=${KERNEL_PATCHLEVEL} MODULE_ROOT=${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers IGNORE_CC_MISMATCH=1"

PKG_BASENAME="NVIDIA-Linux-${NVIDIA_ARCH}-${PV}-${NVIDIA_PKGRUN}"

FILES_${PN}-doc += " /usr/share/doc/*"

nvidia_do_unpack() {
	sh ${PKG_BASENAME}.run -x
}

python do_unpack() {
	bb.build.exec_func('base_do_unpack', d)
	bb.build.exec_func('nvidia_do_unpack', d)
}

