require at91bootstrap_3.0.inc
PR = "r3"
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_at91sam9g45ek = "3"
DEFAULT_PREFERENCE_at91sam9g45ekes = "3"
DEFAULT_PREFERENCE_at91sam9m10ek = "3"
DEFAULT_PREFERENCE_at91sam9m10ekes = "3"

SRC_URI = "ftp://ftp.linux4sam.org/pub/Android4SAM/9m10g45/v1.1/patches/bootstrap30.tar.gz \
           "

SRC_URI_append = " \
	file://0001-Update-.gitignore.patch;apply=yes \
	file://0002-Add-KConfig-support-for-booting-U-Boot.patch;apply=yes \
	file://0003-Generate-a-BOOT.BIN-file-instead-of-boot.bin.patch;apply=yes \
	file://0004-Add-support-for-dual-boot.patch;apply=yes \
	file://0005-Remove-old-afeb9260-files.patch;apply=yes \
	file://0006-Use-BOARD-instead-of-BOARDNAME-to-define-directory.patch;apply=yes \
	file://0007-Add-board-support-for-alternate-boot.patch;apply=yes \
	file://0008-Clean-up-printouts.patch;apply=yes \
	file://0009-Update-configs.patch;apply=yes \
	file://0010-Update-build-scripts.patch;apply=yes \
	file://0011-Fix-Cut-n-Paste-error.patch;apply=yes \
	file://0013-Fix-Cut-n-Paste-error-in-Makefile.patch;apply=yes \
	file://0014-Add-support-for-alternate-jump-address.patch;apply=yes \
	file://0015-Make-MAKENEW-useful.patch;apply=yes \
	file://0016-Update-configs.patch;apply=yes \
	"

# S = "${WORKDIR}/${PN}-${PV}"
S = "${WORKDIR}/bootstrap30"

SRC_URI[md5sum] = "a70f09198555d343de376014f9681f32"
SRC_URI[sha256sum] = "90eccf7d639f4cf11ec8a3e0654aeb7e43382fd3bcbe9f234f9e9faeb1ed0ccd"

