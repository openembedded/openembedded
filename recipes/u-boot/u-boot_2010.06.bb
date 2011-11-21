PR = "r3"
require u-boot_r2.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_lite5200 = "1"
DEFAULT_PREFERENCE_tqm8540 = "1"
DEFAULT_PREFERENCE_at91sam9g15ek = "2"
DEFAULT_PREFERENCE_at91sam9g25ek = "2"
DEFAULT_PREFERENCE_at91sam9g35ek = "2"
DEFAULT_PREFERENCE_at91sam9x25ek = "2"
DEFAULT_PREFERENCE_at91sam9x35ek = "2"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 \
	ftp://ftp.linux4sam.org/pub/uboot/u-boot-v2010.06/u-boot-5series_1.0.patch;apply=yes;name=at91exp \
	file://0001-Increase-malloc-area-512-kB.patch \
	"

TARGET_LDFLAGS = ""

inherit base


#addtask do_apply_at91_exp_patch before do_patch after do_unpack
#
#do_apply_at91_exp_patch () {
#	cd	${S}
#	cat	patches/u-boot-5series_1.0.patch	| patch -p1
#}


# Override the include file
do_configure () {
	echo
}

do_compile () {
	if ! [ "x${UBOOT_MACHINES}" == "x" ] ; then
		echo ${UBOOT_MACHINES} > board_files.txt
		for board in ${UBOOT_MACHINES} ; do
			if ! [ `grep ${board}_config Makefile | wc -c` == 0 ] ; then
				unset LDFLAGS
				unset CFLAGS
				unset CPPFLAGS
				mkdir -p binaries/${board}
				oe_runmake O=binaries/${board} distclean
				oe_runmake O=binaries/${board} ${board}_config
				oe_runmake O=binaries/${board} all
			fi
#			oe_runmake tools env
		done
	else
	       oe_runmake ${UBOOT_MACHINE}
	       oe_runmake all
	fi
}

SRC_URI[md5sum] = "cd42bc64b6edafa6930ce299a144503e"
SRC_URI[sha256sum] = "790ccb12d99fc527a8b8d20dfdf491795d30f87aa0902f8cbda196583aa20bc8"
SRC_URI[at91exp.md5sum] = "544c71e11a008d914dc507e04c5b7e95"
SRC_URI[at91exp.sha256sum] = "691ba4cba126c2e409f38a0ef8a97d696bbde09804e5c0c9df4cb1ae40243f78"



