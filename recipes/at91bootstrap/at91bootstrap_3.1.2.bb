require at91bootstrap_3.1.inc
PR = "r0"
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_at91sam9g45ek = "-1"
DEFAULT_PREFERENCE_at91sam9g45ekes = "-1"
DEFAULT_PREFERENCE_at91sam9m10ek = "-1"
DEFAULT_PREFERENCE_at91sam9m10ekes = "-1"

DEFAULT_PREFERENCE_at91sam9g15ek = "2"
DEFAULT_PREFERENCE_at91sam9g25ek = "2"
DEFAULT_PREFERENCE_at91sam9g35ek = "2"
DEFAULT_PREFERENCE_at91sam9x25ek = "2"
DEFAULT_PREFERENCE_at91sam9x35ek = "2"
DEFAULT_PREFERENCE_at91sam9g20ek_2mmc = "3"

SRC_URI = "ftp://ftp.linux4sam.org/pub/at91bootstrap/AT91Bootstrap3.1/AT91Bootstrap-5series_1.2.tgz \
           "

SRC_URI_append = "\
	file://at91bootstrap-3.1.2/0003-Add-some-useful-files-utilities.patch \
	file://at91bootstrap-3.1.2/0004-.gitignore-Do-not-track-files-in-the-install-directo.patch \
	file://at91bootstrap-3.1.2/0005-Makefile-Create-BOOT.BIN-with-capital-letters-for-SD.patch \
	file://at91bootstrap-3.1.2/0006-Makefile-Use-BOARD-instead-of-BOARDNAME.patch \
	file://at91bootstrap-3.1.2/0007-afeb9260-Remove-old-unused-files.patch \
	file://at91bootstrap-3.1.2/0008-Makefile-Avoid-complaint-about-CROSS_COMPILE.patch \
	file://at91bootstrap-3.1.2/0009-.gitignore-Do-not-track-.rej.patch \
	file://at91bootstrap-3.1.2/0010-alternate-boot-Support-booting-from-two-sources.patch \
	file://at91bootstrap-3.1.2/0011-build-scripts-Update-buildscripts.patch \
	file://at91bootstrap-3.1.2/0012-Update-all-defconfigs.patch \
	file://at91bootstrap-3.1.2/0013-Update-version-to-3.1.1.patch \
	file://at91bootstrap-3.1.2/0014-Do-not-track-patches.patch \
	file://at91bootstrap-3.1.2/0015-Makefile-Better-cleanup.patch \
	file://at91bootstrap-3.1.2/0016-Update-version-to-3.1.1.patch \
	file://at91bootstrap-3.1.2/0017-all-Clean-up-include-mess.patch \
	file://at91bootstrap-3.1.2/0018-Makefile-Revert-change-which-broke-MAKEALL.patch \
	file://at91bootstrap-3.1.2/0019-Improve-printout-of-MAKEALL.patch \
	file://at91bootstrap-3.1.2/0020-config-conf.c-Remove-cause-of-warnings.patch \
	file://at91bootstrap-3.1.2/0021-Remove-warnings-from-build.patch \
	file://at91bootstrap-3.1.2/0022-Bump-version-to-3.1.2.patch \
	file://at91bootstrap-3.1.2/0023-Allow-SAM9G20-to-use-partitions.patch \
	file://at91bootstrap-3.1.2/0024-More-verbose-error-messages-for-FAT-access.patch \
	file://at91bootstrap-3.1.2/0025-Add-at91sam9g20ek_2mmcsd_defconfig.patch \
	file://at91bootstrap-3.1.2/0026-.gitignore-Update.patch \
	file://at91bootstrap-3.1.2/0027-Update-build-scripts.patch \
	file://at91bootstrap-3.1.2/0028-at91sam9g20ek_2mmc-add-BSP.patch \
	file://at91bootstrap-3.1.2/0029-Update-defconfigs.patch \
	file://at91bootstrap-3.1.2/0030-Remove-some-faulty-defconfigs-wrong-location.patch \
	file://at91bootstrap-3.1.2/0031-Config.in-configurable-application.patch \
	file://at91bootstrap-3.1.2/0032-Update-WinCE-build-ffiles-for-_2mmc.patch \
	file://at91bootstrap-3.1.2/0033-Update-boards-and-dirs-files.patch \
	file://at91bootstrap-3.1.2/0034-Add-at91sam9g20ek_2mmc-to-part.h.patch \
	file://at91bootstrap-3.1.2/0035-Allow-SAM9G20EK-_2MMC-to-use-partitions.patch \
	file://at91bootstrap-3.1.2/0036-at91sam9g20ek_2mmc-support-loading-linux.patch \
	file://at91bootstrap-3.1.2/0037-Use-up-to-date-debug-logging.patch \
	file://at91bootstrap-3.1.2/0038-Avoid-warnings-on-gcc-4.6.patch \
	file://at91bootstrap-3.1.2/0039-Add-falback-images-for-SD-Card.patch \
	file://at91bootstrap-3.1.2/0040-Fix-autoconf.h.patch \
	file://at91bootstrap-3.1.2/0041-Fix-EXTRA_INSTALL-add-missing.patch \
	file://at91bootstrap-3.1.2/0042-U-Boot-may-not-be-in-a-subdirectory.patch \
	file://files/AT91SAM9G45_RomCode_Replacement_13.bin.zip;apply=no;unpack=no \
	file://files/NAND-empty-1MB.jffs2.bz2;apply=no;unpack=no \
	file://files/SD-card-tools.tar.bz2;apply=no;unpack=no \
	"

# S = "${WORKDIR}/${PN}-${PV}"
S = "${WORKDIR}/AT91Bootstrap-5series_1.2"

addtask do_configure_utilities before do_compile after do_patch

do_configure_utilities () {
	cp	${WORKDIR}/files/* ${S}/files
}


SRC_URI[md5sum] = "acfd06daae068ebda508f8c0b97b8255"
SRC_URI[sha256sum] = "b6829e3199fb6b54fde82f28cc567c7dc298b57e65cd910d9bbf9bac14ac7273"

