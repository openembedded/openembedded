# ixp4xx-kernel.inc
#
# Standard definitions for any IXP4xx Linux kernel.
# Include this file in a .bb which specifies, at least,
# PN,PV,PR for the desired kernel
#
# Define the following *before* including this file as
# required:
#
# IXP4XX_PATCHES - full list of patches to apply, to add files
#   generate a patch against /dev/null
#
# DEFAULT_PREFERENCE is set automagically in this file as
# follows:
#
#  10  For *released* kernels
#   8  For mm or ac patched versions of released kernels
#   6  For rc patched kernels (release candidates)
#   4  For mm or ac patched rc (release candidate) kernels
#   2  For pre or bk versions
#   0  For mm or ac patched pre or bk versions
#
# --------------------------------------------------------------
#
SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Intel IXP4xx device"
LICENSE = "GPLv2"

DEPENDS = "arm-kernel-shim devio-native"

# Linux kernel source has the general form linux-X.Y.Z-patchP,
# X.Y is the major version number, Z (which may have multiple
# parts) is a sub-version and 'patch' is something like 'mm' or
# 'ac' with a patch version.  The original bz2 archive will be
# in a directory/file vX.Y/linux-X.Y.Z.tar.bz2.  The unpacked
# source will be in the directory linux-X.Y.Z and this directory
# name corresponds to the module directory (in /lib/modules).
#
# The corresponding .bb file should be called:
#
#	package_X.Y.Z-patchP
#
# Giving PN=package PV=X.Y.Z-patchP (and PR is set in the .bb
# file).  Files, including the all important defconfig, are
# searched for in the following directories (last one first):
#
#	ixp4xx-kernel/files
#	ixp4xx-kernel/X.Y
#	ixp4xx-kernel/X.Y.Z
#	ixp4xx-kernel/X.Y.Z-patch
#	ixp4xx-kernel/X.Y.Z-patchP
#	package-X.Y.Z-patchP
#
# This allows sharing of patch files and other useful source!
# To share a file or patch with an earlier version put it in
# the shared directory - e.g. to use foo.patch on 2.6.11.2 and
# 2.6.11.4 it should be in directory ixp4xx-kernel/2.6.11.
#
# Note that when there are multiple patches the X.Y.Z-patch form
# uses base-patch (e.g. 2.6.12-mm) whereas X.Y.Z-patchP has the
# full form, for example 2.6.12-rc3-mm1 (in the same case).

#PN=package-name
#PV=package-version (full)

