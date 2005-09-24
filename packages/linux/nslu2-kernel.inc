# nslu2-kernel.inc
#
# Standard definitions for any NSLU2 Linux kernel.
# Include this file in a .bb which specifies, at least,
# PN,PV,PR for the desired kernel
#
# Define the following *before* including this file as
# required:
#
# N2K_EXTRA_FILES - kernel-tree path of extra files to install
# N2K_FILES - kernel-tree path of files to install, defaults to:
#   drivers/i2c/chips/x1205-rtc.c
#   arch/arm/mach-ixp4xx/nslu2-io.c
#   arch/arm/mach-ixp4xx/nslu2-setup.c
#   arch/arm/mach-ixp4xx/nslu2-pci.c
#   arch/arm/mach-ixp4xx/nslu2-part.c
#   include/asm-arm/arch-ixp4xx/nslu2.h
#   ${N2K_EXTRA_FILES}
#
# N2K_EXTRA_PATCHES - list of patches to apply (can include
#   patches to the files installed above)
# N2K_PATCHES - full list of patches to apply, defaults to:
#   file://nslu2_2.6.11.patch;patch=1
#   file://usbnet.patch;patch=1
#   file://ixp4xx_copy_from.patch;patch=1
#   file://anonymiser.patch;patch=1
#   file://xscale-reset.patch;patch=1
#   file://mtd-shutdown.patch;patch=1
#   ${N2K_EXTRA_PATCHES}
#
# N2K_SUFFIX - the suffix to add after 'zImage-' in the
#   deploy/images directory - defaults to "openslug"
#
# Notice that the N2K_PATCHES list is appropriate for
# openslug-kernel_2.6.11.2 and probably nothing else.
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
# Within this file bitbake variables local to the file are
# named N2K_FOO
#
SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Linksys NSLU2 device"
LICENSE = "GPL"
MAINTAINER = "John Bowler <jbowler@acm.org>"

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
#	openslug-kernel-2.6.11.2
#	nslu2-kernel/files
#	nslu2-kernel/X.Y
#	nslu2-kernel/X.Y.Z
#	nslu2-kernel/X.Y.Z-patch
#	nslu2-kernel/X.Y.Z-patchP
#	package-X.Y.Z-patchP
#
# This allows sharing of patch files and other useful source!
# To share a file or patch with an earlier version put it in
# the shared directory - e.g. to use foo.patch on 2.6.11.2 and
# 2.6.11.4 it should be in directory nslu2-kernel/2.6.11.
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
    filedir = "${FILE_DIRNAME}/nslu2-kernel/%s"
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
	    raise bb.build.FuncFailed("nslu2-kernel: patch %s not recognized in %s" % (patch, '-'.join(pv)))
	filepath[0:0] = [ filedir % pname ]
	base = pname

    base = '.'.join(kernel)
    patch_uri[0] = "ftp://ftp.kernel.org/pub/linux/kernel/v%s/linux-%s.tar.bz2" % (major, base)
    filepath[-1:-1] = [ filedir % base ]
    if base != minor:
	    filepath[-1:-1] = [ filedir % minor ]
    filepath[-1:-1] = [ filedir % major ]

    bb.data.setVar("N2K_SRCMAJ", major, d)
    # bb.note("N2K_SRCMAJ := %s" % major)
    bb.data.setVar("N2K_SRCVER", base, d)
    # bb.note("N2K_SRCVER := %s" % base)
    bb.data.setVar("N2K_SRCURI", ' '.join(patch_uri), d)
    # bb.note("N2K_SRCURI := %s" % ' '.join(patch_uri))
    bb.data.setVar("N2K_FILESPATH", ':'.join(filepath), d)
    # bb.note("N2K_FILESPATH := %s" % ' '.join(filepath))
    bb.data.setVar("DEFAULT_PREFERENCE", pref-mmac, d)
    # bb.note("DEFAULT_PREFERENCE := %s" % (pref-mmac))
}

# FILESPATH: this list is in order last-searched-first, therefore
# the first entry is the *latest* and/or most specific
FILESPATH = "${FILE_DIRNAME}/${P}:${N2K_FILESPATH}:${FILE_DIRNAME}/openslug-kernel-2.6.11.2"

