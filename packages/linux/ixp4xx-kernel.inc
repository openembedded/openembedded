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
# IXP4XX_SUFFIX - the suffix to add after 'zImage-' in the
#   deploy/images directory, should identify the machines the
#   kernel will run on, ixp4xx[lb] for generic kernels (le or
#   be).  Controls the package architecture of the ipk.
# IXP4XX_MACHID - if set the kernel will be forced to use this
#   machine id and be forced to LE on LE systems - please always
#   remember to override IXP4XX_SUFFIX if this is done, the kernel
#   will simply not work on other machines.
# IXP4XX_LEFIXUP - if set prepend the LE fixup code to the kernel
#   and byte swap (quad word) the whole kernel image for a BE
#   boot loader
#
# If you set CMDLINE_ROOT you should *also* change IXP4XX_SUFFIX
#   because the resultant kernel may not work on other systems.
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
LICENSE = "GPL"
MAINTAINER = "NSLU2-Linux <www.nslu2-linux.org>"

# PACKAGE_ARCH must reliably identify what machines this kernel
# will run on
PACKAGE_ARCH = "${IXP4XX_SUFFIX}"

# Defaults for the prefix flags
IXP4XX_MACHID ?= ""
IXP4XX_LEFIXUP ?= ""

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
	    patch_uri.append("ftp://ftp.kernel.org/pub/linux/kernel/v%s/testing/patch-%s.bz2;patch=1;pname=%s" % (major, pname, pname))
	    kernel[-1] = str(int(kernel[-1]) - 1)
	    if patch[0:2] == "rc" and pref == 10:
	    	pref = 6
		filepath[0:0] = [ filedir % name[0] ]
		filepath[0:0] = [ filedir % (name[0] + "-rc") ]
	    else:
	    	pref = 2
	elif patch[0:2] == "bk" or patch[0:3] == "git":
	    patch_uri.append("ftp://ftp.kernel.org/pub/linux/kernel/v%s/snapshots/patch-%s.bz2;patch=1;pname=%s" % (major, pname, pname))
	    pref = 2
	elif patch[0:2] == "ac":
	    patch_uri.append("ftp://ftp.kernel.org/pub/linux/kernel/people/alan/linux-%s/%s/patch-%s" % (major, base, pname))
	    mmac = 2
	    filepath[0:0] = [ filedir % (name[0] + "-ac") ]
	elif patch[0:2] == "mm":
	    patch_uri.append("ftp://ftp.kernel.org/pub/linux/kernel/people/akpm/patches/%s/%s/%s/%s.bz2;patch=1;pname=%s" % (major, base, pname, pname, pname))
	    mmac = 2
	    filepath[0:0] = [ filedir % (name[0] + "-mm") ]
	else:
	    raise bb.build.FuncFailed("ixp4xx-kernel: patch %s not recognized in %s" % (patch, '-'.join(pv)))
	filepath[0:0] = [ filedir % pname ]
	base = pname

    base = '.'.join(kernel)
    patch_uri[0] = "ftp://ftp.kernel.org/pub/linux/kernel/v%s/linux-%s.tar.bz2" % (major, base)
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
SRC_URI += "file://defconfig"

COMPATIBLE_HOST = 'arm.*-linux'

inherit kernel

ARCH = "arm"
KERNEL_IMAGETYPE = "zImage"

# To specify the console set KERNEL_CONSOLE in the .bb file.
# CMDLINE_ROOT contains the boot options, CMDLINE_KERNEL_OPTIONS
# contains the things for a specific kernel.
#
# These are set from MACHINE specific defaults below, but an override
# in local.conf will still take precedence.
#
# CMDLINE_KERNEL_OPTIONS: overridable in local.conf
# MACH_KERNEL_OPTIONS: the default, added to so additional stuff can be
#  put in from local.conf etc.
MACH_KERNEL_OPTIONS += "rtc-x1205.hctosys=1 rtc-x1205.probe=0,0x6f"
MACH_KERNEL_OPTIONS += "rtc-ds1672.probe=0,0x68 rtc-ds1672.hctosys=1"
MACH_KERNEL_OPTIONS += "pcf8563.hctosys=1"
#
CMDLINE_KERNEL_OPTIONS ?= "${MACH_KERNEL_OPTIONS}"

# CMDLINE_ROOT: machine specific boot options - should not be set on a
#  generic kernel!
CMDLINE_ROOT ?= "init=/linuxrc"

# CMDLINE_DEBUG: debug options such as noirqdebug, defaults to empty
# override in local.conf etc
CMDLINE_DEBUG ?= ""
CMDLINE = "${CMDLINE_ROOT} ${CMDLINE_KERNEL_OPTIONS} ${CMDLINE_DEBUG} ${CMDLINE_CONSOLE}"