# The patch has the general form (rcN|preN|acN|mmN|bkN)* with the
# separate patch items being separated by '-' characters.  The
# rc patch is first and has the important property that it
# requires the *preceding* kernel base version and that this
# will be the source directory name.
python () {
    # The patches list may be empty.  This code starts with the base
    # kernel version and steps through the patches.  Because the rc and
    # pre patches actually require the *preceding* kernel version the code
    # fixes that up appropriately.
    pv = bb.data.getVar("PV",d,1).split('-')
    if pv[0].count('+'):
	prev = pv[0].split('+')
	pv[0] = prev[1];
    kernel = pv[0].split('.')
    base = pv[0]
    name = [base]
    major = '.'.join(name[0].split('.')[0:2])
    minor = '.'.join(name[0].split('.')[0:3])
    patch_uri = [ None ]
    filedir = "${FILE_DIRNAME}/ixp4xx-kernel/%s"
    # This entry will become the last one (everything is inserted before it)
    filepath = [ filedir % "files" ]
    pref = 10
    mmac = 0
    for patch in pv[1:]:
        name.append(patch)
        pname = '-'.join(name)
        if patch[0:2] == "rc" or patch[0:3] == "pre":
            patch_uri.append("${KERNELORG_MIRROR}/pub/linux/kernel/v%s/testing/patch-%s.bz2;patch=1;pname=%s" % (major, pname, pname))
            kernel[-1] = str(int(kernel[-1]) - 1)
            if patch[0:2] == "rc" and pref == 10:
                pref = 6
                filepath[0:0] = [ filedir % name[0] ]
                filepath[0:0] = [ filedir % (name[0] + "-rc") ]
            else:
                pref = 2
        elif patch[0:2] == "bk" or patch[0:3] == "git":
            patch_uri.append("${KERNELORG_MIRROR}/pub/linux/kernel/v%s/snapshots/patch-%s.bz2;patch=1;pname=%s" % (major, pname, pname))
            pref = 2
        elif patch[0:2] == "ac":
            patch_uri.append("${KERNELORG_MIRROR}/pub/linux/kernel/people/alan/linux-%s/%s/patch-%s" % (major, base, pname))
            mmac = 2
            filepath[0:0] = [ filedir % (name[0] + "-ac") ]
        elif patch[0:2] == "mm":
            patch_uri.append("${KERNELORG_MIRROR}/pub/linux/kernel/people/akpm/patches/%s/%s/%s/%s.bz2;patch=1;pname=%s" % (major, base, pname, pname, pname))
            mmac = 2
            filepath[0:0] = [ filedir % (name[0] + "-mm") ]
        else:
            raise bb.build.FuncFailed("ixp4xx-kernel: patch %s not recognized in %s" % (patch, '-'.join(pv)))
            filepath[0:0] = [ filedir % pname ]
        base = pname

    base = '.'.join(kernel)
    patch_uri[0] = "${KERNELORG_MIRROR}/pub/linux/kernel/v%s/linux-%s.tar.bz2" % (major, base)
    filepath[-1:-1] = [ filedir % base ]
    if base != minor:
        filepath[-1:-1] = [ filedir % minor ]
    filepath[-1:-1] = [ filedir % major ]

    bb.data.setVar("IXP4XX_SRCMAJ", major, d)
    # bb.note("IXP4XX_SRCMAJ := %s" % major)
    bb.data.setVar("IXP4XX_SRCVER", base, d)
    # bb.note("IXP4XX_SRCVER := %s" % base)
    bb.data.setVar("IXP4XX_SRCURI", ' '.join(patch_uri), d)
    # bb.note("IXP4XX_SRCURI := %s" % ' '.join(patch_uri))
    bb.data.setVar("IXP4XX_FILESPATH", ':'.join(filepath), d)
    # bb.note("IXP4XX_FILESPATH := %s" % ' '.join(filepath))
    bb.data.setVar("DEFAULT_PREFERENCE", pref-mmac, d)
    # bb.note("DEFAULT_PREFERENCE := %s" % (pref-mmac))
}

# FILESPATH: this list is in order last-searched-first, therefore
# the first entry is the *latest* and/or most specific
FILESPATH = "${FILE_DIRNAME}/${P}:${IXP4XX_FILESPATH}"

# The working directory will be the 'base' version (which may not be the
# same as implied by the PV variable because it corresponds to the prior
# minor version for rc and pre patched versions).
S = "${WORKDIR}/linux-${IXP4XX_SRCVER}"

# IXP4XX_PATCHES is the list of patches.
IXP4XX_PATCHES ?= ""

SRC_URI  = "${IXP4XX_SRCURI}"
SRC_URI += "${IXP4XX_PATCHES}"

COMPATIBLE_HOST = 'arm.*-linux.*'
COMPATIBLE_MACHINE = '(ixp4xx|nslu2|fsg3)'

inherit kernel siteinfo

ARCH = "arm"

# To specify the console set KERNEL_CONSOLE in the .bb file.
# CMDLINE_ROOT contains the boot options, these will be
# appended to the build in boot options (so it is only necessary
# to override stuff in the kernel source).

# CMDLINE_ROOT: machine specific boot options - should not be set on a
#  generic kernel!
CMDLINE_ROOT ?= ""

# CMDLINE_DEBUG: debug options such as noirqdebug, defaults to empty
# override in local.conf etc
CMDLINE_DEBUG ?= ""

CMDLINE  = "${CMDLINE_ROOT}"
CMDLINE += "${CMDLINE_DEBUG}"
CMDLINE += "${CMDLINE_CONSOLE}"

# Set EXTRAVERSION and LOCALVERSION to "" so that the kernel version
# remains pinned to the x.y.z form, also turn off the directory
# printing which provides almost all the output of an incremental build.
EXTRA_OEMAKE += "EXTRAVERSION="
EXTRA_OEMAKE += "LOCALVERSION="
EXTRA_OEMAKE += "MAKEFLAGS='--no-print-directory'"

