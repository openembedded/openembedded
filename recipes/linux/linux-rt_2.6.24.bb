require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mpc8313e-rdb = "1"
DEFAULT_PREFERENCE_mpc8315e-rdb = "1"

PR = "r9"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.24.tar.bz2;name=kernel \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-2.6.24.7.bz2;patch=1;p=1;name=patch24.7 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/projects/rt/patch-2.6.24.7-rt27.bz2;patch=1;p=1;name=patchrt27 \
           file://squashfs-lzma-2.6.24.patch;patch=1 \
           file://powerpc-clockres.patch;patch=1 \
           file://defconfig"

#           file://sysctl_missing_include.patch;patch=1 \

S = "${WORKDIR}/linux-2.6.24"

SRC_URI_append_mpc8313e-rdb = " \
           file://leds-cpu-activity.patch;patch=1 \
           file://leds-cpu-activity-powerpc.patch;patch=1 \
           file://mpc8313e-rdb-leds.patch;patch=1"
#	file://mpc831x-nand.patch;patch=1 \
#	file://mpc8313e-rdb-rtc.patch;patch=1 "


# override the device tree source file from linux.inc, as the patches below
# introduce new variants. -- Leon Woestenberg
KERNEL_DEVICETREE_mpc8315e-rdb = "arch/${ARCH}/boot/dts/mpc8315erdb_default.dts"

# Patch series taken from MPC8315ERDB_20080627-ltib.iso, available as-is from
# Freescale's web site. Patches also available at www.bitshrine.org, which I
# use here. -- Leon Woestenberg <leon@sidebranch.com>

SRC_URI_mpc8315e-rdb = " \
${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.24.tar.bz2;name=kernel \
${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-2.6.24.3.bz2;patch=1;p=1;name=patch24.3 \
${KERNELORG_MIRROR}/pub/linux/kernel/projects/rt/older/patch-2.6.24.3-rt3.bz2;patch=1;p=1;name=patchrt3 \
file://squashfs-lzma-2.6.24.patch;patch=1 \
file://powerpc-clockres.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-platform-support.patch;patch=1;name=patchmpc1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-add-all-interrupts.patch;patch=1;name=patchmpc2 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-Realtek-821x-phy.patch;patch=1;name=patchmpc3 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-fix-gianfar.patch;patch=1;name=patchmpc4 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-Gianfar-buffer-recycling.patch;patch=1;name=patchmpc5 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-Gianfar-performance.patch;patch=1;name=patchmpc6 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-sata-support.patch;patch=1;name=patchmpc7 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-fsl-serdes-support.patch;patch=1;name=patchmpc8 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-pcie-INTx-support.patch;patch=1;name=patchmpc9 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-ipic-msi.patch;patch=1;name=patchmpc10 \ 
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-usb-support.patch;patch=1;name=patchmpc11 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-power-management.patch;patch=1;name=patchmpc12 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-usb-power-mangement.patch;patch=1;name=patchmpc13 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-NAND-flash.patch;patch=1;name=patchmpc14 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-elbc-jffs2-on-nand.patch;patch=1;name=patchmpc15 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-Codewarrior-kernel-debug.patch;patch=1;name=patchmpc16 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-otg.patch;patch=1;name=patchmpc17 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC831x-LFC.patch;patch=1;name=patchmpc18 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-TDM.patch;patch=1;name=patchmpc19 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-tdm-test-modules.patch;patch=1;name=patchmpc20 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-spi-for-tdm-module.patch;patch=1;name=patchmpc21 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-port-mutiplier-in-sata.patch;patch=1;name=patchmpc22 \ 
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-performance-monitor.patch;patch=1;name=patchmpc23 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-ieee-1588.patch;patch=1;name=patchmpc24 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-DTS.patch;patch=1;name=patchmpc25 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-sata-pm.patch;patch=1;name=patchmpc26 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-fix-large-file-transfer.patch;patch=1;name=patchmpc27 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-default-configuration.patch;patch=1;name=patchmpc28 \
file://defconfig \
"

# Last 5 patches in the series, for crypto stuff. The 2nd of these is created
# against crypto/ocf/ and thus needs a proper rebase against the base dir.
# This remains a todo. -- Leon Woestenberg.
#SRC_URI_append_mpc8315e-rdb = " \
#http://www.bitshrine.org/gpp/ocf-linux-26-20071215.patch.gz;patch=1;name=patchmpc29 \
#http://www.bitshrine.org/gpp/ocf-linux-20071215-20080427.diff;patch=1;name=patchmpc30 \
#http://www.bitshrine.org/gpp/linux-fsl-2.6.24-OCF-fsl_soc-2.patch;patch=1;name=patchmpc31 \
#http://www.bitshrine.org/gpp/linux-2.6.24-Openswan-2.4.12.patch;patch=1;name=patchmpc32 \
#http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-openswan-sysctl.patch;patch=1;name=patchmpc33 \
#"

