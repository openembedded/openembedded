require linux.inc

PR = "r4"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_akita = "1"
DEFAULT_PREFERENCE_c7x0 = "1"
DEFAULT_PREFERENCE_collie = "1"
DEFAULT_PREFERENCE_poodle = "1"
DEFAULT_PREFERENCE_spitz = "1"
DEFAULT_PREFERENCE_tosa = "1"
#DEFAULT_PREFERENCE_om-gta01 = "1"
#DEFAULT_PREFERENCE_om-gta02 = "1"
DEFAULT_PREFERENCE_h1940 = "1"
DEFAULT_PREFERENCE_at91sam9g35ek = "1"

AT91_MIRROR = "ftp://ftp.linux4sam.org/pub/linux"
AT91_EXPERIMENTAL = "at91-exp"
AT91_PATCH = "${PV}-${AT91_EXPERIMENTAL}"
AT91_PATCH_DIR = ${WORKDIR}/${AT91_PATCH}"
AT91_PATCH_LIST = "${AT91_PATCH_DIR}/series

SRC_URI = "${KERNELSRC_MIRROR}/v2.6/linux-${PV}.tar.bz2;name=kernel \
           ${KERNELSRC_MIRROR}/v2.6/patch-${PV}.2.bz2;apply=yes;name=stablepatch \
           file://defconfig "

SRC_URI_append_om-gta01 = " \
           file://openmoko.patch \
           file://shr.patch \
           "

SRC_URI_append_om-gta02 = " \
           file://openmoko.patch \
           file://shr.patch \
           "

SRC_URI_append_at91 = 	" \
	   ${AT91_MIRROR}/${PV}-at91/${AT91_PATCH}.tar.gz;apply=no;name=at91-exp"

addtask do_apply_at91_exp_patch before do_patch after do_unpack

do_apply_at91_exp_patch () {
	cd	${AT91_PATCH_DIR}
	ls	*.patch > ${AT91_PATCH_LIST}
	cd	${S}
	for	f in `cat ${AT91_PATCH_LIST}` ; do
		cat $f	| patch -p1
	done
}

SRC_URI_append_akita = " file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 "
SRC_URI_append_c7x0 = " file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 "
SRC_URI_append_collie = " file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 "
SRC_URI_append_poodle = " file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 "
SRC_URI_append_tosa = " file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 "
SRC_URI_append_spitz = " file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2 "

SRC_URI[kernel.md5sum] = "1aab7a741abe08d42e8eccf20de61e05"
SRC_URI[kernel.sha256sum] = "584d17f2a3ee18a9501d7ff36907639e538cfdba4529978b8550c461d45c61f6"
SRC_URI[stablepatch.md5sum] = "6f81e64e790eb7847773eec4f7cbf207"
SRC_URI[stablepatch.sha256sum] = "c0ef45692a80656ffb462c5b45b6226dc9c78b074f24164992c2a1eaf0ba5b78"
SRC_URI[at91-exp.md5sum] = "5ef5bcb680a4f799a7bd16b2dc62d157"
SRC_URI[at91-exp.sha256sum] = "01fe8819ab40086aa4d73d4ea777db93d4354723a8a43133be60812f50779898"
