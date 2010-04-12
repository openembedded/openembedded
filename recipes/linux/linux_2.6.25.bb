require linux.inc

PR = "r8"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mpc8313e-rdb = "1"
DEFAULT_PREFERENCE_mpc8315e-rdb = "1"
DEFAULT_PREFERENCE_kilauea = "1"
DEFAULT_PREFERENCE_sequoia = "1"
DEFAULT_PREFERENCE_cm-x270 = "-1"
DEFAULT_PREFERENCE_alix = "1"
DEFAULT_PREFERENCE_at32stk1000 = "1"
DEFAULT_PREFERENCE_at91-l9260 = "1"
DEFAULT_PREFERENCE_m8050 = "1"
DEFAULT_PREFERENCE_ronetix-pm9263 = "1"
DEFAULT_PREFERENCE_ronetix-pm9261 = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.25.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.20.bz2;patch=1;name=stablepatch \
           file://defconfig"

SRC_URI_append_mpc8313e-rdb = "\
	file://mpc831x-nand.patch;patch=1 \
	file://mpc8313e-rdb-leds.patch;patch=1 \
	file://mpc8313e-rdb-cardbus.patch;patch=1 \
	"

SRC_URI_append_cm-x270 = " \
	file://0001-cm-x270-match-type.patch;patch=1 \
	file://0002-ramdisk_load.patch;patch=1 \
	file://0003-mmcsd_large_cards-r0.patch;patch=1 \
	file://0004-cm-x270-nand-simplify-name.patch;patch=1 \
	file://0005-add-display-set-default-16bpp.patch;patch=1 \
	"

SRC_URI_append_at32stk1000 = " \
	http://avr32linux.org/twiki/pub/Main/LinuxPatches/linux-2.6.25.6.atmel.1.patch.bz2;patch=1;name=atmelpatch \
	file://virtualmouse.patch;patch=1 \
#    file://pll1.diff;patch=1 \
"

SRC_URI_append_at91-l9260 = " \
	http://maxim.org.za/AT91RM9200/2.6/2.6.25-at91.patch.gz;patch=1;name=at91patch \
"

SRC_URI_append_ronetix-pm9263 = " \
        http://maxim.org.za/AT91RM9200/2.6/2.6.25-at91.patch.gz;patch=1;name=at91patch \
        http://download.ronetix.info/sk-eb926x/linux/kernel/2.6.25.4/linux-2.6.25.4-ronetix-08-11-02.2228.patch;patch=1;name=ronetixpatch \
        http://download.ronetix.info/sk-eb926x/linux/kernel/2.6.25.4/socketcan-driver-at91.patch;patch=1;name=socketat91patch \
"

SRC_URI_append_ronetix-pm9261 = " \
        http://maxim.org.za/AT91RM9200/2.6/2.6.25-at91.patch.gz;patch=1;name=at91patch \
        http://download.ronetix.info/sk-eb926x/linux/kernel/2.6.25.4/linux-2.6.25.4-ronetix-08-11-02.2228.patch;patch=1;name=ronetixpatch \
        http://download.ronetix.info/sk-eb926x/linux/kernel/2.6.25.4/socketcan-driver-at91.patch;patch=1;name=socketat91patch \
"

SRC_URI_append_m8050 = " file://m8050.diff;patch=1 file://update-mach-types.diff;patch=1"

CMDLINE_cm-x270 = "console=${CMX270_CONSOLE_SERIAL_PORT},38400 monitor=1 mem=64M mtdparts=physmap-flash.0:256k(boot)ro,0x180000(kernel),-(root);cm-x270-nand:64m(app),-(data) rdinit=/sbin/init root=mtd3 rootfstype=jffs2"

FILES_kernel-image_cm-x270 = ""

python do_compulab_image() {
	import os
	import os.path
	import struct

	machine = bb.data.getVar('MACHINE', d, 1)
	if machine == "cm-x270":
	    deploy_dir = bb.data.getVar('DEPLOY_DIR_IMAGE', d, 1)
	    kernel_file = os.path.join(deploy_dir, bb.data.expand('${KERNEL_IMAGE_BASE_NAME}', d) + '.bin')
	    img_file = os.path.join(deploy_dir, bb.data.expand('${KERNEL_IMAGE_BASE_NAME}', d) + '.cmx270')

	    fo = open(img_file, 'wb')

	    image_data = open(kernel_file, 'rb').read()

	    # first write size into first 4 bytes
	    size_s = struct.pack('i', len(image_data))

	    # truncate size if we are running on a 64-bit host
	    size_s = size_s[:4]

	    fo.write(size_s)
	    fo.write(image_data)
	    fo.close()

	    os.chdir(deploy_dir)
	    link_file = bb.data.expand('${KERNEL_IMAGE_SYMLINK_NAME}', d) + '.cmx270'
	    img_file = bb.data.expand('${KERNEL_IMAGE_BASE_NAME}', d) + '.cmx270'
	    try:
		os.unlink(link_file)
	    except:
		pass
	    os.symlink(img_file, link_file)
}


addtask compulab_image after do_deploy before do_build


SRC_URI[kernel.md5sum] = "db95a49a656a3247d4995a797d333153"
SRC_URI[kernel.sha256sum] = "108b2a3f2b05c0e57d1d0977619525e46f8d4b425aef4b38b47dcf94292f2dd2"
SRC_URI[stablepatch.md5sum] = "9d870b9947ce0618cf18445e4be33e15"
SRC_URI[stablepatch.sha256sum] = "c4d69706880f274b84c8f5ef36ce955b3173e6ea3c083f724c0371096b27e738"
SRC_URI[atmelpatch.md5sum] = "816a3d8315ff089ddee3c22c04b403a9"
SRC_URI[atmelpatch.sha256sum] = "03dcb188379fa94cc109d2b7733031de51d6c53d2a7e6701c72ba2ea60e580bc"
SRC_URI[at91patch.md5sum] = "4469d6336f9659f1725fedd4a52261ad"
SRC_URI[at91patch.sha256sum] = "7a960180e7873b1bdb522e76b0423b5c2c1b8efe1d30d7ca80c41eb97d822b2d"
SRC_URI[ronetixpatch.md5sum] = "90f4ad08acff6c206fd08e38db047ea4"
SRC_URI[ronetixpatch.sha256sum] = "db5f14e0d2f2b8d7aa7b7048f858a999a0aee51c422eca92eb814ad4244004e9"
SRC_URI[socketat91patch.md5sum] = "fe6945121eaea5e9c570e3dad54d7569"
SRC_URI[socketat91patch.sha256sum] = "578db455270592833156358f79205b21701aa12b64142da16df08fb36fca3322"