# Set the correct CONFIG_CPU_xxx_ENDIAN and CONFIG_CMDLINE at the head
# of the .config file and remove any settings in defconfig then append
# defconfig to .config
do_configure_prepend() {
	rm -f ${S}/.config
	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >>'${S}/.config'
	if test '${SITEINFO_ENDIANESS}' = be
	then
		echo 'CONFIG_CPU_BIG_ENDIAN=y' >>'${S}/.config'
	fi

        if [ "${TARGET_OS}" == "linux-gnueabi" -o  "${TARGET_OS}" == "linux-uclibceabi" ]; then               
                echo "CONFIG_AEABI=y"                   >> ${S}/.config               
                echo "CONFIG_OABI_COMPAT=y"             >> ${S}/.config       
        else
                echo "# CONFIG_AEABI is not set"        >> ${S}/.config
                echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
        fi      

        sed     -e '/CONFIG_CPU_BIG_ENDIAN/d' \
	        -e '/CONFIG_CMDLINE=/d' \
		-e '/CONFIG_AEABI/d' \
		-e '/CONFIG_OABI_COMPAT=/d' \
		'${WORKDIR}/defconfig' >>'${S}/.config'
	rm -rf ${S}/include/asm-arm/arch ${S}/include/asm-arm/proc \
	       ${S}/include/asm-arm/.proc ${S}/include/asm-arm/.arch

}


# Kernel module dependencies

DEPENDS += "zd1211-firmware"
RDEPENDS_kernel-module-zd1211rw += "zd1211-firmware"


# MACHID and LE handling
#
# This mach_fixup function adds the required prefix to the image to
# force the machine id in the kernel to be a particular value.  For
# LE builds it also forces the CPU into LE mode - this is actually
# harmless even if the CPU is already in LE mode.  This deals with
# two known problems on some boards:
#
# 1) The machine type set by the boot loader is wrong - e.g. the type
#    for an ixdp425, not the actual board type.  Prefix the code with
#    two instructions:
#        e3a01c<hh> e38110<ll>
#    Where the machine ID is 0xhhll
# 2) For LE kernels it is necessary to prefix change-to-le code to
#    the kernel image if the boot loader runs with the CPU in BE
#    (which is normal for IXP4XX boards):
#        ee110f10 e3c00080 ee010f10
#    and to byte swap the (LE) image to match the BE flash layout
#
# (2) is not required with an LE boot loader (neither the prefix
#  nor the byte swapping) so this is controlled by a separate flag,
#  however if the boot loader is LE it expects and LE image so the
#  instructions written for the machine id must be LE.
#
# The argument to the function is the destination directory

# The generic package only includes the generic image, the other
# packages are made below (they are kernel-image packages but
# with a different ARCH).
FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}-${MACHINE_ARCH}-${KERNEL_VERSION}"

# MACHINE DEFINITIONS: one block for each machine

# The correct settings for the NSLU2 board:
nslu2_MACHID = "597"
PACKAGES += "kernel-image-nslu2"
PKG_kernel-image-nslu2 = "kernel-image-${KERNEL_VERSION}"
PACKAGE_ARCH_kernel-image-nslu2 = "nslu2${SITEINFO_ENDIANESS}"
DESCRIPTION_kernel-image-nslu2 = "Linux kernel for the LinkSys NSLU2"
FILES_kernel-image-nslu2 = "/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-nslu2${SITEINFO_ENDIANESS}-${KERNEL_VERSION}"
pkg_postinst_kernel-image-nslu2 () {
	update-alternatives --install /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE} ${KERNEL_IMAGETYPE} /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-nslu2${SITEINFO_ENDIANESS}-${KERNEL_VERSION} ${KERNEL_PRIORITY} || true
}
pkg_postrm_kernel-image-nslu2 () {
	update-alternatives --remove ${KERNEL_IMAGETYPE} /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-nslu2${SITEINFO_ENDIANESS}-${KERNEL_VERSION} || true
}

# The correct settings for the NAS100D board:
nas100d_MACHID = "865"
PACKAGES += "kernel-image-nas100d"
PKG_kernel-image-nas100d = "kernel-image-${KERNEL_VERSION}"
PACKAGE_ARCH_kernel-image-nas100d = "nas100d${SITEINFO_ENDIANESS}"
DESCRIPTION_kernel-image-nas100d = "Linux kernel for the IOMega NAS100D"
FILES_kernel-image-nas100d = "/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-nas100d${SITEINFO_ENDIANESS}-${KERNEL_VERSION}"
pkg_postinst_kernel-image-nas100d () {
	update-alternatives --install /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE} ${KERNEL_IMAGETYPE} /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-nas100d${SITEINFO_ENDIANESS}-${KERNEL_VERSION} ${KERNEL_PRIORITY} || true
}
pkg_postrm_kernel-image-nas100d () {
	update-alternatives --remove ${KERNEL_IMAGETYPE} /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-nas100d${SITEINFO_ENDIANESS}-${KERNEL_VERSION} || true
}

