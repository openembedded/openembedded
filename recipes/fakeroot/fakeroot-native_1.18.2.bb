#From: Ulf Samuelsson <ulf@emagii.com>
#Date: Mon, 30 Jan 2012 22:42:08 +0100

DESCRIPTION = "Gives a fake root environment"
HOMEPAGE = "http://fakeroot.alioth.debian.org/"
SECTION = "base"
LICENSE = "GPL"

require fakeroot_${PV}.bb

RDEPENDS_${PN} = "util-linux-native"

SRC_URI += "file://0002-fix-prefix.patch "
S = "${WORKDIR}/fakeroot-${PV}"


SRC_URI[md5sum] = "79f32331358ad58499704ea5e19fd0ae"
SRC_URI[sha256sum] = "9dc942e3ef2ec83c6e6fe59de05da6ab54f39948be64803f37721adab4c6aed8"

inherit native

EXTRA_OECONF = " --program-prefix="

# Compatability for the rare systems not using or having SYSV
python () {
    if bb.data.getVar('HOST_NONSYSV', d, True) and bb.data.getVar('HOST_NONSYSV', d, True) != '0':
        bb.data.setVar('EXTRA_OECONF', ' --with-ipc=tcp --program-prefix= ', d)
}

do_stage_append () {
    oe_libinstall -so libfakeroot ${STAGING_LIBDIR}/libfakeroot/
}

