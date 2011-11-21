require linux.inc

PR = "r2"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

DEFAULT_PREFERENCE_at91sam9260ek	= "3"
DEFAULT_PREFERENCE_at91sam9261ek	= "3"
DEFAULT_PREFERENCE_at91sam9263ek	= "3"
DEFAULT_PREFERENCE_at91sam9g10ek	= "3"
DEFAULT_PREFERENCE_at91sam9g20ek	= "3"
DEFAULT_PREFERENCE_at91sam9g20ek_2mmc	= "3"
DEFAULT_PREFERENCE_at91sam9g35ek	= "3"
DEFAULT_PREFERENCE_at91sam9g45ek	= "3"
DEFAULT_PREFERENCE_at91sam9g45ekes	= "3"
DEFAULT_PREFERENCE_at91sam9m10ekes	= "3"
DEFAULT_PREFERENCE_at91sam9m10g45ek	= "3"
DEFAULT_PREFERENCE_at91sam9rlek		= "3"
DEFAULT_PREFERENCE_at91sam9x5ek		= "3"
DEFAULT_PREFERENCE_at572d940hfek	= "3"

KERNELORG_MIRROR="ftp://ftp.sunet.se/pub/Linux/kernel.org"

AT91_EXPERIMENTAL = ""

SRC_URI = " \
	${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
	file://at91/0001-Support-configurable-NAND-partitions-for-Atmel-at91-.patch \
	file://at91/0002-at91-defconfigs-add-tmpfs-and-ubi.patch \
	file://at91/0003-Revert-diopsis-NAND-patch-affected-NOR-flash.patch \
	file://at91/0004-Add-MMC-debugging.patch \
	file://at91/0005-Add-sam9g20_2mmc-defconfig-with-MMC-debugging.patch \
	file://defconfig	\
	"

SRC_URI_append_at91 = 	"ftp://ftp.linux4sam.org/pub/linux/2.6.39-at91/2.6.39-at91-exp${AT91_EXPERIMENTAL}.tar.gz;apply=no;name=at91exp${AT91_EXPERIMENTAL}"

addtask do_apply_at91_exp_patch before do_patch after do_unpack

do_apply_at91_exp_patch () {
	cd	${S}
	for	f in `ls ../2.6.39-at91-exp${AT91_EXPERIMENTAL}/*.patch` ; do
		cat $f	| patch -p1
	done
}

#SRC_URI[kernel.md5sum] = "1aab7a741abe08d42e8eccf20de61e05"
#SRC_URI[kernel.sha256sum] = "584d17f2a3ee18a9501d7ff36907639e538cfdba4529978b8550c461d45c61f6"
SRC_URI[kernel.md5sum] = "51be93d92028658ec93f68b79a378b17"
SRC_URI[kernel.sha256sum] = "ac46f61dea59273554547ca3a11e64706722ccefd8e2dc94a831faf31412da22"
SRC_URI[stablepatch.md5sum] = "6f81e64e790eb7847773eec4f7cbf207"
SRC_URI[stablepatch.sha256sum] = "c0ef45692a80656ffb462c5b45b6226dc9c78b074f24164992c2a1eaf0ba5b78"
SRC_URI[at91exp.md5sum] = "5ef5bcb680a4f799a7bd16b2dc62d157"
SRC_URI[at91exp.sha256sum] = "01fe8819ab40086aa4d73d4ea777db93d4354723a8a43133be60812f50779898"