# The correct settings for the DSMG600 board:
dsmg600_MACHID = "964"
PACKAGES += "kernel-image-dsmg600"
PKG_kernel-image-dsmg600 = "kernel-image-${KERNEL_VERSION}"
PACKAGE_ARCH_kernel-image-dsmg600 = "dsmg600${SITEINFO_ENDIANESS}"
DESCRIPTION_kernel-image-dsmg600 = "Linux kernel for the D-Link DSM-G600"
FILES_kernel-image-dsmg600 = "/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-dsmg600${SITEINFO_ENDIANESS}-${KERNEL_VERSION}"
pkg_postinst_kernel-image-dsmg600 () {
	update-alternatives --install /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE} ${KERNEL_IMAGETYPE} /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-dsmg600${SITEINFO_ENDIANESS}-${KERNEL_VERSION} ${KERNEL_PRIORITY} || true
}
pkg_postrm_kernel-image-dsmg600 () {
	update-alternatives --remove ${KERNEL_IMAGETYPE} /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-dsmg600${SITEINFO_ENDIANESS}-${KERNEL_VERSION} || true
}

# The correct settings for the FSG-3 board:
fsg3_MACHID = "1091"
PACKAGES += "kernel-image-fsg3"
PKG_kernel-image-fsg3 = "kernel-image-${KERNEL_VERSION}"
PACKAGE_ARCH_kernel-image-fsg3 = "fsg3${SITEINFO_ENDIANESS}"
DESCRIPTION_kernel-image-fsg3 = "Linux kernel for the Freecom FSG-3"
FILES_kernel-image-fsg3 = "/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-fsg3${SITEINFO_ENDIANESS}-${KERNEL_VERSION}"
pkg_postinst_kernel-image-fsg3 () {
	update-alternatives --install /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE} ${KERNEL_IMAGETYPE} /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-fsg3${SITEINFO_ENDIANESS}-${KERNEL_VERSION} ${KERNEL_PRIORITY} || true
}
pkg_postrm_kernel-image-fsg3 () {
	update-alternatives --remove ${KERNEL_IMAGETYPE} /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-fsg3${SITEINFO_ENDIANESS}-${KERNEL_VERSION} || true
}

BYTESWAP_armeb = "cp$"
BYTESWAP_arm   = "xp $,4"

# We need the alternatives to happen in the kernel-image packages, not in
# the kernel package, because only the images know the name of the kernel.
pkg_postinst_kernel () {
}
pkg_postrm_kernel () {
}

# copy_image <dest> <machine>
#	copy the zImage and append the appropriate shim
#  dest:       where to copy to
#  machine:    machine shim to prepend, empty for none
copy_image() {
	local shim

	shim="/dev/null"
	test -n "$2" && shim="${STAGING_LOADER_DIR}/arm-kernel-shim-$2.bin"

	rm -f "$1".new "$1".shimmed
	cat $shim ${KERNEL_OUTPUT} > "$1".shimmed
	devio '<<'"$1"'.shimmed' >"$1".new '${BYTESWAP}' || {
		echo 'ERROR: ${KERNEL_OUTPUT}: failed to copy zImage' >&2
		return 1
	}
	rm -f "$1".shimmed
	mv "$1".new "$1"
}

install_image() {
	copy_image '${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-'"$1"'-${KERNEL_VERSION}' "$2"
}

do_install_append() {
	# Overwrite the unshimmed generic image with a shimmed one (but without
	# any command line or machine id override).
	rm -f '${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION}'
	install_image '${MACHINE_ARCH}'

	# Add the machine specific images, with appropriate suffixes
	install_image 'nslu2${SITEINFO_ENDIANESS}' 'nslu2'
	install_image 'nas100d${SITEINFO_ENDIANESS}' 'nas100d'
	install_image 'dsmg600${SITEINFO_ENDIANESS}' 'dsmg600'
	install_image 'fsg3${SITEINFO_ENDIANESS}' 'fsg3'
}

deploy_image() {
	copy_image '${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-'"$1" "$2"
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
	deploy_image '${MACHINE_ARCH}'

	# And the machine specific images
	deploy_image 'nslu2${SITEINFO_ENDIANESS}' 'nslu2'
	deploy_image 'nas100d${SITEINFO_ENDIANESS}' 'nas100d'
	deploy_image 'dsmg600${SITEINFO_ENDIANESS}' 'dsmg600'
	deploy_image 'fsg3${SITEINFO_ENDIANESS}' 'fsg3'
}
