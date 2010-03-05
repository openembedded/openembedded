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

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.25.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-${PV}.20.bz2;patch=1 \
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
	http://avr32linux.org/twiki/pub/Main/LinuxPatches/linux-2.6.25.6.atmel.1.patch.bz2;patch=1 \
	file://virtualmouse.patch;patch=1 \
#    file://pll1.diff;patch=1 \
"

SRC_URI_append_at91-l9260 = " \
	http://maxim.org.za/AT91RM9200/2.6/2.6.25-at91.patch.gz;patch=1 \
"

SRC_URI_append_ronetix-pm9263 = " \
        http://maxim.org.za/AT91RM9200/2.6/2.6.25-at91.patch.gz;patch=1 \
        http://download.ronetix.info/sk-eb926x/linux/kernel/2.6.25.4/linux-2.6.25.4-ronetix-08-11-02.2228.patch;patch=1 \
        http://download.ronetix.info/sk-eb926x/linux/kernel/2.6.25.4/socketcan-driver-at91.patch;patch=1 \
"

SRC_URI_append_ronetix-pm9261 = " \
        http://maxim.org.za/AT91RM9200/2.6/2.6.25-at91.patch.gz;patch=1 \
        http://download.ronetix.info/sk-eb926x/linux/kernel/2.6.25.4/linux-2.6.25.4-ronetix-08-11-02.2228.patch;patch=1 \
        http://download.ronetix.info/sk-eb926x/linux/kernel/2.6.25.4/socketcan-driver-at91.patch;patch=1 \
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

