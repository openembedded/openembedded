require linux-kexecboot.inc

PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_hx4700 = "1"
DEFAULT_PREFERENCE_h2200 = "1"

SRC_URI = "${HANDHELDS_CVS};module=linux/kernel26;tag=${@'K' + bb.data.getVar('PV',d,1).replace('.', '-')} \
           file://linux-2.6.git-9d20fdd58e74d4d26dc5216efaaa0f800c23dd3a.patch;patch=1 \
           http://www.rpsys.net/openzaurus/patches/archive/export_atags-r0a.patch;patch=1 \
           file://gcc4x-limits.patch;patch=1 \
	   file://defconfig"

SRC_URI += "file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2"

S = "${WORKDIR}/kernel26"


do_configure_append() {
	gzip -d ${S}/initramfs.cpio.gz || true
	sed -i -e s:\.gz::g .config		
}


