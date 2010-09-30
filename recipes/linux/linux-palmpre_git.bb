require linux.inc

SECTION = "kernel"
DESCRIPTION = "Modified kernel for the Palm Pre based on the original source from Palm Inc."
KERNEL_IMAGETYPE = "uImage"

SRC_URI = " \
git://git.freesmartphone.org/linux-2.6.git;protocol=git;branch=palmpre/master \
file://defconfig \
"

S = "${WORKDIR}/git/"

SRCREV = "33239e4074f4716a674b450a443b64add201bf39"
KV = "2.6.24"
PR="r3"
PV = "${KV}+gitr${SRCPV}"

# linux.inc overrides LOCAVERSION but we like to stay with the one used originally
do_compile_prepend() {
	sed -i -e '/CONFIG_LOCALVERSION=/d' ${S}/.config
	echo 'CONFIG_LOCALVERSION="-joplin-3430"' >>${S}/.config
}
