DESCRIPTION = "wiimote library + tools"
LICENSE = "GPLv2"
HOMEPAGE = "http://abstrakraft.org/cwiid/"

PR = "r0"

inherit autotools
inherit distutils-base

export BUILD_SYS
export HOST_SYS

PARALLEL_MAKE = ""

SRC_URI = "http://abstrakraft.org/cwiid/downloads/cwiid-${PV}.tgz"

EXTRA_OECONF = "--disable-ldconfig"

FILES_${PN} += "\
	/etc/cwiid/wminput/buttons	   \
	/etc/cwiid/wminput/acc_ptr	   \
	/etc/cwiid/wminput/ir_ptr 	   \
	/etc/cwiid/wminput/default	   \
	/etc/cwiid/wminput/nunchuk_acc_ptr \
	/etc/cwiid/wminput/neverball	   \
	/etc/cwiid/wminput/gamepad	   \
"

FILES_${PN}-dbg += "\
	${libdir}/cwiid/plugins/.debug \
"

do_configure_append() {
	find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
 	find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
}



SRC_URI[md5sum] = "8d574afdeedc5e5309c87a72d744316a"
SRC_URI[sha256sum] = "8880378303d872ea65b037184ad6c96bc68f87764b503c152032f56344b5e81d"