# Add the architecture compiler flags to KERNEL_CC and KERNEL_LD as
# required.  Notice that this has to be done for each separately built
# module as well!
KERNEL_CC += "${TARGET_CC_KERNEL_ARCH}"
KERNEL_LD += "${TARGET_LD_KERNEL_ARCH}"

# Set EXTRAVERSION and LOCALVERSION to "" so that the kernel version
# remains pinned to the x.y.z form, also turn off the directory
# printing which provides almost all the output of an incremental build.
EXTRA_OEMAKE += "EXTRAVERSION="
EXTRA_OEMAKE += "LOCALVERSION="
EXTRA_OEMAKE += "MAKEFLAGS='--no-print-directory'"

# Override KERNEL_RELEASE from kernel.bbclass to match:
KERNEL_RELEASE = "${KERNEL_VERSION}"

# Set the correct CONFIG_CPU_xxx_ENDIAN and CONFIG_CMDLINE at the head
# of the .config file and remove any settings in defconfig then append
# defconfig to .config
do_configure_prepend() {
	rm -f ${S}/.config
	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >>'${S}/.config'
	if test '${ARCH_BYTE_SEX}' = be
	then
		echo 'CONFIG_CPU_BIG_ENDIAN=y' >>'${S}/.config'
	fi
	if test '${SLUGOS_IMAGESEX}' = big-endian
	then
		echo 'CONFIG_JFFS2_BIG_ENDIAN=y' >>'${S}/.config'
	fi
	if test '${SLUGOS_IMAGESEX}' = little-endian
	then
		echo 'CONFIG_JFFS2_LITTLE_ENDIAN=y' >>'${S}/.config'
	fi
	sed -e '/CONFIG_CPU_BIG_ENDIAN/d' -e '/CONFIG_CMDLINE=/d' \
		-e '/CONFIG_JFFS2_NATIVE_ENDIAN=/d' \
		-e '/CONFIG_JFFS2_BIG_ENDIAN=/d' \
		-e '/CONFIG_JFFS2_LITTLE_ENDIAN=/d' \
		'${WORKDIR}/defconfig' >>'${S}/.config'
	rm -rf ${S}/include/asm-arm/arch ${S}/include/asm-arm/proc \
	       ${S}/include/asm-arm/.proc ${S}/include/asm-arm/.arch
}

# IXP4XX_MACHID and IXP4XX_LEFIXUP handling
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

#SETMACH: set the machine id (register 1) to IXP4XX_MACHID
SETMACH = '${@["", ".= ${IXP4XX_MACHID} .256/ 255& 0xe3a01c00+; ${WRITE}; .= 255& 0xe3811000+; ${WRITE};"][bb.data.getVar("IXP4XX_MACHID", d, 1) and 1]}'

#FIXUP: the correct instructions to copy the kernel prepended with the le fixup
FIXUP_armeb = 'cp$'
FIXUP_arm   = '${@["cp$", "wb 0xee110f10,4;wb 0xe3c00080,4;wb 0xee010f10,4;xp $,4"][bb.data.getVar("IXP4XX_LEFIXUP", d, 1) and 1]}'

#WRITE: the correct way to write a single ARM instruction (wb unless LE and !LEFIXUP).
WRITE_armeb = 'wb 4'
WRITE_arm   = '${@["wl 4", "wb 4"][bb.data.getVar("IXP4XX_LEFIXUP", d, 1) and 1]}'

DEPENDS += "devio-native"

# ${SETMACH}${FIXUP} is a sequence of devio commands to copy the image,
# in the standard (generic) case it is just 'cp$'
copy_image() {
	rm -f "$1".new
	devio '<<arch/${ARCH}/boot/${KERNEL_IMAGETYPE}' >"$1".new '${SETMACH}${FIXUP}' || {
		echo 'ERROR: arch/${ARCH}/boot/${KERNEL_IMAGETYPE}: failed to copy zImage' >&2
		return 1
	}
	mv "$1".new "$1"
}

do_install_append() {
	copy_image '${STAGING_KERNEL_DIR}/${KERNEL_IMAGETYPE}'
}

do_deploy[dirs] = "${S}"
do_deploy() {
        install -d ${DEPLOY_DIR}/images
	copy_image '${DEPLOY_DIR}/images/${KERNEL_IMAGETYPE}-${IXP4XX_SUFFIX}'
}

addtask deploy before do_build after do_compile

python () {
	# check for IXP4XX_SUFFIX - if not set then we don't know what to build,
	# also sanity check the SLUGOS_IMAGESEX
	sex = bb.data.getVar("SLUGOS_IMAGESEX", d, 1)
	if sex != 'little-endian' and sex != 'big-endian':
		raise bb.parse.SkipPackage("slugos kernels require SLUGOS_IMAGESEX")
	suffix = bb.data.getVar("IXP4XX_SUFFIX", d, 1)
	if suffix == '':
		raise bb.parse.SkipPackage("slugos kernels require IXP4XX_SUFFIX")
}
