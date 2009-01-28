require linux-kexecboot.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_hx4700 = "1"
DEFAULT_PREFERENCE_h2200 = "1"

SRC_URI = "${HANDHELDS_CVS};module=linux/kernel26;tag=${@'K' + bb.data.getVar('PV',d,1).replace('.', '-')} \
           file://linux-2.6.git-9d20fdd58e74d4d26dc5216efaaa0f800c23dd3a.patch;patch=1 \
           http://www.rpsys.net/openzaurus/patches/archive/export_atags-r0a.patch;patch=1 \
           file://gcc4x-limits.patch;patch=1 \
	   file://defconfig"

S = "${WORKDIR}/kernel26"