# The working directory will be the 'base' version (which may not be the
# same as implied by the PV variable because it corresponds to the prior
# minor version for rc and pre patched versions).
S = "${WORKDIR}/linux-${N2K_SRCVER}"

# N2K_FILES is a list of additional files added to the source, these are
# put in place before the patches, so may themselves be patched.  The list
# gives the path name relative to the base of the kernel source tree, the
# base file name is used to *find* the file.
N2K_EXTRA_FILES ?=
N2K_FILES ?= "\
    drivers/i2c/chips/x1205-rtc.c \
    arch/arm/mach-ixp4xx/nslu2-io.c \
    arch/arm/mach-ixp4xx/nslu2-setup.c \
    arch/arm/mach-ixp4xx/nslu2-pci.c \
    arch/arm/mach-ixp4xx/nslu2-part.c \
    include/asm-arm/arch-ixp4xx/nslu2.h \
    ${N2K_EXTRA_FILES}"

N2K_SRCFILES = "${@( ' '.join([ ("file://" + n2k_file.split('/')[-1]) for n2k_file in bb.data.getVar("N2K_FILES",d,1).split(None) ]) )}"

# N2K_PATCHES is a list of additional patches, the list specified
# here comes from the openslug-2.6.11.2 kernel, typically extra
# patches will be required and very often patches will need to
# be removed (i.e. the default is typically not very useful!)
N2K_EXTRA_PATCHES ?=
N2K_PATCHES ?= "\
    file://nslu2_2.6.11.patch;patch=1 \
    file://usbnet.patch;patch=1 \
    file://ixp4xx_copy_from.patch;patch=1 \
    file://anonymiser.patch;patch=1 \
    file://xscale-reset.patch;patch=1 \
    file://mtd-shutdown.patch;patch=1 \
    ${N2K_EXTRA_PATCHES}"

N2K_SUFFIX ?= "openslug"

SRC_URI  = "${N2K_SRCURI}"
SRC_URI += "${N2K_SRCFILES}"
SRC_URI += "${N2K_PATCHES}"
SRC_URI += "file://defconfig"

COMPATIBLE_HOST = 'arm.*-linux'

inherit kernel

ARCH = "arm"
KERNEL_IMAGETYPE = "zImage"
# To specify the console set KERNEL_CONSOLE in the .bb file.
# CMDLINE_ROOT contains the boot options, CMDLINE_KERNEL_OPTIONS
# contains the things for a specific kernel.
CMDLINE_KERNEL_OPTIONS ?= "reboot=s"
CMDLINE_ROOT ?= "root=/dev/mtdblock4 rw rootfstype=jffs2 mem=32M@0x00000000 init=/linuxrc"
# Add distro specific debug (or non-debug) options to this
CMDLINE_DEBUG ?= ""
CMDLINE = "${CMDLINE_ROOT} ${CMDLINE_KERNEL_OPTIONS} ${CMDLINE_DEBUG} ${CMDLINE_CONSOLE}"

# Add the architecture compiler flags to KERNEL_CC and KERNEL_LD as
# required.  Notice that this has to be done for each separately built
# module as well!
KERNEL_CC += "${TARGET_CC_KERNEL_ARCH}"
KERNEL_LD += "${TARGET_LD_KERNEL_ARCH}"

# By putting the added files in place in a separate task before
# do_patch it becomes possible to patch these files.
do_unpacklocal() {
	for f in ${N2K_FILES}
	do
		s="$(basename "$f")"
		install -m 0644 "${WORKDIR}/$s" "${S}/$f"
	done
}

addtask unpacklocal before do_patch after do_unpack

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config
	rm -rf ${S}/include/asm-arm/arch ${S}/include/asm-arm/proc \
	       ${S}/include/asm-arm/.proc ${S}/include/asm-arm/.arch
}

do_deploy[dirs] = "${S}"
do_deploy() {
        install -d ${DEPLOY_DIR}/images
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR}/images/${KERNEL_IMAGETYPE}-${N2K_SUFFIX}
}

addtask deploy before do_build after do_compile

python () {
	# Don't build the kernel unless we're targeting an nslu2
	mach = bb.data.getVar("MACHINE", d, 1)
	if mach != 'nslu2':
		raise bb.parse.SkipPackage("OpenSlug only builds for the Linksys NSLU2")
}