SRC_URI[kernel.md5sum] = "3f23ad4b69d0a552042d1ed0f4399857"
SRC_URI[kernel.sha256sum] = "413c64fbbcf81244cb5571be4963644a1e81166a2b0f008a016528363b65c5d3"
SRC_URI[patch24.7.md5sum] = "0c1c5d6d8cd82e18d62406d2f34d1d38"
SRC_URI[patch24.7.sha256sum] = "b6bbb0dea427aa733c37d58a94b819b523c8649d7605f498348de159380c28a1"
SRC_URI[patchrt27.md5sum] = "51b5510354c471f5fb721cc294e375b7"
SRC_URI[patchrt27.sha256sum] = "09634e9f3becaec8b3ce57ba9b3b70ef69e9681518857a5ab6421d82ef722c99"
SRC_URI[patch24.3.md5sum] = "4c42be33a7d98f280588c9d28478cdfd"
SRC_URI[patch24.3.sha256sum] = "07cb052791e8b873d491502ebe98a193c0edc003fd816e721739e1f2e8e3648b"
SRC_URI[patchrt3.md5sum] = "281a7f7ecdfc735b83daa7c48d996781"
SRC_URI[patchrt3.sha256sum] = "703c8e0efdb063c843b53608b63d3d3d2df038fd9abd280c1fc594d35df945f8"
SRC_URI[patchmpc1.md5sum] = "e93ee28ac09b795bfff9890d9f9ca2b3"
SRC_URI[patchmpc1.sha256sum] = "57975de977b129c4dbe5f73b1e2a4d79db00802ec06005785642968feac3b640"
SRC_URI[patchmpc2.md5sum] = "e431ea80106653fb1d9eaf8675ac3423"
SRC_URI[patchmpc2.sha256sum] = "88cf80e2dd6d94bb7886211092ecb9e7d22ded4f332cb968ed6bf715b119b63c"
SRC_URI[patchmpc3.md5sum] = "beeb35979b7ede0aa991fa11d54a5371"
SRC_URI[patchmpc3.sha256sum] = "945cced8c57c30d87925c807e397198d43ee617b3d25e49db960bebd21ccc87c"
SRC_URI[patchmpc4.md5sum] = "e4caabaceab06c3352ef1632c552b217"
SRC_URI[patchmpc4.sha256sum] = "17a1bdf8c048b54fda794a1c750b45364279184ae6118b93ebf2a5ae9a5cef47"
SRC_URI[patchmpc5.md5sum] = "8cfb60aefa8853302872822d620f6336"
SRC_URI[patchmpc5.sha256sum] = "cda28fe61b53175e1ec4f520b221a1c1736d85030ed7780e621fe0323c3308f1"
SRC_URI[patchmpc6.md5sum] = "f63474fb3701a77484ef688981e2c7d4"
SRC_URI[patchmpc6.sha256sum] = "02233e821ae86d0cae11385c96d0abb70a0fdd0abc5b2cea8ec9ab9df0f8c28a"
SRC_URI[patchmpc7.md5sum] = "9f35c10738964e4b3e416e5908b0a97e"
SRC_URI[patchmpc7.sha256sum] = "2f5700be59c6148f53cb40890c67f8bba712177a66961717ed9021f22597e1ef"
SRC_URI[patchmpc8.md5sum] = "2b92520a407561668a47d65798861513"
SRC_URI[patchmpc8.sha256sum] = "d4bdacaa898bf701eacd5f8709313686f87bde834f41e2ba8c62fe4c05682037"
SRC_URI[patchmpc9.md5sum] = "3657e64546afc5d0640aaf161f1e3046"
SRC_URI[patchmpc9.sha256sum] = "ca786186f12fc8572a227e2f8ebd0e6bac35dd43f7720ee2c730b44cf4c4c916"
SRC_URI[patchmpc10.md5sum] = "953c4dd70a7b9bb09d9af3363d7b74b1"
SRC_URI[patchmpc10.sha256sum] = "720d8c6cdb4cb7bd1f7f28c2a021c0982f718ccf03069c35c63f6c56377d84e0"
SRC_URI[patchmpc11.md5sum] = "d79602c1034b7ceb239ede189829769b"
SRC_URI[patchmpc11.sha256sum] = "16b8be4278f2010a80e646bac0ee38ea874635b4886b49dd92f8e566f2ec4b05"
SRC_URI[patchmpc12.md5sum] = "b47533bc76c2752426a6243991f38f7e"
SRC_URI[patchmpc12.sha256sum] = "c392d58a0d3fb82051e305f579b320247efd02b2896bba453336046fcac6cb1a"
SRC_URI[patchmpc13.md5sum] = "7b6451c392b4dd4d8a52f76861df54e3"
SRC_URI[patchmpc13.sha256sum] = "46ea580d1f223f5d9d00944ca4777d67c4ef585a6a246ed9d3a67745bce38827"
SRC_URI[patchmpc14.md5sum] = "9838fe74adc54f562085085cff0b892b"
SRC_URI[patchmpc14.sha256sum] = "43fb2d488b9b3c5f19dd27c577aecb74a6591a0f8ce36be19fca2686c268da90"
SRC_URI[patchmpc15.md5sum] = "a179f121099ed5857e81a23c748e15a6"
SRC_URI[patchmpc15.sha256sum] = "d285476cc26d7c26c11ca88ac79432b1b172d904b01c7588b1ac9f193114a137"
SRC_URI[patchmpc16.md5sum] = "74de58fbc2ed09c57af9a26303387059"
SRC_URI[patchmpc16.sha256sum] = "94de25d72e507eb45999c4d961e4274371fa5a8e62b8f7eeec603a2b519e4297"
SRC_URI[patchmpc17.md5sum] = "a7c3cedb2e0fffa21e57f870e96d2828"
SRC_URI[patchmpc17.sha256sum] = "4082001edf488d23b99e33fc1d82931da0e7d6130ed5bf67cc1782a016781973"
SRC_URI[patchmpc18.md5sum] = "0e727c10ccb34ed675c8308c58355cd9"
SRC_URI[patchmpc18.sha256sum] = "e66d4f341dd629562c403b9e7499e80de0b76395b0c9405b8ae101de6932c8d5"
SRC_URI[patchmpc19.md5sum] = "36804e234c31a8a4f44590caecea85eb"
SRC_URI[patchmpc19.sha256sum] = "c6ce445fb412184b70a7f9b04c51b71bc275cdbf6c391ccfaccb3960185bc790"
SRC_URI[patchmpc20.md5sum] = "3f0ea9370053471c4f701f737d0fd7f2"
SRC_URI[patchmpc20.sha256sum] = "7731d4a3aa7d27b4eeacc5fba05e259e34358b73858b58435d8262c6ec3c6af7"
SRC_URI[patchmpc21.md5sum] = "ed8cd803d1fb12896ef4d568d1d54406"
SRC_URI[patchmpc21.sha256sum] = "f0b5b9bbe99754d4da7f935bfdacbc92f5a54335727ad9fa42f0b3a480e164d8"
SRC_URI[patchmpc22.md5sum] = "193f371c982d2a49f16b165191537399"
SRC_URI[patchmpc22.sha256sum] = "d03303c8386f733ba768e9dceab7e70365312e2aff3425b8f3c1fc7ee0a70a5e"
SRC_URI[patchmpc23.md5sum] = "7f1633e3746c74b83dce89a6bb5c359f"
SRC_URI[patchmpc23.sha256sum] = "4f225f4a61526f702bec1c5b66bd982ac4220e35219a3e0596c3c548d2b83fb8"
SRC_URI[patchmpc24.md5sum] = "682469238e455005e16b9a958cb5abad"
SRC_URI[patchmpc24.sha256sum] = "10b7af9da11acb9b48f204f0ebc2e742c0fd73a6a13ab926359cb0890592507c"
SRC_URI[patchmpc25.md5sum] = "f20c4644102dc815b2ffc52aa5c28f59"
SRC_URI[patchmpc25.sha256sum] = "4c1e56700bc2023896a512e225f94f74da8f84e4f17de2987bb34ffa457bc8e4"
SRC_URI[patchmpc26.md5sum] = "f875c3b5887a2f68e74f11adb1dd3b94"
SRC_URI[patchmpc26.sha256sum] = "c95be51d302bc60a3b120c9765c3205a09c9eb8c333dc188deacb6e3eaa561d4"
SRC_URI[patchmpc27.md5sum] = "f6f6053536b90b2fed11d90b3409de19"
SRC_URI[patchmpc27.sha256sum] = "4e05232d01c720ae96f6f4c6eb68048fcc0fbd5bffed0dc378f7bf598383c457"
SRC_URI[patchmpc28.md5sum] = "c650194ce3e1ea2396daed6cc3663311"
SRC_URI[patchmpc28.sha256sum] = "d1fe6ef7c263a1d7a689473f019fea550110d5eb7e40d60f7fb9047701a12bbb"
