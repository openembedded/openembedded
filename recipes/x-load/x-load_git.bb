require x-load.inc

DEFAULT_PREFERENCE_am3517-evm = "-1"
DEFAULT_PREFERENCE_omap3-pandora = "-1"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/x-load-git/${MACHINE}"

SRCREV = "319b26586fafb86f919f514bcd175838aaab96b3"

PV = "1.42+${PR}+gitr${SRCREV}"
PR ="r8"
PE = "1"

SRC_URI = "git://gitorious.org/x-load-omap3/mainline.git;branch=master;protocol=git"

SRC_URI_append_beagleboard = " \
                              file://name.patch;patch=1 \
                             "

SRC_URI_append_omap3-touchbook = " \
                              file://name.patch;patch=1 \
                              file://screen-off.patch;patch=1 \
                             "


SRC_URI_append_am3517-evm = " \
                                 file://xload-shiva.diff;patch=1 \
"

SRC_URI_omapzoom2 = "git://dev.omapzoom.org/pub/scm/bootloader/x-loader.git;protocol=git \
                     http://www.xora.org.uk/~dp/oe/zoom2.u-boot.git_78e778e0ea884306841c6499851a1e35177d81d0.tar.gz;name=uboot"
SRCREV_omapzoom2 = "599c6cb87ee0c01fd6632b24f6d7e0a2b3ea5d0a"
SRC_URI[uboot.md5sum] = "e68b30714d22ce2f926d2dd19f94a2be"
SRC_URI[uboot.sha256sum] = "e7e5c87d939cc4c1f14d17ea0814b0bed97021c7afca3ef9053c896c2b5bdd6f"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
