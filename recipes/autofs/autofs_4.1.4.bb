require autofs.inc

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/daemons/autofs/v4/autofs-${PV}.tar.bz2;name=archive \
           ${KERNELORG_MIRROR}/pub/linux/daemons/autofs/v4/autofs-4.1.4-misc-fixes.patch;name=patch1 \
           ${KERNELORG_MIRROR}/pub/linux/daemons/autofs/v4/autofs-4.1.4-multi-parse-fix.patch;name=patch2 \
           ${KERNELORG_MIRROR}/pub/linux/daemons/autofs/v4/autofs-4.1.4-non-replicated-ping.patch;name=patch3 \
           file://cross.patch \
           file://Makefile.rules-cross.patch \
	   file://install.patch \
	   file://auto.net-sort-option-fix.patch \
	   file://autofs-additional-distros.patch \
	   file://no-bash.patch"
PR = "${INC_PR}"

inherit update-rc.d

INITSCRIPT_NAME = "autofs"
INITSCRIPT_PARAMS = "defaults"

# FIXME: modules/Makefile has crappy rules that don't obey LDFLAGS
CFLAGS += "${LDFLAGS}"
EXTRA_OEMAKE = "STRIP=/bin/true"
PARALLEL_MAKE = ""

SRC_URI[archive.md5sum] = "7e3949114c00665b4636f0c318179657"
SRC_URI[archive.sha256sum] = "e25caa0e9639ea54dd7c4f21e8146ac9859a61fa126f397edf874b5fdc147430"
SRC_URI[patch1.md5sum] = "6342d6908c35af72b29231ecc6a10b5a"
SRC_URI[patch1.sha256sum] = "4fc5725c683405e0da29021aacb3674c71ce1b61f62b810430aa112644773cf8"
SRC_URI[patch2.md5sum] = "2783f4498c7e90a2cbf93b44d4fc4b94"
SRC_URI[patch2.sha256sum] = "91d852ae612b19862d3925a807c319c74a0a06cc7a8f7390715591b6e1110108"
SRC_URI[patch3.md5sum] = "b7d81c9aa92884d55ce5a1075d49fe78"
SRC_URI[patch3.sha256sum] = "398c921161a57f1d87a5829ea264deed9e2f3adc64ac011f7f0490257d31b633"
