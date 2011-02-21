require linux.inc

PR = "r6"

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mpc8315e-rdb = "1"
DEFAULT_PREFERENCE_calamari = "-1"
DEFAULT_PREFERENCE_mx27ads = "1"
DEFAULT_PREFERENCE_kixrp435 = "1"
DEFAULT_PREFERENCE_at91sam9g45ekes	= "2"
DEFAULT_PREFERENCE_at91sam9g45ek	= "2"
DEFAULT_PREFERENCE_at91sam9m10ekes	= "2"
DEFAULT_PREFERENCE_at91sam9m10g45ek	= "2"
DEFAULT_PREFERENCE_at91sam9g10ek	= "2"
DEFAULT_PREFERENCE_at91sam9g20ek	= "2"
DEFAULT_PREFERENCE_ronetix-pm9g45	= "2"

# machine boots with it, works but was not tested too much
DEFAULT_PREFERENCE_at91sam9263ek = "-1"
DEFAULT_PREFERENCE_tosa = "-1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.10.bz2;apply=yes;name=stablepatch \
           file://aufs2-30.patch \
           file://defconfig"

SRC_URI_at91 = " \
	   ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
	   http://maxim.org.za/AT91RM9200/2.6/2.6.30-at91.patch.gz;apply=yes;name=at91patch \
	   ftp://www.at91.com/pub/buildroot/2.6.30-exp.2.patch.bz2;apply=yes;name=at91exp2 \
	   file://at91/linux-2.6.30-001-configurable-partition-size.patch.patch \
	   file://at91/linux-2.6.30-002-mach-at91-Kconfig.patch \
	   file://at91/linux-2.6.30-003-sam9m10g45ek.patch \
	   file://defconfig"

SRC_URI_ronetix-pm9g45 = " \
	   ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.10.bz2;apply=yes;name=stablepatch \
	   http://download.ronetix.info/boards/linux/kernel/2.6.30/2.6.30-at91.patch.gz;apply=yes \
	   file://2.6.30-at91-exp.patch \
           file://0001-ads7846-.c-and-.h-add-swap_xy.patch \
           file://0002-add-pm9g45-number-in-mach-types.patch \
           file://0003-print-some-more-info-from-atmel_nand.c.patch \
           file://0004-add-newline-at-the-end-of-uncorrectable-error.patch \
           file://0005-Add-CompactFlash-to-at91sam9g45-architecture.patch \
           file://0006-pm9g45-system-ram-can-be-on-CS1-or-CS6.patch \
           file://0007-add-pm9g45-board.patch \
           file://0008-pm9g45-default-configuration-files.patch \
           file://0009-add-float-flags-in-Makefile.patch \
           file://0010-conditional-compile-if-DEDICATED_VRAM.patch \
           file://0011-add-pm9g45-board-version-1.2-and-adjust-memory-sele.patch \
	   file://defconfig"

#	   http://download.ronetix.info/boards/linux/kernel/2.6.30/
	

SRC_URI_append_mpc8315e-rdb = " file://mpc8315erdb-add-msi-to-dts.patch"

# SRC_URI_append_at91sam9263ek = " file://hrw-linux-2.6.30-exp.patch "

SRC_URI[kernel.md5sum] = "7a80058a6382e5108cdb5554d1609615"
SRC_URI[kernel.sha256sum] = "d7b9f19b92fd5c693c16cd62f441d051b699f28ec6a175d1b464e58bacd8c78f"

SRC_URI[stablepatch.md5sum] = "6485fe0cf0f0220493647505bfd2f7b0"
SRC_URI[stablepatch.sha256sum] = "a1ffb806d7d0083aa8d0525cbccede4172f4a44c8df1ddfeece629b6d8304201"
SRC_URI[at91patch.md5sum] = "f13ab353b11329ce3d605b6f40e77fa6"
SRC_URI[at91patch.sha256sum] = "41991e8aa2e5fe8e5dfd47b1e5c446fa03c3ee96a5eae54fd6ec15d1d9afef30"
SRC_URI[at91exp2.md5sum] = "770c7a2bfb925111a8c0e0d4c8c4764e"
SRC_URI[at91exp2.sha256sum] = "58894965b253eae0c4caacedc3463cf186c18431ca0d71b767a3b36aa40ec388"


